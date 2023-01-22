package com.example.gadgetariumproject.db.repository;

import com.example.gadgetariumproject.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}