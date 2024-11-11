package com.optistock.users.services.impl;


import com.optistock.users.commons.exceptions.InvalidCredentialsException;
import com.optistock.users.converters.UserConverter;
import com.optistock.users.commons.dtos.UserEntryDTO;
import com.optistock.users.commons.dtos.UserExitDTO;
import com.optistock.users.domain.model.User;
import com.optistock.users.domain.repository.UsersRepository;
import com.optistock.users.services.IUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices implements IUsersServices {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserConverter userConverter;


    @Override
    public UserExitDTO loginUser(String email, String password) {
        try {
            User user = usersRepository.findByEmailOrException(email);
            if(!password.equals(user.getPassword())) {
                throw new InvalidCredentialsException("Credenciales incorrectas");
            }
            return userConverter.usertoUserExit(user);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(UserEntryDTO userDTO) {
        try {
            User user = userConverter.userEntryDTOtoUser(userDTO);
            usersRepository.saveIfNotExists(user);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserExitDTO updateUser(UserEntryDTO userEntryDTO) {
        try {
            User user = usersRepository.findByEmailOrException(userEntryDTO.getEmail());
            userConverter.userEntryDTOtoUser(userEntryDTO);
            usersRepository.save(user);
            UserExitDTO userExitDTO = userConverter.usertoUserExit(user);
            return userExitDTO;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(String id) {
        usersRepository.findByIdOrException(id);
        deleteUser(id);

    }
}
