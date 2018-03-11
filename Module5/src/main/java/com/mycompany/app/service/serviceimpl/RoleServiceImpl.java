package com.mycompany.app.service.serviceimpl;

import com.mycompany.app.dao.RoleDao;
import com.mycompany.app.model.Role;
import com.mycompany.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Autowired
    @Qualifier(value = "roleDao")
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return this.roleDao.listAll();
    }
}
