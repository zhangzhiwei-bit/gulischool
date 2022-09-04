package com.it.eduservice.service;

import com.it.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-08-15
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService subjectService);

    //课程分类列表树形结构
    List<OneSubject> getAllOneTwoSubject();
}
