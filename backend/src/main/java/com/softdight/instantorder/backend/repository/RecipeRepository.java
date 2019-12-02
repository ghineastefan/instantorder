package com.softdight.instantorder.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.softdight.instantorder.backend.model.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
