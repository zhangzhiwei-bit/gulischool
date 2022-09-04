package com.it.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.eduservice.entity.EduSubject;
import com.it.eduservice.entity.excel.SubjectData;
import com.it.eduservice.service.EduSubjectService;
import com.it.servicebase.exceptionhandler.GuliException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {


    //SubjectExcelListener不能交给spring管理，需要自己手动的new
    public EduSubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

        if(subjectData==null){
            throw new GuliException(20001,"文件数据为空");
        }
        //一行一行的读取，每次读取有两个值
        EduSubject existOne = this.existOneSubject(subjectService, subjectData.getOneSubjectName());
        if(existOne==null){//没有相同的一级分类，添加
            existOne=new EduSubject();
            existOne.setParentId("0");
            existOne.setTitle(subjectData.getOneSubjectName());
            subjectService.save(existOne);
        }
        //获取一级分类的id
        String pid=existOne.getId();
        EduSubject existTwo=this.existTwoSubject(subjectService,subjectData.getTwoSubjectName(),pid);
        if(existTwo==null){
            existTwo=new EduSubject();
            existTwo.setParentId(pid);
            existTwo.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(existTwo);
        }


    }

    //判断一级分类不能重复
    private EduSubject existOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }

    //判断二级分类不能重复
    private EduSubject existTwoSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
