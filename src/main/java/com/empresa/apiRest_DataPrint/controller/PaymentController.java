package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.DTO.PaymentIntentDTO;
import com.empresa.apiRest_DataPrint.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/paymentIntent")
    public ResponseEntity<String>payment(@RequestBody PaymentIntentDTO paymentIntentDTO) throws StripeException {
        PaymentIntent paymentIntent=paymentService.paymentIntent(paymentIntentDTO);
        String paymentStr=paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }
    @PostMapping("/confirm/{id}")
    public ResponseEntity<String>confirm(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent=paymentService.confirm(id);
        String paymentStr=paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }
    @PostMapping("/cancel/{id}")
    public ResponseEntity<String>cancel(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent=paymentService.cancel(id);
        String paymentStr=paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }
}
