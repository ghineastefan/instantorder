package com.softdight.instantorder.backend.service;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubMenuServiceTest {

    @Autowired
    @Qualifier("subMenuService")
    private SubMenuService subMenuService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void findAll(){
        assertNotNull(subMenuService.findAll());
        assertNotEquals(subMenuService.findAll().size(),0);
    }
}