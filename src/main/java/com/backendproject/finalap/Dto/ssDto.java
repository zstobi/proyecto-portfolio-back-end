package com.backendproject.finalap.Dto;

import jakarta.validation.constraints.NotBlank;

public class ssDto {
    
    @NotBlank
    private String ssTitle;
    
    public ssDto(){}

    public ssDto(String ssTitle) {
        this.ssTitle = ssTitle;
    }

    public String getSsTitle() {
        return ssTitle;
    }

    public void setSsTitle(String ssTitle) {
        this.ssTitle = ssTitle;
    }
    
}
