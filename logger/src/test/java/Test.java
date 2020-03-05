import org.zpli.logger.LoggerManager;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/4 17:33
 */
public class Test {

    @org.junit.Test
    public void t1(){
        System.out.println("我来了");
        LoggerManager.getDailyLog().info("你好啊");
    }
}
