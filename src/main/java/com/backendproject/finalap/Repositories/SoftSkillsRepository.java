package com.backendproject.finalap.Repositories;

import com.backendproject.finalap.Entities.SoftSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends JpaRepository<SoftSkills, Long>{
    
}