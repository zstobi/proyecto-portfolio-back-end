package com.backendproject.finalap.Services;

import com.backendproject.finalap.Entities.SoftSkills;
import com.backendproject.finalap.Repositories.SoftSkillsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillsService {
    
    @Autowired SoftSkillsRepository ssRepo;

    public List<SoftSkills> ssList(){
        return ssRepo.findAll();
    }
    
    public Optional<SoftSkills> getOneSS(Long id){
        return ssRepo.findById(id);
    }
    
    public void saveSS(SoftSkills ss){
        ssRepo.save(ss);
    }

    public void deleteSS(Long id){
        ssRepo.deleteById(id);
    }
    
    public boolean existsBySSId(Long id){
        return ssRepo.existsById(id);
    }
    
}