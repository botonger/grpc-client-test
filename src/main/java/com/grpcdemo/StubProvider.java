package com.grpcdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.agent.v1.TerraformAgentServiceGrpc;
import com.agent.v1.TerraformAgentServiceGrpc.TerraformAgentServiceBlockingStub;
import com.ncp.storage.v1.NCloudStorageServiceGrpc;
import com.ncp.storage.v1.NCloudStorageServiceGrpc.NCloudStorageServiceBlockingStub;

import com.hello.HelloServiceGrpc;
import com.hello.HelloServiceGrpc.HelloServiceBlockingStub;
import io.grpc.ManagedChannel;

@Component
public class StubProvider {
    private final ManagedChannel ncpChannel;
    private final ManagedChannel testChannel;
    private final ManagedChannel agentChannel;

    public StubProvider(@Qualifier("ncpChannel") ManagedChannel ncpChannel,
                        @Qualifier("testChannel") ManagedChannel testChannel,
                        @Qualifier("agentChannel") ManagedChannel agentChannel) {
        this.ncpChannel = ncpChannel;
        this.testChannel = testChannel;
        this.agentChannel = agentChannel;
    }

    public HelloServiceBlockingStub helloStub() {
        return HelloServiceGrpc.newBlockingStub(testChannel);
    }
    public TerraformAgentServiceBlockingStub agentStub() {
        return TerraformAgentServiceGrpc.newBlockingStub(agentChannel);
    }
    public NCloudStorageServiceBlockingStub ncpStorageStub() {
        return NCloudStorageServiceGrpc.newBlockingStub(ncpChannel);
    }
}
