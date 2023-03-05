package com.backendproject.finalap.Services;

import com.backendproject.finalap.Entities.Techs;
import com.backendproject.finalap.Repositories.TechsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TechsService {
    @Autowired TechsRepository tsRepo;
    
    public List<Techs> tsList(){
        return tsRepo.findAll();
    }
    
    public Optional<Techs> getOneTech(Long id){
        return tsRepo.findById(id);
    }
    
    public Optional<Techs> getByTsTitle(String tsTitle){
        return tsRepo.findByTsTitle(tsTitle);
    }
    
    public void saveTech(Techs ts){
        tsRepo.save(ts);
    }

    public void deleteTech(Long id){
        tsRepo.deleteById(id);
    }
    
    public boolean existsByTechId(Long id){
        return tsRepo.existsById(id);
    }
    
    public boolean existsByTsTitle(String tsTitle){
        return tsRepo.existsByTsTitle(tsTitle);
    }
    
}