package com.backendproject.finalap.Security.Controller;

//import com.backendproject.finalap.Security.Repository.EditionModeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
@AllArgsConstructor
public class EditionController {
//    private final EditionModeRepository editionModeRepo;
    
    @GetMapping
    public String test(){
        return "it works";
    }
}

// this file dont do anything - check later
// only works with bearer token