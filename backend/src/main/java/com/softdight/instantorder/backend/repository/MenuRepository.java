package com.softdight.instantorder.backend.repository;


import com.softdight.instantorder.backend.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
}
