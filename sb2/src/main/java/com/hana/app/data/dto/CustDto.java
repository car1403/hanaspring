package com.hana.app.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustDto {
    private String id;
    private String pwd;
    @NotEmpty(message = "이름을 입력해주세요")
    private String name;
}
