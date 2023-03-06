package com.backendproject.finalap.Controllers;

import com.backendproject.finalap.Dto.abtmDto;
import com.backendproject.finalap.Entities.AboutMe;
import com.backendproject.finalap.Security.Controller.Message;
import com.backendproject.finalap.Services.AboutMeService;
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
@RequestMapping("abtm")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://apfinal-frontend.web.app")
public class AboutMeController {
    
    @Autowired AboutMeService abtmSvce;
    
    @GetMapping("/list")
    public ResponseEntity<List<AboutMe>> abtmList(){
        List<AboutMe> list = abtmSvce.abtmList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> getByAbtmId(@PathVariable("id") Long id){
        if(!abtmSvce.existsByAbtmId(id)) {
            return new ResponseEntity(new Message("id inexistent"), HttpStatus.NOT_FOUND);
        }
        
        AboutMe abtm = abtmSvce.getOneAbtm(id).get();
        return new ResponseEntity(abtm, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addAbtm(@RequestBody abtmDto DTOabtm){
        if (StringUtils.isBlank(DTOabtm.getAbtmContent())){
            return new ResponseEntity(new Message("content missing"),HttpStatus.BAD_REQUEST);
        }
        
        AboutMe abtm = new AboutMe(DTOabtm.getAbtmContent());
        abtmSvce.saveAbtm(abtm);
        
        return new ResponseEntity(new Message("abtm succesfully added!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAbtm(@PathVariable("id") Long id, @RequestBody abtmDto DTOabtm){
        if (!abtmSvce.existsByAbtmId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DTOabtm.getAbtmContent())){
            return new ResponseEntity(new Message("content missing"),HttpStatus.BAD_REQUEST);
        }
        
        AboutMe abtm = abtmSvce.getOneAbtm(id).get();
        abtm.setAbtmContent(DTOabtm.getAbtmContent());
        abtmSvce.saveAbtm(abtm);
        
        return new ResponseEntity(new Message("abtm succesfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAbtm(@PathVariable("id") Long id){
        if (!abtmSvce.existsByAbtmId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        
        abtmSvce.deleteAbtm(id);
        
        return new ResponseEntity(new Message("abtm succesfully deleted"), HttpStatus.OK);
    }
}
