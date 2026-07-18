package com.encurso.service;

import com.encurso.domain.UserLoginRequest;
import com.encurso.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Tests")
class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    @DisplayName("Should validate null request on register")
    void testRegisterWithNullRequest() {
        assertThrows(ValidationException.class, () -> userService.register(null));
    }

    @Test
    @DisplayName("Should validate empty email on register")
    void testRegisterWithEmptyEmail() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("");
        request.setPassword("password123");

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate empty password on register")
    void testRegisterWithEmptyPassword() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword("");

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate null password on register")
    void testRegisterWithNullPassword() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword(null);

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate null email on register")
    void testRegisterWithNullEmail() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail(null);
        request.setPassword("password123");

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate null request on login")
    void testLoginWithNullRequest() {
        assertThrows(ValidationException.class, () -> userService.login(null));
    }

    @Test
    @DisplayName("Should validate empty email on login")
    void testLoginWithEmptyEmail() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("");
        request.setPassword("password123");

        assertThrows(ValidationException.class, () -> userService.login(request));
    }

    @Test
    @DisplayName("Should validate empty password on login")
    void testLoginWithEmptyPassword() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword("");

        assertThrows(ValidationException.class, () -> userService.login(request));
    }

    @Test
    @DisplayName("Should validate blank email (whitespace) on register")
    void testRegisterWithBlankEmail() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("   ");
        request.setPassword("password123");

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate blank password (whitespace) on register")
    void testRegisterWithBlankPassword() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword("   ");

        assertThrows(ValidationException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Should validate blank email (whitespace) on login")
    void testLoginWithBlankEmail() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("   ");
        request.setPassword("password123");

        assertThrows(ValidationException.class, () -> userService.login(request));
    }

    @Test
    @DisplayName("Should validate blank password (whitespace) on login")
    void testLoginWithBlankPassword() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword("   ");

        assertThrows(ValidationException.class, () -> userService.login(request));
    }

    @Test
    @DisplayName("Should return success message on register")
    void testRegisterReturnsSuccessMessage() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("newuser@email.com");
        request.setPassword("password123");

        String result = userService.register(request);
        assertEquals("Usuario Registrado", result);
    }

    @Test
    @DisplayName("Should return success message on login")
    void testLoginReturnsSuccessMessage() {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("user@email.com");
        request.setPassword("password123");

        String result = userService.login(request);
        assertEquals("Usuario Logeado", result);
    }
}
