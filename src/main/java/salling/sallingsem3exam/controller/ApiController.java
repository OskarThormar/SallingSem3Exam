package salling.sallingsem3exam.controller;

import org.springframework.web.bind.annotation.*;
import salling.sallingsem3exam.model.Day;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.service.Service;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080") // Tillad kun anmodninger fra din frontend
@RestController
public class ApiController {
  
  
    //@Value("${api.token}") // Token hentes fra application.properties
    //private String apiToken;

    //private final RestTemplate restTemplate = new RestTemplate();

    private Service service;
    public ApiController(Service service){
        this.service = service;
    }
    @GetMapping("/api/plan/foodPlan")
    public List<Madplan> parseMadplanToJson(){
        List<Madplan> madplan = service.getAllMadplans();
        return madplan;
    }

    @PostMapping("/api/plan/foodPlan")
    public Madplan createFoodplan(@RequestBody Madplan newMadplan){
        service.createMadPlan(newMadplan);
        return newMadplan;
    }

    @GetMapping("/api/plan/foodPlan/{ID}")
    public Madplan getMadPlanByID(@PathVariable int ID){
        Madplan madplanFound = service.getMadPlanByID(ID);
        return madplanFound;
    }

    @DeleteMapping("/api/plan/foodPlan/{ID}")
    public void deleteMadPlan(@PathVariable int ID){
        service.deleteMadPlan(ID);
    }

    @PutMapping("/api/plan/foodPlan/{ID}")
    public Madplan updateMadPlan(@PathVariable int ID, @RequestBody Madplan madplanToBeUpdated){
        service.updateMadplan(ID, madplanToBeUpdated);
        return madplanToBeUpdated;
    }

    @GetMapping("/api/plan/foodPlan/{ID}/days")
    public List<Day> showAmountOfDays(@PathVariable int ID){
        List<Day> listOfDays = service.getAllDaysFromMadplan(ID);
        return listOfDays;
    }

    //@GetMapping("/api-token")
    //@ResponseBody
    //public String getApiToken() {
    //    return "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query";
    //}

    //@GetMapping("/searchProductPrice")
    //public ResponseEntity<Double> getProductPrice(@RequestParam String query) {
    //    RestTemplate restTemplate = new RestTemplate();

    //    try {
    //        String sallingApiUrl = "https://api.sallinggroup.com/v1-beta/product-suggestions/relevant-products?query="
    //                + URLEncoder.encode(query, StandardCharsets.UTF_8);

    //        HttpHeaders headers = new HttpHeaders();
    //        headers.setBearerAuth(apiToken); // Replace with actual token
    //        headers.setContentType(MediaType.APPLICATION_JSON);

    //        HttpEntity<String> entity = new HttpEntity<>(headers);

    //        ResponseEntity<String> response = restTemplate.exchange(
    //                sallingApiUrl,
    //                HttpMethod.GET,
    //                entity,
    //                String.class
    //        );

   //         ObjectMapper objectMapper = new ObjectMapper();
   //         JsonNode rootNode = objectMapper.readTree(response.getBody());
   //         JsonNode suggestionsNode = rootNode.get("suggestions");

            // Return the price of the first suggestion, or null if no suggestions
   //         if (suggestionsNode != null && suggestionsNode.isArray() && suggestionsNode.size() > 0) {
   //             return ResponseEntity.ok(suggestionsNode.get(0).get("price").asDouble());
   //         }

   //         return ResponseEntity.ok(null);
   //     } catch (Exception e) {
   //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
   //     }
   // }
}
