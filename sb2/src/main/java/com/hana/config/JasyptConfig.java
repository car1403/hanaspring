package com.hana.config;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {


    private static final String KEY = "mykey";
    private static final String ALGORITHM =  "PBEWithMD5AndDES";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(KEY); // 암호화 키
        config.setAlgorithm(ALGORITHM); // 알고리즘
        config.setKeyObtentionIterations("1000"); // 반복할 해싱 회수
        config.setPoolSize("1"); // 인스턴스 pool
        config.setProviderName("SunJCE"); // 프로바이더
        // salt 생성 클래스 지정
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        // 인코딩
        config.setStringOutputType("base64");
        // 설정 정보 set
        encryptor.setConfig(config);

        return encryptor;
    }
}