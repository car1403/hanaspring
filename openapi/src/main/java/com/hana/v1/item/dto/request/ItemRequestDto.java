package com.hana.v1.item.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    Long id;
    @NotEmpty(message = "이름은 필수 입니다.")
    String name;
    @Min(value = 10, message = "10이상이어야 함................")
    Long price;

}
