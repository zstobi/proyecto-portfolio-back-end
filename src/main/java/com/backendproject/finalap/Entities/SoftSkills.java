package com.backendproject.finalap.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class SoftSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "Cannot be null.")
    private String ssTitle;
    
    public SoftSkills (){}

    public SoftSkills(String ssTitle) {
        this.ssTitle = ssTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsTitle() {
        return ssTitle;
    }

    public void setSsTitle(String ssTitle) {
        this.ssTitle = ssTitle;
    }

    
}