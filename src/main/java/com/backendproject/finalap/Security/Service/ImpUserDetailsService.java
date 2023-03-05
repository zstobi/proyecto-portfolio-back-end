package com.backendproject.finalap.Security.Service;

import com.backendproject.finalap.Security.Entity.EditionMode;
import com.backendproject.finalap.Security.Repository.EditionModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImpUserDetailsService implements UserDetailsService {
    @Autowired
    private EditionModeRepository editionModeRepo;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        EditionMode editor = editionModeRepo.findOneByUser(user)
                       .orElseThrow( ()-> new UsernameNotFoundException("user" + user + "inexistent"));
        
        return new ImpUserDetails(editor);
    }
}