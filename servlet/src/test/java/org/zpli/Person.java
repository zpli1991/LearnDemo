package org.zpli;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 16:51
 */
public class Person {

    private PersonListener listener;

    public Person(PersonListener listener) {
        this.listener = listener;
    }

    public void eat(){
        if(null != listener){
            listener.doEat(new Event(this));
        }
    }

    public void run(){
        if(null != listener){
            listener.doRun(new Event(this));
        }
    }
}
