package org.himanshu;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class TrackingNumberService {

    private static final Logger logger = LoggerFactory.getLogger(TrackingNumberService.class);
    private static final Set<String> generatedTrackingNumbers = new HashSet<>();

    public String generateTrackingNumber(TrackingNumberRequest request) {
        // Generate a unique tracking number (16 chars max, regex ^[A-Z0-9]{1,16}$)

        logger.info("In generateTrackingNumber method");
        try {
            String variable = request.getOriginCountryId() + request.getDestinationCountryId() + request.getCustomerName().substring(0, 2);
            logger.info("Variable created: {}", variable);
            String trackingNumber;
            do {
                trackingNumber = variable.toUpperCase() + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10).toUpperCase();
                logger.info("Generated TrackingNumber: {}", trackingNumber);
            }while (generatedTrackingNumbers.contains(trackingNumber));
            generatedTrackingNumbers.add(trackingNumber);
            return trackingNumber;
        }
        catch (Exception e){
            logger.error("Unexpected error occurred while generating tracking number.", e);
            throw new RuntimeException("Unexpected error occurred", e);
        }

    }
}

