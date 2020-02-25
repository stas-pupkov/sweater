package ru.pupkov.stas.rest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import ru.pupkov.stas.rest.domain.Message;
import ru.pupkov.stas.rest.repository.MessageRepo;
import ru.pupkov.stas.rest.service.MessageService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SecondTest {

    @Autowired
    private MessageService messageService;

    @MockBean
    private MessageRepo messageRepo;

    @Test
    void test1() {
        Message message = new Message("newMes", "newTag");
        boolean b = messageService.addMessage(message);
        Assert.isTrue(b);

        Mockito.verify(messageRepo, Mockito.times(1)).save(message);

    }

    @Test
    public void iterator_will_return_hello_world() {
        //подготавливаем
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        //выполняем
        String result = i.next()+" "+i.next();
        //сравниваем
        assertEquals("Hello World", result);
    }

    @Test
    public void with_unspecified_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
    }

    @Test
    public void OutputStreamWriter_rethrows_an_exception_from_OutputStream() throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        //doThrow(new IOException()).when(mock).close();
        osw.close();
        verify(mock).close();
    }
}
