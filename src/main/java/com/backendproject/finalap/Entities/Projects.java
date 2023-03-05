package com.backendproject.finalap.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "Cannot be null.")
    private String prjsTitle;
    
    @NotNull
    @Size(min = 10, max = 500, message = "10 characters at least!")
    private String prjsContent;
    
    private String link;
    
    public Projects(){}

    public Projects(String prjsTitle, String prjsContent, String link) {
        this.prjsTitle = prjsTitle;
        this.prjsContent = prjsContent;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
