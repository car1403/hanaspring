package com.hana.v1.item.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    Long id;
    @NotEmpty(message = "이메일은 필수 입력값입니다.")
    String name;
    Long price;

}
