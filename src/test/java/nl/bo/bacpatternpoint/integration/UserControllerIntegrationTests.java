package nl.bo.bacpatternpoint.integration;

import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "haker", roles = {"HAKER"})
public class UserControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        User testUser = new User("haker", "$2a$10$hQ2NaTEuDGAIVlYPmmoBQOvzY6C2QOVhXW4tsWQnM9NXQjZB8p7Ue", "HAKER", "haker@email.com", "bio van een haker");
        userRepository.save(testUser);
    }

    @Test
    void testGetUser() throws Exception {
        // Voer de GET-aanroep uit naar het juiste endpoint
        mockMvc.perform(get("/users/{username}", "haker") // Correcte path parameter toegevoegd
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Controleer of de status OK is (200)
                .andExpect(jsonPath("$.username").value("haker")) // Controleer de username
                .andExpect(jsonPath("$.email").value("haker@email.com")) // Controleer het emailadres
                .andExpect(jsonPath("$.biography").value("bio van een haker")); // Controleer de bio van de gebruiker
    }


    @Test
    void testCreateUser() throws Exception {
        String newUserJson = """
                {
                "username": "haker2",
                "password" : "haker2iscool",
                "role" : "HAKER",
                "email" : "haker2@email.com",
                "biography" : "Bio van een haker2"
                }
                
                """;

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUserJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}