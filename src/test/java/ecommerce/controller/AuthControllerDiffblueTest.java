package ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.repositories.RoleRepository;
import ecommerce.repositories.UserRepository;
import ecommerce.security.jwt.JwtUtils;
import ecommerce.security.request.LoginRequest;
import ecommerce.security.request.SignupRequest;
import ecommerce.security.response.MessageResponse;

import java.util.Map;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class, PasswordEncoder.class, AuthenticationManager.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AuthControllerDiffblueTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    /**
     * Test {@link AuthController#authenticateUser(LoginRequest)}.
     * <p>
     * Method under test: {@link AuthController#authenticateUser(LoginRequest)}
     */
    @Test
    @DisplayName("Test authenticateUser(LoginRequest)")
    @Tag("MaintainedByDiffblue")
    void testAuthenticateUser() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        JwtUtils jwtUtils = new JwtUtils();
        UserRepository userRepository = mock(UserRepository.class);
        RoleRepository roleRepository = mock(RoleRepository.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthController authController = new AuthController(jwtUtils, userRepository, roleRepository, encoder,
                new ProviderManager(new RunAsImplAuthenticationProvider()));

        // Act
        ResponseEntity<?> actualAuthenticateUserResult = authController
                .authenticateUser(new LoginRequest("janedoe", "iloveyou"));

        // Assert
        Object body = actualAuthenticateUserResult.getBody();
        assertTrue(body instanceof Map);
        HttpStatusCode statusCode = actualAuthenticateUserResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals(2, ((Map<String, Object>) body).size());
        assertEquals("Bad credentials", ((Map<String, Object>) body).get("message"));
        assertEquals(404, actualAuthenticateUserResult.getStatusCodeValue());
        assertEquals(HttpStatus.NOT_FOUND, statusCode);
        assertFalse((Boolean) ((Map<String, Object>) body).get("status"));
        assertTrue(actualAuthenticateUserResult.hasBody());
        assertTrue(actualAuthenticateUserResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link AuthController#authenticateUser(LoginRequest)}.
     * <ul>
     *   <li>Given {@link AccountExpiredException#AccountExpiredException(String)}
     * with {@code Msg}.</li>
     *   <li>Then calls {@link LoginRequest#getUsername()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AuthController#authenticateUser(LoginRequest)}
     */
    @Test
    @DisplayName("Test authenticateUser(LoginRequest); given AccountExpiredException(String) with 'Msg'; then calls getUsername()")
    @Tag("MaintainedByDiffblue")
    void testAuthenticateUser_givenAccountExpiredExceptionWithMsg_thenCallsGetUsername() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        JwtUtils jwtUtils = new JwtUtils();
        UserRepository userRepository = mock(UserRepository.class);
        RoleRepository roleRepository = mock(RoleRepository.class);
        AuthController authController = new AuthController(jwtUtils, userRepository, roleRepository,
                new BCryptPasswordEncoder(), null);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getUsername()).thenThrow(new AccountExpiredException("Msg"));

        // Act
        ResponseEntity<?> actualAuthenticateUserResult = authController.authenticateUser(loginRequest);

        // Assert
        verify(loginRequest).getUsername();
        Object body = actualAuthenticateUserResult.getBody();
        assertTrue(body instanceof Map);
        HttpStatusCode statusCode = actualAuthenticateUserResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals(2, ((Map<String, Object>) body).size());
        assertEquals("Bad credentials", ((Map<String, Object>) body).get("message"));
        assertEquals(404, actualAuthenticateUserResult.getStatusCodeValue());
        assertEquals(HttpStatus.NOT_FOUND, statusCode);
        assertFalse((Boolean) ((Map<String, Object>) body).get("status"));
        assertTrue(actualAuthenticateUserResult.hasBody());
        assertTrue(actualAuthenticateUserResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link AuthController#registerUser(SignupRequest)}.
     * <p>
     * Method under test: {@link AuthController#registerUser(SignupRequest)}
     */
    @Test
    @DisplayName("Test registerUser(SignupRequest)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testRegisterUser() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@3410ca2 testClass = ecommerce.controller.DiffblueFakeClass150, locations = [], classes = [ecommerce.controller.AuthController, org.springframework.security.crypto.password.PasswordEncoder, org.springframework.security.authentication.AuthenticationManager], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@5d7ef33, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@348b326, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@ec41c8e8, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@3de6f186], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("jane.doe@example.org");
        signupRequest.setPassword("iloveyou");
        signupRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signupRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);
    }

    /**
     * Test {@link AuthController#registerUser(SignupRequest)}.
     * <ul>
     *   <li>Then return Body Message is {@code Error: Email is already in use!}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AuthController#registerUser(SignupRequest)}
     */
    @Test
    @DisplayName("Test registerUser(SignupRequest); then return Body Message is 'Error: Email is already in use!'")
    @Tag("MaintainedByDiffblue")
    void testRegisterUser_thenReturnBodyMessageIsErrorEmailIsAlreadyInUse() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.existsByEmail(Mockito.<String>any())).thenReturn(true);
        when(userRepository.existsByUserName(Mockito.<String>any())).thenReturn(false);
        JwtUtils jwtUtils = new JwtUtils();
        RoleRepository roleRepository = mock(RoleRepository.class);
        AuthController authController = new AuthController(jwtUtils, userRepository, roleRepository,
                new BCryptPasswordEncoder(), null);

        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail("jane.doe@example.org");
        signUpRequest.setPassword("iloveyou");
        signUpRequest.setUsername("janedoe");

        // Act
        ResponseEntity<?> actualRegisterUserResult = authController.registerUser(signUpRequest);

        // Assert
        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
        verify(userRepository).existsByUserName(eq("janedoe"));
        Object body = actualRegisterUserResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualRegisterUserResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Error: Email is already in use!", ((MessageResponse) body).getMessage());
        assertEquals(400, actualRegisterUserResult.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, statusCode);
        assertTrue(actualRegisterUserResult.hasBody());
        assertTrue(actualRegisterUserResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link AuthController#registerUser(SignupRequest)}.
     * <ul>
     *   <li>Then return Body Message is
     * {@code Error: Username is already taken!}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AuthController#registerUser(SignupRequest)}
     */
    @Test
    @DisplayName("Test registerUser(SignupRequest); then return Body Message is 'Error: Username is already taken!'")
    @Tag("MaintainedByDiffblue")
    void testRegisterUser_thenReturnBodyMessageIsErrorUsernameIsAlreadyTaken() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.existsByUserName(Mockito.<String>any())).thenReturn(true);
        JwtUtils jwtUtils = new JwtUtils();
        RoleRepository roleRepository = mock(RoleRepository.class);
        AuthController authController = new AuthController(jwtUtils, userRepository, roleRepository,
                new BCryptPasswordEncoder(), null);

        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail("jane.doe@example.org");
        signUpRequest.setPassword("iloveyou");
        signUpRequest.setUsername("janedoe");

        // Act
        ResponseEntity<?> actualRegisterUserResult = authController.registerUser(signUpRequest);

        // Assert
        verify(userRepository).existsByUserName(eq("janedoe"));
        Object body = actualRegisterUserResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualRegisterUserResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Error: Username is already taken!", ((MessageResponse) body).getMessage());
        assertEquals(400, actualRegisterUserResult.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, statusCode);
        assertTrue(actualRegisterUserResult.hasBody());
        assertTrue(actualRegisterUserResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link AuthController#registerUser(SignupRequest)}.
     * <ul>
     *   <li>Then throw {@link AccountExpiredException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AuthController#registerUser(SignupRequest)}
     */
    @Test
    @DisplayName("Test registerUser(SignupRequest); then throw AccountExpiredException")
    @Tag("MaintainedByDiffblue")
    void testRegisterUser_thenThrowAccountExpiredException() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.existsByUserName(Mockito.<String>any()))
                .thenThrow(new AccountExpiredException("Error: Role is not found."));
        JwtUtils jwtUtils = new JwtUtils();
        RoleRepository roleRepository = mock(RoleRepository.class);
        AuthController authController = new AuthController(jwtUtils, userRepository, roleRepository,
                new BCryptPasswordEncoder(), null);

        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail("jane.doe@example.org");
        signUpRequest.setPassword("iloveyou");
        signUpRequest.setUsername("janedoe");

        // Act and Assert
        assertThrows(AccountExpiredException.class, () -> authController.registerUser(signUpRequest));
        verify(userRepository).existsByUserName(eq("janedoe"));
    }
}
