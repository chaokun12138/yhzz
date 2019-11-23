package com.hyzz.controller;


import com.aliyuncs.CommonResponse;
import com.aliyuncs.utils.StringUtils;
import com.hyzz.Config.SmsProperties;
import com.hyzz.utils.NumberUtils;
import com.hyzz.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class SmsController {
    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private SmsProperties prop;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final  String KEY_PREFIX = "user:code:phone:";

    /**
     * 发送短信验证码
     * @param phone
     * @throws Exception
     */
    @GetMapping("/sendSms/{phone}")
    public void sendSms(@PathVariable(value = "phone")String phone) {
        //生成随机code
        String code = NumberUtils.generateCode(6);
        //存储到redis库中
        redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
        if (StringUtils.isEmpty(phone)|| StringUtils.isEmpty(code)) {
            // 放弃处理
            return;
        }
        // 发送消息
        CommonResponse response = smsUtils.sendSms(phone, code,
                prop.getSignName(),
                prop.getVerifyCodeTemplate());

    }
}
