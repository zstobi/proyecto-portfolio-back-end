package com.backendproject.finalap.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "Cannot be null.")
    private String edTitle;
    
    @NotNull
    @Size(min = 10, max = 500, message = "10 characters at least!")
    private String edContent;
    
    public Education(){};

    public Education(String edTitle, String edContent) {
        this.edTitle = edTitle;
        this.edContent = edContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
