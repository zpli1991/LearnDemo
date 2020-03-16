package org.zpli;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 16:58
 */
public class PersionMain {

    public static void main(String[] args) {
        Person person = new Person(new PersonListener<Person>() {
            @Override
            public void doEat(Event<Person> event) {
               Person p =  event.getSource();
                System.out.println(p+"chidongxi");
            }

            @Override
            public void doRun(Event event) {
                Person p = (Person) event.getSource();
                System.out.println(p+"pao");
            }
        });

        person.eat();
        person.run();
    }
}
