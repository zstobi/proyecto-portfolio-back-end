package com.backendproject.finalap.Repositories;

import com.backendproject.finalap.Entities.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Long>{
    
}

// como parametros al jpa repo se le pasa la entidad y el tipo de su primary key