package com.optistock.users.commons.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntryDTO implements Serializable {

    public String email;
    public String username;
    public String password;

}
