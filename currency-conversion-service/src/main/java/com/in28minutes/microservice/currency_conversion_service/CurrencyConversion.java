package com.in28minutes.microservice.currency_conversion_service;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;

    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
//    private String country;

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculateAmount, String environment) {
//        this.country = country;
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculateAmount = totalCalculateAmount;
        this.environment = environment;

    }

    public CurrencyConversion() {
    }

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculateAmount() {
        return totalCalculateAmount;
    }

    public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
        this.totalCalculateAmount = totalCalculateAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    private BigDecimal totalCalculateAmount;
    private String environment;
}
