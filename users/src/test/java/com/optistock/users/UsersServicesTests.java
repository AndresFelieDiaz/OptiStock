/*
package com.optistock.users;

import com.optistock.users.commons.dtos.UserEntryDTO;
import com.optistock.users.commons.dtos.UserExitDTO;
import com.optistock.users.commons.exceptions.AlreadyExistsException;
import com.optistock.users.converters.UserConverter;
import com.optistock.users.domain.model.User;
import com.optistock.users.domain.repository.UsersRepository;
import com.optistock.users.services.IUsersServices;
import com.optistock.users.services.impl.UsersServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsersServicesTests {


    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private IUsersServices iUsersServices;

    @InjectMocks
    private UserConverter userConverter;

    private UserEntryDTO userEntryDTO;

    private User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userEntryDTO = new UserEntryDTO("jondue@email.com", "Jon Due", "12345678");
        user = new User("jondue@email.com", "Jon Due", "12345678");
    }


    @Test
    void testCreateUserSuccess() {
        // Simular la conversión del DTO a la entidad User
        when(userConverter.userEntryDTOtoUser(userEntryDTO)).thenReturn(user);

        // Simula la verificación de que el usuario no existe
        when(usersRepository.findByEmailOrException(anyString())).thenReturn(false);

        // Llamada al método createUser
        iUsersServices.createUser(userEntryDTO);

        // Verifica que el repositorio save se haya llamado una vez
        verify(usersRepository, times(1)).save(user);
    }

    @Test
    void testCreateUserUserAlreadyExists() {
        // Simula la conversión del DTO a la entidad User
        when(userConverter.userEntryDTOtoUser(userEntryDTO)).thenReturn(user);

        // Simula que el usuario ya existe en la base de datos
        when(usersRepository.findByEmail(anyString())).thenReturn(user);

        // Verifica que se lance una excepción UserAlreadyExistsException
        Exception exception = assertThrows(AlreadyExistsException.class, () -> {
            iUsersServices.createUser(userEntryDTO);
        });

        assertEquals("User with username testUser already exists.", exception.getMessage());
    }

    @Test
    void testCreateUserInvalidDTO() {
        // DTO inválido
        UserEntryDTO invalidDTO = new UserEntryDTO(null, null, null);

        // Verifica que se lance una IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            iUsersServices.createUser(invalidDTO);
        });

        assertEquals("User DTO is incomplete.", exception.getMessage());
    }

    @Test
    void updateUser() {
        when(usersRepository.findById(anyString())).thenReturn(Optional.of(user));
        when(usersRepository.save(any(User.class))).thenReturn(user);

        UserExitDTO updatedUser = iUsersServices.updateUser(new UserEntryDTO("jondue1@email.com", "Jon1 Due", "12345678"));

        assertEquals("Test Product", updatedUser.getUsername());
        verify(usersRepository, times(1)).findByEmail("jondue1@email.com");
        verify(usersRepository, times(1)).save(user);
    }

    @Test
    void deleteUser() {
        doNothing().when(usersRepository).deleteById(anyString());

        iUsersServices.deleteUser("12345678");

        verify(usersRepository, times(1)).deleteById(1L);
    }

}
*/
