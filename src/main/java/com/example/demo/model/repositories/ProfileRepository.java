package com.example.demo.model.repositories;

import com.example.demo.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findByUsername(String username);
}
