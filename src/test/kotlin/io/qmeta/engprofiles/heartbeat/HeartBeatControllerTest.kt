package io.qmeta.engprofiles.heartbeat

import io.qmeta.engprofiles.EngProfilesApplication
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(classes = [EngProfilesApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class HeartBeatControllerTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun ping() {
        var result = testRestTemplate.getForEntity("/heartbeat/ping",String.javaClass)
        assertEquals(result?.statusCode,HttpStatus.OK)
        assertEquals(result?.body,"pong")
    }
}