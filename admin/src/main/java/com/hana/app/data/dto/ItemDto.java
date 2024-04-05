package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private int itemId;
    private String itemName;
    private long itemPrice;
    private String imgName;
    private LocalDate regDate;
    private LocalDate updateDate;
    private MultipartFile image;
}
