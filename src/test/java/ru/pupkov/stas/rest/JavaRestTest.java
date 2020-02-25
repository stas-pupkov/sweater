package ru.pupkov.stas.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.pupkov.stas.rest.domain.Message;
import ru.pupkov.stas.rest.repository.MessageRepo;
import ru.pupkov.stas.rest.web.MessageController;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JavaRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageController messageController;

    @MockBean
    private MessageRepo messageRepo;

    @Test
    public void contextLoads() {
        assertThat(messageRepo).isNotNull();
        System.out.println(messageRepo.existsById(0));
    }

    @Test
    public void creatingMessage() {
        Message message = new Message("newMes", "newTag");
        assertThat(message.getText()).isEqualTo("newMes");
        assertThat(message.getTag()).isEqualTo("newTag");
        assertThat(message.getId()).isEqualTo(0);
    }

    @Test
    public void gettingMessages() throws Exception {
        mockMvc.perform(get("/messages"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")));
    }


    @Test
    public void test3() throws Exception {
        MockHttpServletRequestBuilder multipart = multipart("/add")
                .param("text", "new")
                .param("tag", "tag3");

        this.mockMvc.perform(get("/messages"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("new")));
    }

    @Test
    public void test4() throws Exception {
        when(messageRepo.save(any())).thenReturn(new Message("text222", "tag222"));
        mockMvc.perform(post("/messages/add").contentType("application/json")
                .requestAttr("text", "1")
                .requestAttr("tag", "1"));
        Message message = messageRepo.findByTag("tag222").get(0);
        assertThat(message.getText()).isEqualTo("text222");
        //System.out.println(messageRepo.findAll());


    }







}
