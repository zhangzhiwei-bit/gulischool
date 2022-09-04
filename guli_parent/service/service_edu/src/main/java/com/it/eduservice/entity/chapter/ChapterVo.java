package com.it.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {
    private String id;
    private String title;

    //在章节中表示小节
    private List<VideoVo> children=new ArrayList<>();
}
