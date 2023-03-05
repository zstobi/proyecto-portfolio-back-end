package com.backendproject.finalap.Repositories;

import com.backendproject.finalap.Entities.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    public Optional<Education> findByEdTitle(String edTitle);
    
    public boolean existsByEdTitle(String edTitle);
}