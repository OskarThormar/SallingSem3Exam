package controller;

import model.Ingredients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${api.token}")
    private String apiToken;

    private final RestTemplate restTemplate = new RestTemplate();

    // Henter søge-resultater som JSON
    @GetMapping("/search-results")
    public ResponseEntity<List<Ingredients>> searchProductsJSON(@RequestParam String query) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(List.of());
        }

        String url = "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query="
                + URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);

        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<>() {}
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                List<Map<String, Object>> suggestions = (List<Map<String, Object>>) response.getBody().get("suggestions");
                List<Ingredients> products = new ArrayList<>();

                if (suggestions != null) {
                    for (Map<String, Object> suggestion : suggestions) {
                        Ingredients product = new Ingredients(
                                suggestion.get("title") != null ? suggestion.get("title").toString() : "Unknown",
                                suggestion.get("price") != null ? Double.parseDouble(suggestion.get("price").toString()) : 0.0,
                                "N/A", 1
                        );
                        products.add(product);
                    }
                }

                return ResponseEntity.ok(products);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(List.of());
    }
}
