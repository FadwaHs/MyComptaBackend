package com.codingart.mycompta.controller.opportunite;


import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
//The annotation specifies that all requests to the /api/opportunites path should be handled by this controller.
@RequestMapping("/api/opportunites")
@RequiredArgsConstructor
public class OpportuniteController {

    private final OpportuniteService opportuniteService;

    // Handel The GET requests to the /api/opportunites/{id}
    @GetMapping("{id}")
    public ResponseEntity<Opportunite> getOpportuniteById(@PathVariable Long id){
        return new ResponseEntity<>(opportuniteService.getOpportunite(id), HttpStatus.OK);
    }

    /* @RestController : Notice that we have only defined our REST APIs here,
     all the business logic is part of Repository class.
     If our method is returning a list or array, then spring will only support JSON response */
    @GetMapping
    public ResponseEntity<List<Opportunite>> getAllOpportunites(){
        return new ResponseEntity<>(opportuniteService.getAllOpportunites(), HttpStatus.OK);
    }

    /* RESTful web service endpoint that handles POST requests to create a new Opportunite object.*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Opportunite> createOpportunite(@Valid @RequestBody Opportunite opportunite){
        return new ResponseEntity<>(opportuniteService.addOpportunite(opportunite), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Opportunite> updateOpportunite(@PathVariable Long id, @Valid @RequestBody Opportunite opportunite){
        return new ResponseEntity<>(opportuniteService.updateOpportunite(id,opportunite), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOpportunite(@PathVariable Long id){
        opportuniteService.deleteOpportunite(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
