package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Recipe;
import com.softdight.instantorder.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("recipeServiceImpl")
@Transactional
@Qualifier("recipeService")
public class RecipeServiceImpl extends BaseServiceImpl<Recipe> implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
        this.baseRepo = recipeRepository;
    }
}
