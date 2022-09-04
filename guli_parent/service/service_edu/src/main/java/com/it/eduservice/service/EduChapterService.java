package com.it.eduservice.service;

import com.it.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-08-18
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节
    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
