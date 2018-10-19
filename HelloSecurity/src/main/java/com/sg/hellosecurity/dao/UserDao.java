/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hellosecurity.dao;

import com.sg.hellosecurity.model.User;
import java.util.List;

/**
 *
 * @author macam
 */
public interface UserDao {

    User getUserById(int id);

    User getUserByUsername(String username);

    List getAllUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User createUser(User user);
}
