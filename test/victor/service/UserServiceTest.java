package victor.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import victor.dao.UserDAO;
import victor.model.User;

import java.time.LocalDate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserDAO userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setup() {
        user = new User("victor", "VictorDev@gmail.com", LocalDate.now());
    }

    @Test
    @DisplayName("Should create a user with sucess!")
    void create() {
        userService.create(user);

        verify(userRepository).save(user);
    }

    @Test
    @DisplayName("Shoud return users, not allow null")
    void listAll() {

        when(userRepository.findAll()).thenReturn(List.of(user));


        List<User> users = userService.listAll();


        assertThat(users)
                .isNotEmpty()
                .hasSize(1);

        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Shoud update users")
    void updateInfo() {
        userService.updateInfo(user);
        verify(userRepository).update(user);
    }

    @Test
    @DisplayName("Shoud delete users")
    void remove() {
        userService.remove(user.getId());

        verify(userRepository).deleteById(user.getId());
    }
}