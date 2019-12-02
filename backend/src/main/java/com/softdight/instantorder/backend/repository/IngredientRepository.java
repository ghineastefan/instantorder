package com.softdight.instantorder.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.softdight.instantorder.backend.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String>  {
}
