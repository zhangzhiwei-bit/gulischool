package com.it.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.eduservice.entity.frontvo.CourseFrontVo;
import com.it.eduservice.entity.frontvo.CourseWebVo;
import com.it.eduservice.entity.vo.CourseInfoVo;
import com.it.eduservice.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-08-18
 */
public interface EduCourseService extends IService<EduCourse> {

    //添加课程基本信息
    String  saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    //删除课程
    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
