package org.himanshu;

import jakarta.validation.Valid;
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
    private final TrackingNumberService trackingNumberService;

    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

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
        String trackingNumber = trackingNumberService.generateTrackingNumber(request);
        Map<String, Object> response = Map.of(
                "CustomerName", request.getCustomerName(),
                "tracking_number", trackingNumber,
                "created_at", request.getCreatedAt()
        );

        return ResponseEntity.ok(response);
    }
}

