package com.example.demo.model.repositories;

import com.example.demo.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Long> {
}
