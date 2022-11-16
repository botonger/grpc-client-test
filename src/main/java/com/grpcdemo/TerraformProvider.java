package com.grpcdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ncp.provider.v1.Provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class TerraformProvider {
    @Value("${access-key}")
    private String accessKey;
    @Value("${secret-key}")
    private String secretKey;

    public com.ncp.provider.v1.TerraformProvider setProvider() {

        if(accessKey == null) {
            log.error("access key must be provided.");
        }
        if(secretKey == null) {
            log.error("secret key must be provided.");
        }

        return com.ncp.provider.v1.TerraformProvider.newBuilder()
                                                    .setProvider(Provider.newBuilder().setAccessKey(accessKey).setSecretKey(secretKey).build())
                                                    .build();
    }
}
