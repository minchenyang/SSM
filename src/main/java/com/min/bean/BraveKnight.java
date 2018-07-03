package com.min.bean;

import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @description:
 * @author: mcy
 * @create: 2018-06-25 18:30
 **/
@Component("knight")
public class BraveKnight {
    public void saying(){
        System.out.println("我是骑士..（切点方法）");
    }

}
