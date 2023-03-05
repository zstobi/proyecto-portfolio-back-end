package com.backendproject.finalap.Dto;

import jakarta.validation.constraints.NotBlank;

public class tsDto {
    
    @NotBlank
    private String tsTitle;
    @NotBlank
    private int percentage;
    
    public tsDto(){}

    public tsDto(String tsTitle, int percentage) {
        this.tsTitle = tsTitle;
        this.percentage = percentage;
    }

    public String getTsTitle() {
        return tsTitle;
    }

    public void setTsTitle(String tsTitle) {
        this.tsTitle = tsTitle;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }    
    
}
