package com.halleluhya.halleluhya.dto;

import lombok.Data;

import java.util.List;
@Data
public class Halleluhyaresponse {
    private List<HalleluhyaDto> content;
    private int pageno;
    private int pagesize;
    private long totalelements;
    private int totalpages;
    private boolean last;
}
