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
    private String name;
}
