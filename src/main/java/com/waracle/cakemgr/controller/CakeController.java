package com.waracle.cakemgr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.Cake;
import com.waracle.cakemgr.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@RestController
public class CakeController {

    @Autowired
    private final CakeService cakeService;

    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @PostMapping("/cake")
    public ResponseEntity<Cake> createApplication(@RequestBody Cake cake) {
        cakeService.create(cake);
        return ResponseEntity.status(HttpStatus.CREATED).body(cake);
    }

    @Consumes(TEXT_PLAIN)
    @Produces({APPLICATION_JSON})
    @GetMapping("/cakes")
    public ResponseEntity<String> findAllApplications() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).
                body(new ObjectMapper().writeValueAsString(cakeService.findAll()));
    }

    @Consumes(TEXT_PLAIN)
    @Produces({APPLICATION_JSON})
    @GetMapping("/cakes/{clientName}")
    public ResponseEntity<String> getByClientName(@PathVariable String clientName) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).
                body(new ObjectMapper().writeValueAsString(cakeService.findByClientName(clientName)));
    }


}
