package com.backendproject.finalap.Security.Repository;

import com.backendproject.finalap.Security.Entity.EditionMode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionModeRepository extends JpaRepository<EditionMode, Integer> {
    
    Optional<EditionMode> findOneByUser(String user);
    
}
