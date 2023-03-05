package com.backendproject.finalap.Dto;

import jakarta.validation.constraints.NotBlank;

public class abtmDto {
    
    @NotBlank
    private String abtmContent;
    
    public abtmDto(){}

    public abtmDto(String abtmContent) {
        this.abtmContent = abtmContent;
    }
    
    public String getAbtmContent() {
        return abtmContent;
    }

    public void setAbtmContent(String abtmContent) {
        this.abtmContent = abtmContent;
    }
}
