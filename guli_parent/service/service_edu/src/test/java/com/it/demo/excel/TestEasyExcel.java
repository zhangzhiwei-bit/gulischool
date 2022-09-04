package com.it.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) {
        //实现excel写操作
        String filename="E:\\JavaPro\\gulischool\\write.xlsx";
        //调用easyExcel
//        EasyExcel.write(filename, DemoData.class).sheet("学生列表").doWrite(getData());


//        实现excel读操作
        EasyExcel.read(filename, DemoData.class,new ExcelListener()).sheet().doRead();

    }
    //创建方法，返回list集合
    private static List<DemoData> getData(){
        List<DemoData>list=new ArrayList<>();
        for(int i=0;i<10;i++){
            DemoData demoData=new DemoData();
            demoData.setSno(i);
            demoData.setSname("tom"+i);
            list.add(demoData);
        }
        return list;
    }
}
