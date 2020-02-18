package ru.pupkov.stas.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.pupkov.stas.rest.domain.Message;
import ru.pupkov.stas.rest.domain.repos.MessageRepo;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
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

    @Autowired
    private MessageRepo messageRepo;

    @Test
    public void contextLoads() throws Exception {
        assertThat(messageController).isNotNull();
    }

    @Test
    public void test1() {
        Message message = new Message("123", "qwe");
        assertThat(message.getText()).isEqualTo("123");
        assertThat(message.getTag()).isEqualTo("qwe");
        assertThat(message.getId()).isEqualTo(0);
    }

    @Test
    public void test2() throws Exception {
        this.mockMvc.perform(get("/messages"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("dddddddddddddd")));
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







}
