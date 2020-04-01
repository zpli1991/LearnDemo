package org.zpli.java8.annotationapi;

import sun.misc.Launcher;

import java.lang.annotation.Annotation;
import java.util.Collections;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 11:08
 */
public class AnnotationMain {

    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        Annotation[] annotations = annotationDemo.getClass().getAnnotations();

        // System.out.println(value);
        // byte short int long float double boolean char
    }
}
