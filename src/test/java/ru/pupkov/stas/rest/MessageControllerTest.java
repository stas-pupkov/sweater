package ru.pupkov.stas.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.pupkov.stas.rest.repository.MessageRepo;
import ru.pupkov.stas.rest.web.MessageController;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MessageController.class)
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageRepo messageRepo;

    @Test
    void return200() throws Exception {
        mockMvc.perform(get("/messages"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}