package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubMenuRepository  extends RestaurantDependentRepository<SubMenu> {
}
