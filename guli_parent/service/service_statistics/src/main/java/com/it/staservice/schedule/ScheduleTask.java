package com.it.staservice.schedule;

import com.it.staservice.service.StatisticsDailyService;
import com.it.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTask {

    @Autowired
    private StatisticsDailyService staService;

    //在每天的凌晨1点去执行方法，把前一天的数据查询添加
    @Scheduled(cron = "0 0 1 * * ?")
    public void task(){
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }

}
