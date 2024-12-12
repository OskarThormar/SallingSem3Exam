package controller;

import model.Ingredients;
import model.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.MadplanService;
import service.RecipeService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


@Controller
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

    @CrossOrigin(origins = "http://localhost:8080") // Tillad kun anmodninger fra din frontend
    @GetMapping("/search")
    public ResponseEntity<List<Ingredients>> searchProducts(@RequestParam String query, @ModelAttribute("https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query=") String apiUrl) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(List.of());
        }

        String url = "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query" + "=" + URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);

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
}