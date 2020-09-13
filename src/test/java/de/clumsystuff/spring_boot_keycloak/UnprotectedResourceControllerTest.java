package de.clumsystuff.spring_boot_keycloak;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(IntegrationTestConfiguration.class)
@WebMvcTest(UnprotectedResourceController.class)
public class UnprotectedResourceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnStatusUp() throws Exception {

        mvc.perform(get("/unprotected")).andExpect(status().isOk());
    }
}
