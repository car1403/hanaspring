package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chart2Dto {
    private String name;
    private long m1;
    private long m2;
    private long m3;
    private long m4;
    private long m5;
    private long m6;
    public List<Long> getM(){
        List<Long> list = new ArrayList<>();
        list.add(this.m1);
        list.add(this.m2);
        list.add(this.m3);
        list.add(this.m4);
        list.add(this.m5);
        list.add(this.m6);
        return list;
    }

}
