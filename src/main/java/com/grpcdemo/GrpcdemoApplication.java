package com.grpcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GrpcdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcdemoApplication.class, args);

//        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.13", 3901)
//                                                      .usePlaintext()
//                                                      .build();
//
//        TerraformAgentServiceBlockingStub stub = TerraformAgentServiceGrpc.newBlockingStub(channel);
//
//        ExecuteResponse response = stub.execute(ExecuteRequest.newBuilder()
//                                                        .setExecuteInfo(CommandExecute.newBuilder()
//                                                                                      .setExecuteType(ExecuteType.EXECUTE_TYPE_APPLY)
//                                                                                .setExecuteDir("hello").build())
//
//                                                        .setHeader(Header.newBuilder()
//                                                                         .setVersion("hello")
////                                                                         .setToIds()
//                                                                           .addToIds("hello")
//                                                                           .setFromId(RequestNode.REQUEST_NODE_CUSTOM)
//                                                                         .build())
//                                                        .build());
//        log.info(String.valueOf(response));
//        log.info(response.getMessage());
//        channel.shutdown();


    }
}
