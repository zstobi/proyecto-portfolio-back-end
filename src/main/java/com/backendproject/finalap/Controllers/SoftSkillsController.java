package com.backendproject.finalap.Controllers;

import com.backendproject.finalap.Dto.ssDto;
import com.backendproject.finalap.Entities.SoftSkills;
import com.backendproject.finalap.Security.Controller.Message;
import com.backendproject.finalap.Services.SoftSkillsService;
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
@RequestMapping("ss")
@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillsController {
    
    @Autowired SoftSkillsService ssSvce;
    
    @GetMapping("/list")
    public ResponseEntity<List<SoftSkills>> ssList(){
        List<SoftSkills> list = ssSvce.ssList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkills> getBySSId(@PathVariable("id") Long id){
        if(!ssSvce.existsBySSId(id)) {
            return new ResponseEntity(new Message("id inexistent"), HttpStatus.NOT_FOUND);
        }
        
        SoftSkills ss = ssSvce.getOneSS(id).get();
        return new ResponseEntity(ss, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addSS(@RequestBody ssDto DTOss){
        if (StringUtils.isBlank(DTOss.getSsTitle())){
            return new ResponseEntity(new Message("title missing"),HttpStatus.BAD_REQUEST);
        }
        
        SoftSkills ss = new SoftSkills(DTOss.getSsTitle());
        ssSvce.saveSS(ss);
        
        return new ResponseEntity(new Message("ss succesfully added!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSS(@PathVariable("id") Long id, @RequestBody ssDto DTOss){
        if (!ssSvce.existsBySSId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DTOss.getSsTitle())){
            return new ResponseEntity(new Message("title missing"), HttpStatus.BAD_REQUEST);
        }
        
        SoftSkills ss = ssSvce.getOneSS(id).get();
        ss.setSsTitle(DTOss.getSsTitle());
        ssSvce.saveSS(ss);
        
        return new ResponseEntity(new Message("ss succesfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSS(@PathVariable("id") Long id){
        if (!ssSvce.existsBySSId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        
        ssSvce.deleteSS(id);
        
        return new ResponseEntity(new Message("ss succesfully deleted"), HttpStatus.OK);
    }
    
}