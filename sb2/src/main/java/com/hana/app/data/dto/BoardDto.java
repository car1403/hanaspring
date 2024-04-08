package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int boardId;
    private String custId;
    private String boardTitle;
    private String boardContent;
    private LocalDate boardRegdate;
    private LocalDate boardUpdate;
    private int boardCnt;
}
