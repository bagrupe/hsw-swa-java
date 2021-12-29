package de.hsw.kennzeichen;

import static org.hamcrest.Matchers.hasLength;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import de.hsw.kennzeichen.dto.ReservierenRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class KennzeichenMockTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getKennzeichenAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/kennzeichen")
                .param("kennzeichen", "H-AX-1337")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.kennzeichen").exists());
    }

    @Test
    public void postReservierenAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/kennzeichen/reservieren")
                .content(new ObjectMapper().writeValueAsString(new ReservierenRequest("H-AX-1339")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(hasLength(36)));
    }
}
