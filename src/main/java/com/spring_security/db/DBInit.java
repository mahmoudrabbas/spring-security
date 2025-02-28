package com.spring_security.db;

import com.spring_security.dao.AuthorityRepo;
import com.spring_security.dao.UserRepo;
import com.spring_security.models.Authority;
import com.spring_security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthorityRepo authorityRepo;

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();

        User admin = new User("Mahmoud", "abbas26",  new BCryptPasswordEncoder().encode("mra5553"), 1);
        admin.setAuthorities(authorityRepo.findAll());

        userRepo.save(admin);

        User manager = new User("Ghada", "ghada25", new BCryptPasswordEncoder().encode("gih5553"), 1);
        manager.getAuthorities().add(authorityRepo.findById(5L).get());
        manager.getAuthorities().add(authorityRepo.findById(6L).get());
        manager.getAuthorities().add(authorityRepo.findById(7L).get());
        userRepo.save(manager);


        User user = new User("Moamer", "mostafa25", new BCryptPasswordEncoder().encode("mmh5553"), 1);
        user.getAuthorities().add(authorityRepo.findById(6L).get());

        userRepo.save(user);


    }
}
