package com.backendproject.finalap.Services;

import com.backendproject.finalap.Entities.AboutMe;
import com.backendproject.finalap.Repositories.AboutMeRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AboutMeService {

    @Autowired AboutMeRepository abtmRepo;
    // permite inyectar dependencias dentro de otras
    
    public List<AboutMe> abtmList(){
        return abtmRepo.findAll();
    }
    
    public Optional<AboutMe> getOneAbtm(Long id){
        return abtmRepo.findById(id);
    }

    public void saveAbtm(AboutMe abtm) {
        abtmRepo.save(abtm);
    }

    public AboutMe updateAbtm(Long id) {
        AboutMe abtm = abtmRepo.findById(id).orElse(null);
        return abtm;
    }

    public void deleteAbtm(Long id) {
        abtmRepo.deleteById(id);
    }
    
    public boolean existsByAbtmId(Long id){
        return abtmRepo.existsById(id);
    }
//    este ultimo capaz se borra
    
}
