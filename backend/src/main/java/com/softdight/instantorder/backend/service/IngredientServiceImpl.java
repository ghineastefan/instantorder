package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Ingredient;
import com.softdight.instantorder.backend.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("ingredientServiceImpl")
@Transactional
public class IngredientServiceImpl extends BaseServiceImpl<Ingredient> implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
        this.baseRepo = ingredientRepository;
    }

}
