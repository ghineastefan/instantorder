package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.SubMenu;
import com.softdight.instantorder.backend.repository.SubMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("subMenuServiceImpl")
@Transactional
@Qualifier("subMenuService")
public class SubMenuServiceImpl extends BaseServiceImpl<SubMenu> implements SubMenuService {

    SubMenuRepository subMenuRepository;

    @Autowired
    public SubMenuServiceImpl(SubMenuRepository subMenuRepository){
        this.subMenuRepository = subMenuRepository;
        this.baseRepo = subMenuRepository;
    }
}
