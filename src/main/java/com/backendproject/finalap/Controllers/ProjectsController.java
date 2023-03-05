package com.backendproject.finalap.Controllers;

import com.backendproject.finalap.Dto.prjsDto;
import com.backendproject.finalap.Entities.Projects;
import com.backendproject.finalap.Security.Controller.Message;
import com.backendproject.finalap.Services.ProjectsService;
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
@RequestMapping("prjs")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {
    
    @Autowired ProjectsService prjsSvce;
    
    @GetMapping("/list")
    public ResponseEntity<List<Projects>> prjsList(){
        List<Projects> list = prjsSvce.prjsList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getByPrjsId(@PathVariable("id") Long id){
        if(!prjsSvce.existsByPrjsId(id)) {
            return new ResponseEntity(new Message("id inexistent"), HttpStatus.NOT_FOUND);
        }
        
        Projects prjs = prjsSvce.getOnePrjs(id).get();
        return new ResponseEntity(prjs, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addPrjs(@RequestBody prjsDto DTOprjs){
        if (StringUtils.isBlank(DTOprjs.getPrjsTitle())){
            return new ResponseEntity(new Message("title missing"),HttpStatus.BAD_REQUEST);
        }
        
        if (prjsSvce.existsByPrjsTitle(DTOprjs.getPrjsTitle())){
            return new ResponseEntity(new Message("title already exists"),HttpStatus.BAD_REQUEST);
        }
        
        Projects prjs = new Projects(DTOprjs.getPrjsTitle(),DTOprjs.getPrjsContent(),DTOprjs.getLink());
        prjsSvce.savePrjs(prjs);
        
        return new ResponseEntity(new Message("prjs succesfully added!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePrjs(@PathVariable("id") Long id, @RequestBody prjsDto DTOprjs){
        if (!prjsSvce.existsByPrjsId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        if (prjsSvce.existsByPrjsTitle(DTOprjs.getPrjsTitle()) && prjsSvce.getByPrjsTitle(DTOprjs.getPrjsTitle()).get().getId() != id){
            return new ResponseEntity(new Message("prjs already exists!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DTOprjs.getPrjsTitle())){
            return new ResponseEntity(new Message("title missing"), HttpStatus.BAD_REQUEST);
        }
        
        Projects prjs = prjsSvce.getOnePrjs(id).get();
        prjs.setPrjsTitle(DTOprjs.getPrjsTitle());
        prjs.setPrjsContent(DTOprjs.getPrjsContent());
        prjs.setLink(DTOprjs.getLink());
        prjsSvce.savePrjs(prjs);
        
        return new ResponseEntity(new Message("prjs succesfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrjs(@PathVariable("id") Long id){
        if (!prjsSvce.existsByPrjsId(id)){
            return new ResponseEntity(new Message("id non-existent!"), HttpStatus.BAD_REQUEST);
        }
        
        prjsSvce.deletePrjs(id);
        
        return new ResponseEntity(new Message("prjs succesfully deleted"), HttpStatus.OK);
    }
    
}