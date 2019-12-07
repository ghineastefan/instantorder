package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Ingredient;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("ingredientServiceImpl")
@Transactional
public class IngredientServiceImpl extends BaseServiceImpl<Ingredient> implements IngredientService {

}
