package com.backendproject.finalap.Dto;

import jakarta.validation.constraints.NotBlank;

public class edDto {
    
    @NotBlank
    private String edTitle;
    @NotBlank
    private String edContent;
    
    public edDto(){}

    public edDto(String edTitle, String edContent) {
        this.edTitle = edTitle;
        this.edContent = edContent;
    }

    public String getEdTitle() {
        return edTitle;
    }

    public void setEdTitle(String edTitle) {
        this.edTitle = edTitle;
    }

    public String getEdContent() {
        return edContent;
    }

    public void setEdContent(String edContent) {
        this.edContent = edContent;
    }
    
}