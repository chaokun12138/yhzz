package com.hyzz.controller;

import com.hyzz.pojo.User;
import com.hyzz.service.EVPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EVPIController {

    @Autowired
    private EVPIService evpiService;
    /**
     * 接口:/EVPI
     * EVPI: 完善信息(perfect information)
     * 完善信息
     */
    @PostMapping("/EVPI")
    public ResponseEntity<User> EVPI(User user){
        User evpi = evpiService.evpi(user);
        return ResponseEntity.ok(evpi);
    }
    /**
     * 图片上传
     */
}
