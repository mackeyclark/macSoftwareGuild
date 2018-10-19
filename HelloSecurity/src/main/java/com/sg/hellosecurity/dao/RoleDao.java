/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hellosecurity.dao;

import com.sg.hellosecurity.model.Role;
import java.util.List;

/**
 *
 * @author macam
 */
public interface RoleDao {

    Role getRoleById(int id);

    Role getRoleByRole(String role);

    List getAllRoles();

    void deleteRole(int id);

    void updateRole(Role role);

    Role createRole(Role role);
}
