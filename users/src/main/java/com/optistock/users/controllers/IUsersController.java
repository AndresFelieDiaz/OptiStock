package com.optistock.users.controllers;


import com.optistock.users.commons.dtos.UserEntryDTO;
import com.optistock.users.commons.dtos.UserExitDTO;

public interface IUsersController {

    public UserExitDTO loginUser(String email, String password);

    public void createUser(UserEntryDTO userDTO);

    public UserExitDTO  updateUser(UserEntryDTO userEntryDTO);

    public void deleteUser(String id);

}
