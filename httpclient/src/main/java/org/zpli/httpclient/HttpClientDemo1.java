package org.zpli.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/18 16:13
 */
public class HttpClientDemo1 {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "http://localhost:8080/servlet/annotation";
        HttpGet httpGet = new HttpGet(url);
        // 配置信息
        RequestConfig requestConfig = RequestConfig
                .custom()
                // 设置连接超时时间，单位毫秒
                .setConnectTimeout(8*1000)
                // 设置请求超时时间，单位毫秒
                .setConnectionRequestTimeout(8 * 1000)
                // socket读写超时时间，单位毫秒
                .setSocketTimeout(5*1000)
                // 设置是否允许重定向，默认为true
                .setRedirectsEnabled(true)
                .build();
        httpGet.setConfig(requestConfig);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            System.out.println(httpResponse.getEntity());
            System.out.println("响应大小: "+httpResponse.getEntity().getContentLength());
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
