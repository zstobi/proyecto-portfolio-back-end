package com.backendproject.finalap.Dto;

import jakarta.validation.constraints.NotBlank;

public class prjsDto {
    
    @NotBlank
    private String prjsTitle;
    @NotBlank
    private String prjsContent;
    private String link;
    
    public prjsDto(){}

    public prjsDto(String prjsTitle, String prjsContent, String link) {
        this.prjsTitle = prjsTitle;
        this.prjsContent = prjsContent;
        this.link = link;
    }

    public String getPrjsTitle() {
        return prjsTitle;
    }

    public void setPrjsTitle(String prjsTitle) {
        this.prjsTitle = prjsTitle;
    }

    public String getPrjsContent() {
        return prjsContent;
    }

    public void setPrjsContent(String prjsContent) {
        this.prjsContent = prjsContent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
