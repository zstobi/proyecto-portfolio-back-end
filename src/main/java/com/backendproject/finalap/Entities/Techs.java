package com.backendproject.finalap.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Techs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 30, message = "Cannot be null.")
    private String tsTitle;
    
    @NotNull
    @Min(value=0, message = "Cannot be less than 0")
    @Max(value=100, message = "Cannot be more than 100")
    private int percentage;
    
    public Techs(){}

    public Techs(String tsTitle, int percentage) {
        this.tsTitle = tsTitle;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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