package com.techmojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *Sample controller class to process the request
 */
@RestController
public class RequestProcessorController {

    /**
     * @return
     */
@GetMapping("/process")
    public ResponseEntity<String> process(){

        return  new ResponseEntity<String>("Request Processed", HttpStatus.OK);
    }
}
