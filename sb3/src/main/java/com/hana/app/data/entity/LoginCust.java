package com.hana.app.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "logincust", timeToLive = 600)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginCust {
    @Id
    private String loginId;

}