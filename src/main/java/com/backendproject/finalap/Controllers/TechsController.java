package com.backendproject.finalap.Controllers;

import com.backendproject.finalap.Dto.tsDto;
import com.backendproject.finalap.Entities.Techs;
import com.backendproject.finalap.Security.Controller.Message;
import com.backendproject.finalap.Services.TechsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("techs")
@CrossOrigin(origins = "http://localhost:4200")
public class TechsController {
    
    @Autowired TechsService tsSvce;
    
    @GetMapping("/list")
    public ResponseEntity<List<Techs>> tsList(){
        List<Techs> list = tsSvce.tsList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Techs> getByTechId(@PathVariable("id") Long id){
        if(!tsSvce.existsByTechId(id)) {
            return new ResponseEntity(new Message("id inexistent"), HttpStatus.NOT_FOUND);
        }
        
        Techs ed = tsSvce.getOneTech(id).get();
        return new ResponseEntity(ed, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addTech(@RequestBody tsDto DTOts){
        if (StringUtils.isBlank(DTOts.getTsTitle())){
            return new ResponseEntity(new Message("title missing"),HttpStatus.BAD_REQUEST);
        }
        
        if (tsSvce.existsByTsTitle(DTOts.getTsTitle())){
            return new ResponseEntity(new Message("title already exists"),HttpStatus.BAD_REQUEST);
        }
        
        Techs ts = new Techs(DTOts.getTsTitle(),DTOts.getPercentage());
        tsSvce.saveTech(ts);
        
        return new ResponseEntity(new Message("tech succesfully added!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTech(@PathVariable("id") Long id, @RequestBody tsDto DTOts){
        if (!tsSvce.existsByTechId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        if (tsSvce.existsByTsTitle(DTOts.getTsTitle()) && tsSvce.getByTsTitle(DTOts.getTsTitle()).get().getId() != id){
            return new ResponseEntity(new Message("tech already exists!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DTOts.getTsTitle())){
            return new ResponseEntity(new Message("title missing"), HttpStatus.BAD_REQUEST);
        }
        
        Techs ts = tsSvce.getOneTech(id).get();
        ts.setTsTitle(DTOts.getTsTitle());
        ts.setPercentage(DTOts.getPercentage());
        tsSvce.saveTech(ts);
        
        return new ResponseEntity(new Message("tech succesfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTech(@PathVariable("id") Long id){
        if (!tsSvce.existsByTechId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        
        tsSvce.deleteTech(id);
        
        return new ResponseEntity(new Message("tech succesfully deleted"), HttpStatus.OK);
    }
    
}