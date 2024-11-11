package com.optistock.users.controllers.impl;

import com.optistock.users.controllers.IUsersController;
import com.optistock.users.commons.dtos.UserEntryDTO;
import com.optistock.users.commons.dtos.UserExitDTO;
import com.optistock.users.services.IUsersServices;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UsersController implements IUsersController {

    private final IUsersServices iUsersServices;

    public UsersController(IUsersServices iUsersServices) {
        this.iUsersServices = iUsersServices;
    }


    @Override
    @PostMapping("/access")
    @ResponseStatus(HttpStatus.OK)
    public UserExitDTO loginUser(String email, String password) {
        return iUsersServices.loginUser(email, password);
    }

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(UserEntryDTO userDTO) {
         iUsersServices.createUser(userDTO);
    }

    @Override
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserExitDTO updateUser(UserEntryDTO userEntryDTO) {
        return iUsersServices.updateUser(userEntryDTO);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(String id) {
        iUsersServices.deleteUser(id);
    }
}
