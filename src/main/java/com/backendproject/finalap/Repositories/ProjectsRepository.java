package com.backendproject.finalap.Repositories;

import com.backendproject.finalap.Entities.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long>{
    public Optional<Projects> findByPrjsTitle(String prjsTitle);
    
    public boolean existsByPrjsTitle(String prjsTitle);
}
