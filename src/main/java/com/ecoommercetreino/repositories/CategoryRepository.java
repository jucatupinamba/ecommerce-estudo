package com.ecoommercetreino.repositories;

import com.ecoommercetreino.entities.Category;
import com.ecoommercetreino.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
