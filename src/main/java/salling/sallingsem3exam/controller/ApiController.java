package salling.sallingsem3exam.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import salling.sallingsem3exam.service.MadplanService;
import salling.sallingsem3exam.service.RecipeService;
import org.springframework.web.bind.annotation.ResponseBody;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080") // Tillad kun anmodninger fra din frontend
@RestController
public class ApiController {
  
    private final MadplanService madplanService;
    private final RecipeService recipeService;

    @Value("${api.token}") // Token hentes fra application.properties
    private String apiToken;

    private final RestTemplate restTemplate = new RestTemplate();


    public ApiController(MadplanService madplanService, RecipeService recipeService) {
        this.madplanService = madplanService;
        this.recipeService = recipeService;
    }


    @GetMapping("/madplan/{id}/recipes")
    @ResponseBody
    public List<Recipe> getRecipesForMadplan(@PathVariable int id) {
        return madplanService.getRecipesFromMadplan(id);
    }

    @GetMapping("/madplan/{id}/price")
    @ResponseBody
    public double getTotalPriceForMadplan(@PathVariable int id) {
        return madplanService.calculateTotalPriceForMadplan(id);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/searchpage")
    public String searchPage() {
        return "search";
    }

    @GetMapping("/api-token")
    @ResponseBody
    public String getApiToken() {
        return "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ingredients>> searchProducts(@RequestParam(required = false) String query, @ModelAttribute("https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query=") String apiUrl) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(List.of());
        }

        String url = "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query=" + URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Access-Control-Allow-Origin", "*");  // Add this header



        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<>() {}
            );


            if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(List.of());
            }

            List<Map<String, Object>> suggestions = (List<Map<String, Object>>) response.getBody().get("suggestions");

            if (suggestions == null || suggestions.isEmpty()) {
                return ResponseEntity.ok(List.of());
            }

            List<Ingredients> products = suggestions.stream()
                    .map(suggestion -> new Ingredients(
                            suggestion.get("name").toString(),
                            suggestion.get("price") != null
                                    ? Double.parseDouble(suggestion.get("price").toString())
                                    : 0.0
                    ))
                    .toList();

            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(List.of());
        }
    }

    @GetMapping("/searchProductPrice")
    public ResponseEntity<Double> getProductPrice(@RequestParam String query) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            String sallingApiUrl = "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query="
                    + URLEncoder.encode(query, StandardCharsets.UTF_8);

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiToken); // Replace with actual token
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    sallingApiUrl,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode suggestionsNode = rootNode.get("suggestions");

            // Return the price of the first suggestion, or null if no suggestions
            if (suggestionsNode != null && suggestionsNode.isArray() && suggestionsNode.size() > 0) {
                return ResponseEntity.ok(suggestionsNode.get(0).get("price").asDouble());
            }

            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}