package com.it.msmservice.controller;

import com.it.commonutils.R;
import com.it.msmservice.service.MsmService;
import com.it.msmservice.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/edumsm/msm")
@CrossOrigin
public class MsmController {

    @Autowired
    private MsmService msmService;

    @Resource
    private RedisTemplate<String ,String> redisTemplate;

    //发送短信的方法
    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable String phone) throws ExecutionException, InterruptedException {

        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return R.ok();
        }
        //生成随机值然后交给阿里云发送
        code= RandomUtil.getFourBitRandom();
        Map<String ,Object> parma=new HashMap<>();
        parma.put("code",code);
        //调用发送方法
        boolean isSend=msmService.send(parma,phone);
        if(isSend){
            //发送成功，把发送成功的验证码放入redis中
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.ok();
        }else {
            return R.error().message("短信发送失败");
        }
    }

}
