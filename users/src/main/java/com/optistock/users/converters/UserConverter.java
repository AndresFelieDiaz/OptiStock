package com.optistock.users.converters;

import com.optistock.users.commons.dtos.UserEntryDTO;
import com.optistock.users.commons.dtos.UserExitDTO;
import com.optistock.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User userEntryDTOtoUser(UserEntryDTO userEntryDTO) {
        try {
            User user = new User();
            user.setEmail(userEntryDTO.getEmail());
            user.setUsername(userEntryDTO.getUsername());
            user.setPassword(userEntryDTO.getPassword());

            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserExitDTO usertoUserExit(User user) {
        UserExitDTO userExitDTO = new UserExitDTO();
        userExitDTO.setId(user.getId());
        userExitDTO.setEmail(user.getEmail());
        userExitDTO.setUsername(user.getUsername());
        return userExitDTO;
    }

}
