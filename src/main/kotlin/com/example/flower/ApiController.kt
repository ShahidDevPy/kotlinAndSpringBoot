package com.example.flower

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class ApiController {
    @GetMapping("/hello")
    fun hello()="hello, My name is Shahid Rasool"
}