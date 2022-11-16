package com.grpcdemo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService service;

    @GetMapping("/test")
    public String test() {
        return service.getHello().toString();
    }
}
