package com.backendproject.finalap.Services;

import com.backendproject.finalap.Entities.Projects;
import com.backendproject.finalap.Repositories.ProjectsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {
    @Autowired ProjectsRepository prjsRepo;

    public List<Projects> prjsList(){
        return prjsRepo.findAll();
    }
    
    public Optional<Projects> getOnePrjs(Long id){
        return prjsRepo.findById(id);
    }
    
    public Optional<Projects> getByPrjsTitle(String prjsTitle){
        return prjsRepo.findByPrjsTitle(prjsTitle);
    }
    
    public void savePrjs(Projects prjs){
        prjsRepo.save(prjs);
    }

    public void deletePrjs(Long id){
        prjsRepo.deleteById(id);
    }
    
    public boolean existsByPrjsId(Long id){
        return prjsRepo.existsById(id);
    }
    
    public boolean existsByPrjsTitle(String prjsTitle){
        return prjsRepo.existsByPrjsTitle(prjsTitle);
    }
    
}