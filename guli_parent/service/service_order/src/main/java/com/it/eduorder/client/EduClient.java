package com.it.eduorder.client;

import com.it.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("service-edu")
public interface EduClient {


    @PostMapping("/eduservice/coursefront/getCourseInfo/{id}")
    public CourseWebVoOrder getCourseInfo(@PathVariable("id") String id);
}
