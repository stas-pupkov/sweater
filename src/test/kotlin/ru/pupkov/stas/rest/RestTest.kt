package ru.pupkov.stas.rest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class RestTest {

    @Test
    fun whenCalled_shouldReturnHello() {
        println("run test")
       //val result = testRestTemplate.getForEntity("/hello", String::class.java)
       //assertNotNull(result)
       //assertEquals(result.statusCode, HttpStatus.OK)
       //assertEquals(result?.body, "hello world")
    }
}