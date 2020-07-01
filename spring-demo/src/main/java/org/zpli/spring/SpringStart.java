package org.zpli.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpli.spring.component.Student;
import org.zpli.spring.config.SpringConfig;
import org.zpli.spring.utils.SpringUtils;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/23 13:52
 */
public class SpringStart {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(SpringConfig.class);

        Student student = SpringUtils.getBean(Student.class);
        student.sayMyself();

    }
}
