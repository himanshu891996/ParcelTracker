package org.himanshu;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/api")
public class TrackingNumberController {

    private static final Logger logger = LoggerFactory.getLogger(TrackingNumberController.class);
    @PostMapping("/generateTrackingNumber")
    public ResponseEntity<?> generateTrackingNumber(@Valid @RequestBody TrackingNumberRequest request, BindingResult bindingResult ) {
        logger.info("Received request to generateTrackingNumber");
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            logger.info("Validation failed: {}",errorMessages);
            return ResponseEntity.badRequest().body(new ErrorResponse("Validation failed", errorMessages));
        }

        // Generate the tracking number
        String trackingNumber = generateTrackingNumber(request);
        return ResponseEntity.ok(trackingNumber);
    }

    // Method to generate a unique tracking number
    private String generateTrackingNumber(TrackingNumberRequest request) {
        // Generate a unique tracking number (16 chars max, regex ^[A-Z0-9]{1,16}$)
        logger.info("In generateTrackingNumber method");
        String variable=request.getOriginCountryId()+request.getDestinationCountryId()+request.getCustomerName().substring(0, 2);
        logger.info("Variable created: {}",variable);
        String trackingnumber=variable.toUpperCase()+UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10).toUpperCase();
        logger.info("Generated TrackingNumber: {}",trackingnumber);
        return trackingnumber;

    }
}

