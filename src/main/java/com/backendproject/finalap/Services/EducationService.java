package com.backendproject.finalap.Services;

import com.backendproject.finalap.Entities.Education;
import com.backendproject.finalap.Repositories.EducationRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    
    @Autowired EducationRepository edRepo;
    
    public List<Education> edList(){
        return edRepo.findAll();
    }
    
    public Optional<Education> getOneEd(Long id){
        return edRepo.findById(id);
    }
    
    public Optional<Education> getByEdTitle(String edTitle){
        return edRepo.findByEdTitle(edTitle);
    }
    
    public void saveEd(Education ed){
        edRepo.save(ed);
    }

    public void deleteEd(Long id){
        edRepo.deleteById(id);
    }
    
    public boolean existsByEdId(Long id){
        return edRepo.existsById(id);
    }
    
    public boolean existsByEdTitle(String edTitle){
        return edRepo.existsByEdTitle(edTitle);
    }
    
}