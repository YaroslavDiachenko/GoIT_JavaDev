package com.mycompany.app.controller;

import com.mycompany.app.model.Role;
import com.mycompany.app.model.User;
import com.mycompany.app.service.RoleService;
import com.mycompany.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "roleService")
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("users", this.userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        User user = new User();
        List<Long> stringRoles = new ArrayList<>();
        user.setSelectedRoles(stringRoles);
        Set<Role> objectRoles = new HashSet<>();
        user.setUserRoles(objectRoles);
        model.addAttribute("user", user);
        model.addAttribute("users", this.userService.listUsers());
        model.addAttribute("roles", this.roleService.listRoles());
        model.addAttribute("action", "add");
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        Set<Role> userRoles = new HashSet<>();
        for (Long selectedRole : user.getSelectedRoles()) {
            Role role = new Role();
            role.setId(selectedRole);
            userRoles.add(role);
        }
        user.setUserRoles(userRoles);
        user.setSelectedRoles(null);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") UUID id, Model model){
        User user = this.userService.getUserById(id);
        List<Long> selectedRoles = new ArrayList<>();
        for (Role role : user.getUserRoles()) {
            selectedRoles.add(role.getId());
        }
        user.setSelectedRoles(selectedRoles);
        model.addAttribute("user", user);
        model.addAttribute("users", this.userService.listUsers());
        model.addAttribute("roles", this.roleService.listRoles());
        model.addAttribute("action", "edit");
        return "users";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user){
        Set<Role> userRoles = new HashSet<>();
        for (Long selectedRole : user.getSelectedRoles()) {
            Role role = new Role();
            role.setId(selectedRole);
            userRoles.add(role);
        }
        user.setUserRoles(userRoles);
        this.userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable("id") UUID id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }
}
