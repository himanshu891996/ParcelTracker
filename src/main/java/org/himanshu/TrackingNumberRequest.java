package org.himanshu;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import java.util.UUID;

public class TrackingNumberRequest {
    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin Country ID must be in ISO 3166-1 alpha-2 format.")
    private String originCountryId;

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$", message = "Destination Country ID must be in ISO 3166-1 alpha-2 format.")
    private String destinationCountryId;

    @NotNull
    @Pattern(regexp = "^\\d*\\.?\\d{0,3}$", message = "Weight should be up to three decimal places")
    private String weight;

    @NotNull(message = "Timestamp cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @NotNull(message = "Customer ID cannot be null")
    private UUID customerId;

    @NotNull(message = "Customer name cannot be null")
    @Size(min=1,max=100,message = "Customer name must be between 1 and 100")
    private String customerName;

    @NotNull(message = "Customer name cannot be null")
    @Size(min=1,max=100,message = "Customer Slug must be between 1 and 100")
    private String customerSlug;

    // Getters and Setters
    public String getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(String originCountryId) {
        this.originCountryId = originCountryId;
    }
    public String getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerSlug() {
        return customerSlug;
    }

    public void setCustomerSlug(String customerSlug) {
        this.customerSlug = customerSlug;
    }
}