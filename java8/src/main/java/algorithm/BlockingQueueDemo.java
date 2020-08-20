package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/7/9 10:16
 */
public class BlockingQueueDemo<E> {

    // 1.因为要阻塞，所以使用synchronized或者ReentrantLock+Condition
    // 2.由于队列有先进先出的特性，所以基于链表实现，插入操作基于链表尾部，删除操作基于链表头部
    // 3.两个方法，出队和入队

    private Lock lock = new ReentrantLock();
    // 链表空时的Condition
    private Condition emptyCondition = lock.newCondition();
    // 链表满时的Condition
    private Condition fullCondition = lock.newCondition();

    private int fullSize = 16;

    // 由于入队是添加数据，出队是删除数据，增删操作比较频繁所以使用LinkedList
    private LinkedList<E> queue = new LinkedList<>();

    public BlockingQueueDemo() {
        ArrayList arrayList = new ArrayList();
    }

    public BlockingQueueDemo(int fullSize) {
        this.fullSize = fullSize;
    }

    public void enterQueue(E e) {
        lock.lock();
        try {
            // 多线程中用while不用if是因为每次现场唤醒以后是接着await方法执行的。
            // 如果用if不会再次判断，当有多个消费者或者生产者的时候会出问题
            while (queue.size() >= fullSize) {
                fullCondition.await();
            }
            queue.add(e);
            emptyCondition.signal();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E outerQueue() {
        lock.lock();
        E ele = null;
        try {
            while (queue.size() <= 0) {
                emptyCondition.await();
            }
            ele = queue.removeFirst();
            return ele;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return ele;
    }

}
