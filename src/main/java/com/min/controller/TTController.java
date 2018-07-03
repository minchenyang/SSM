package com.min.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SSM
 * @description:
 * @author: mcy
 * @create: 2018-06-24 13:57
 **/
@Controller
public class TTController {
    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(){
        return "123";
    }
}
