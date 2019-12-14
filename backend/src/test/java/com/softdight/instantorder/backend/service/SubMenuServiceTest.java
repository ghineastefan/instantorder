package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.SubMenu;
import com.softdight.instantorder.backend.repository.SubMenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubMenuServiceTest {

    @InjectMocks
    private SubMenuServiceImpl subMenuService;

    @Mock
    private SubMenuRepository subMenuRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void findAll(){

        List<SubMenu> list = new ArrayList<SubMenu>();

        SubMenu subMenu1 = new SubMenu();
        SubMenu subMenu2 = new SubMenu();
        SubMenu subMenu3 = new SubMenu();

        subMenu1.setId("id1");
        subMenu1.setDescription("description1");
        subMenu1.setPathToPhoto("path1");

        subMenu2.setId("id2");
        subMenu2.setDescription("description2");
        subMenu2.setPathToPhoto("path2");

        subMenu3.setId("id3");
        subMenu3.setDescription("description3");
        subMenu3.setPathToPhoto("path3");


        list.add(subMenu1);
        list.add(subMenu2);
        list.add(subMenu3);

        when(subMenuRepository.findAll()).thenReturn(list);

        //test
        List<SubMenu> subMenuList = subMenuService.findAll();

        assertEquals(3, subMenuList.size());
        verify(subMenuRepository, times(1)).findAll();
    }
}