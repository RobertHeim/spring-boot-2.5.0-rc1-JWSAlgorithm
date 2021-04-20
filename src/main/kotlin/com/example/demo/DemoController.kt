package com.example.demo

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/test")
  suspend fun test() : String {
    return "test"
  }
}
