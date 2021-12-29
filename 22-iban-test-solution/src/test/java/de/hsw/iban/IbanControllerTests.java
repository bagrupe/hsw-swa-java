package de.hsw.iban;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import de.hsw.iban.dto.IbanRequest;

@SpringBootTest
@AutoConfigureMockMvc
class IbanControllerTests {

	@Autowired
    private MockMvc mvc;

    @Test
    public void validateIbanSuccessAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/ValidateIban")
                .param("iban", "DE75888888880000012345")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban").value("DE75888888880000012345"))
                .andExpect(jsonPath("$.valid").value(true));
    }

	@Test
    public void validateIbanFailAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/ValidateIban")
                .param("iban", "DEXX888888880000012345")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.iban").value("DEXX888888880000012345"))
                .andExpect(jsonPath("$.valid").value(false))
				.andExpect(jsonPath("$.errors").isArray())
				.andExpect(jsonPath("$.errors", hasSize(1)))
				.andExpect(jsonPath("$.errors", hasItem("BAD_IBAN_CHECKDIGIT")));
    }

    @Test
    public void createIbanSuccessAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/api/CreateIban")
                .content(new ObjectMapper().writeValueAsString(new IbanRequest("DE", "12345", "88888888")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban").value("DE75888888880000012345"))
                .andExpect(jsonPath("$.valid").value(true));
    }

	@Test
    public void createIbanFailAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/api/CreateIban")
                .content(new ObjectMapper().writeValueAsString(new IbanRequest("XX", "12345", "88888888")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.iban").value("<invalid>"))
                .andExpect(jsonPath("$.valid").value(false))
				.andExpect(jsonPath("$.errors").isArray())
				.andExpect(jsonPath("$.errors", hasSize(1)))
				.andExpect(jsonPath("$.errors", hasItem("UNIMPLEMENTED_COUNTRY_CODE")));
    }

}
