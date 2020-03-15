package io.qmeta.engprofiles.heartbeat

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/heartbeat")
class HeartBeatController {

    @GetMapping("/ping")
    fun ping():String {
        return "pong"
    }
}