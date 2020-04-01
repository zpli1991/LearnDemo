package org.zpli.zookeeper.main;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.zpli.zookeeper.callback.ListenerCallback;
import org.zpli.zookeeper.listener.ZNodeListener;
import org.zpli.zookeeper.manager.ZKClientManager;

import java.io.UnsupportedEncodingException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 17:59
 */
public class ZKMain1 {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = ZKClientManager.createCuratorFramework();
        // JSONObject person = new JSONObject();
        // person.put("name", "zpli");
        // person.put("age", 28);
        // person.put("address", "陕西西安");
        //
        // try {
        //     client.create().withMode(CreateMode.PERSISTENT).forPath("/zpli", person.toJSONString().getBytes());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        String workerPath = "/config";

        ZNodeListener curatorListener = new ZNodeListener();
        NodeCache nodeCache = curatorListener.nodeListener(client, "/config", o -> {
            NodeCache varCache = (NodeCache) o;
            ChildData childData = varCache.getCurrentData();
            System.out.println("ZNode节点状态改变, path=" + childData.getPath());
            try {
                System.out.println("ZNode节点状态改变, data=" + new String(childData.getData(), "Utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("ZNode节点状态改变, stat=" + childData.getStat());
        });

        // 第1次变更节点数据
        client.create().creatingParentsIfNeeded().forPath(workerPath, "第1次更改内容".getBytes());
        Thread.sleep(1000);

        // 第2次变更节点数据
        client.setData().forPath(workerPath, "第2次更改内容".getBytes());
        Thread.sleep(1000);

        // 第3次变更节点数据
        client.setData().forPath(workerPath, "第3次更改内容".getBytes());
        Thread.sleep(1000);

        // 第4次变更节点数据
        // client.delete().forPath(workerPath);
        // Thread.sleep(1000);

        curatorListener.releaseNodeCache(nodeCache);
        ZKClientManager.releaseClient(client);
    }
}
