package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Menu;
import com.softdight.instantorder.backend.repository.MenuRepository;
import com.softdight.instantorder.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("menuServiceImpl")
@Transactional
@Qualifier("menuService")
public class MenuServiceImpl extends RestaurantDependentServiceImpl<Menu> implements MenuService{

    private MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
        this.baseRepo = menuRepository;
        this.restaurantDependentRepository = menuRepository;
    }

    @Override
    public List<Menu> findAllByRestaurantId(String restaurantId) {
        return menuRepository.findAllByRestaurantId(restaurantId);
    }
}
