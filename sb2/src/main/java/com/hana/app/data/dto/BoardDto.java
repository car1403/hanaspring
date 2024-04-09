package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int boardId;
    private String custId;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime boardRegdate;
    private LocalDateTime boardUpdate;
    private int boardCnt;
    // 조회시 comment 개수 확인
    private int commentCnt;
}
