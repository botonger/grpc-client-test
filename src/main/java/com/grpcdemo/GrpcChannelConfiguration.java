package com.grpcdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class GrpcChannelConfiguration {
    @Value("${grpc-ncp-server.host}")
    private String ncpHost;

    @Value("${grpc-ncp-server.port}")
    private int ncpPort;

    @Value("${grpc-agent-server.host}")
    private String agentHost;

    @Value("${grpc-agent-server.port}")
    private int agentPort;
    @Value("${grpc-hello-server.host}")
    private String testHost;

    @Value("${grpc-hello-server.port}")
    private int testPort;

    @Qualifier("ncpChannel")
    @Bean
    public ManagedChannel ncpChannel() {
        Assert.notNull(ncpHost, "grpc host could not be found");
        return ManagedChannelBuilder.forAddress(ncpHost, ncpPort)
                .usePlaintext()
                .build();
    }

    @Qualifier("agentChannel")
    @Bean
    public ManagedChannel agentChannel() {
        Assert.notNull(agentHost, "grpc host could not be found");
        return ManagedChannelBuilder.forAddress(agentHost, agentPort)
                                    .usePlaintext()
                                    .build();
    }

    @Qualifier("testChannel")
    @Bean
    public ManagedChannel testChannel() {
        Assert.notNull(testHost, "grpc host could not be found");
        return ManagedChannelBuilder.forAddress(testHost, testPort)
                                    .usePlaintext()
                                    .build();
    }
    //        channel.shutdown(); 언제?

}
