package com.backendproject.finalap.Controllers;

import com.backendproject.finalap.Dto.edDto;
import com.backendproject.finalap.Entities.Education;
import com.backendproject.finalap.Security.Controller.Message;
import com.backendproject.finalap.Services.EducationService;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ed")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired EducationService edSvce;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> edList(){
        List<Education> list = edSvce.edList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getByEdId(@PathVariable("id") Long id){
        if(!edSvce.existsByEdId(id)) {
            return new ResponseEntity(new Message("id inexistent"), HttpStatus.NOT_FOUND);
        }
        
        Education ed = edSvce.getOneEd(id).get();
        return new ResponseEntity(ed, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addEd(@RequestBody edDto DTOed){
        if (StringUtils.isBlank(DTOed.getEdTitle())){
            return new ResponseEntity(new Message("title missing"),HttpStatus.BAD_REQUEST);
        }
        
        if (edSvce.existsByEdTitle(DTOed.getEdTitle())){
            return new ResponseEntity(new Message("title already exists"),HttpStatus.BAD_REQUEST);
        }
        
        Education ed = new Education(DTOed.getEdTitle(),DTOed.getEdContent());
        edSvce.saveEd(ed);
        
        return new ResponseEntity(new Message("ed succesfully added!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEd(@PathVariable("id") Long id, @RequestBody edDto DTOed){
        if (!edSvce.existsByEdId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        if (edSvce.existsByEdTitle(DTOed.getEdTitle()) && edSvce.getByEdTitle(DTOed.getEdTitle()).get().getId() != id){
            return new ResponseEntity(new Message("ed already exists!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DTOed.getEdTitle())){
            return new ResponseEntity(new Message("title missing"), HttpStatus.BAD_REQUEST);
        }
        
        Education ed = edSvce.getOneEd(id).get();
        ed.setEdTitle(DTOed.getEdTitle());
        ed.setEdContent(DTOed.getEdContent());
        edSvce.saveEd(ed);
        
        return new ResponseEntity(new Message("ed succesfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEd(@PathVariable("id") Long id){
        if (!edSvce.existsByEdId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        
        edSvce.deleteEd(id);
        
        return new ResponseEntity(new Message("ed succesfully deleted"), HttpStatus.OK);
    }
    
}