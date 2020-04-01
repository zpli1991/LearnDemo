package org.zpli.zookeeper.listener;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.zpli.zookeeper.callback.ListenerCallback;

import java.io.IOException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/18 11:05
 */
public class ZNodeListener {

    //2.Node Cache  监控本节点的变化情况   连接 目录 是否压缩
    //监听本节点的变化  节点可以进行修改操作  删除节点后会再次创建(空节点)
    public static NodeCache nodeListener(CuratorFramework client, String zNode, ListenerCallback callback) throws Exception {
        NodeCache nodeCache = new NodeCache(client, zNode, false);
        nodeCache.getListenable().addListener(() -> {
            callback.callBack(nodeCache);
        });
        nodeCache.start();
        return nodeCache;
    }


    public static void releaseNodeCache(NodeCache nodeCache) throws IOException {
        nodeCache.close();
    }
}
