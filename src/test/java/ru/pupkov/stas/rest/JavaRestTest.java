package ru.pupkov.stas.rest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.pupkov.stas.rest.domain.Message;

@SpringBootTest
public class JavaRestTest {

    @Test
    public void test1() {
        Message message = new Message("123", "qwe");
        Assert.assertEquals("123", message.getText());
        Assert.assertEquals("qwe", message.getTag());
        Assert.assertEquals(0, message.getId());
    }
}
