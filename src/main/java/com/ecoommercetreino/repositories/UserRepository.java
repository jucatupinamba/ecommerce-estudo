package com.ecoommercetreino.repositories;

import com.ecoommercetreino.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
