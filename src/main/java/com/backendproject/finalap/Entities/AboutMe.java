package com.backendproject.finalap.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class AboutMe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 20, max = 500, message = "20 characters at least!")
    private String abtmContent;
    
    public AboutMe(){};

    public AboutMe(String abtmcontent) {
        this.abtmContent = abtmcontent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbtmContent() {
        return abtmContent;
    }

    public void setAbtmContent(String content) {
        this.abtmContent = content;
    }    
}
