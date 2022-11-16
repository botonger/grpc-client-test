package com.grpcdemo.hello;

import org.springframework.stereotype.Service;

import com.grpcdemo.StubProvider;
import com.hello.HelloRequest;
import com.hello.HelloResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloService {
    private final StubProvider stubProvider;

    public HelloResponse getHello() {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                                                          .setFirstName("cheyenne")
                                                          .setLastName("shin")
                                                          .build();
        HelloResponse helloResponse = stubProvider.helloStub().hello(helloRequest);

        log.info(helloResponse.getGreeting());

        return helloResponse;
    }
}
