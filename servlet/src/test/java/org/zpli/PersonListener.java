package org.zpli;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 16:50
 */
interface PersonListener<E> {

    void doEat(Event<E> event);

    void doRun(Event<E> event);
}

class Event<E>{

    private E source;

    public Event(E e){
        source=e;
    }

    public E getSource(){
        return source;
    }
}
