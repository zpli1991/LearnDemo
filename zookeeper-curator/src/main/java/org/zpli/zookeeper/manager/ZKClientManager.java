package org.zpli.zookeeper.manager;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 17:10
 */
public class ZKClientManager {

    private final static String connectStr = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";

    public static CuratorFramework createCuratorFramework() {
        //重试策略，初试时间1秒，重试3次
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectStr)
                .sessionTimeoutMs(3000)
                .connectionTimeoutMs(5000)
                .retryPolicy(policy)
                .build();
        client.start();
        return client;

    }

    public static void releaseClient(CuratorFramework client){
        client.close();
    }

}
