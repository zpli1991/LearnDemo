package org.zpli.spring.component;

import org.springframework.stereotype.Component;
import org.zpli.spring.aspect.MyAspect;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/23 13:58
 */
@Component
@MyAspect
public class Student {

    public void sayMyself() {
        System.out.println("I am a student...");
    }
}
