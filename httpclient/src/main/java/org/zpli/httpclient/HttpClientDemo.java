// package org.zpli.httpclient;
//
// import java.io.PrintWriter;
// import java.util.Arrays;
// import java.util.Map;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.apache.commons.codec.digest.DigestUtils;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import com.dditax.project.ckts.util.kprj.HttpUtils;
// import com.dditax.project.ckts.util.kprj.Sign;
//
// /**
//  * @Description: TODO
//  * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
//  * @author: 李宗萍（0677）
//  * @Date: 2020/4/14 9:20
//  */
// public class HttpClientDemo {
//
//
//         @RequestMapping(value = "getTicket.do", method = RequestMethod.GET)
//         public @ResponseBody void getTicket(HttpServletRequest request, HttpServletResponse response) throws Exception{
//             String jsonstr = "{\"appId\":\""+appId+"\",";
//             String jsapi_ticket = HttpUtils.getJsTicket(appId,secret);
//             // 注意 URL 一定要动态获取
//             String url = request.getParameter("url");
//             System.out.println("url:"+url);
//             Map<String, String> ret = Sign.sign(jsapi_ticket, url);
//             for (Map.Entry entry : ret.entrySet()) {
//                 jsonstr += "\""+entry.getKey() + "\":\"" + entry.getValue()+"\",";
//             }
//             jsonstr = jsonstr.substring(0,jsonstr.length()-1);
//             jsonstr +="}";
//             System.out.println(jsonstr);
//             response.getWriter().println(jsonstr);
//         }
//     }
//
//             package com.dditax.project.ckts.util.kprj;
// import java.io.BufferedInputStream;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.net.MalformedURLException;
// import java.net.URI;
// import java.net.URL;
// import java.net.URLConnection;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;
// import java.util.zip.GZIPInputStream;
//
// import org.apache.http.HttpEntity;
// import org.apache.http.HttpResponse;
// import org.apache.http.NameValuePair;
// import org.apache.http.client.ClientProtocolException;
// import org.apache.http.client.HttpClient;
// import org.apache.http.client.entity.UrlEncodedFormEntity;
// import org.apache.http.client.methods.CloseableHttpResponse;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.client.methods.HttpPost;
// import org.apache.http.entity.StringEntity;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.DefaultHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.message.BasicNameValuePair;
// import org.apache.http.protocol.HTTP;
// import org.apache.http.util.EntityUtils;
// import com.alibaba.fastjson.JSON;
// import com.alibaba.fastjson.JSONObject;
//     public class HttpUtils {
//         private static String access_Token = "";
//         /**
//          * @Description: http get请求共用方法
//          * @param @param reqUrl
//          * @param @param params
//          * @param @return
//          * @param @throws Exception
//          * @author dapengniao
//          * @date 2016年3月10日 下午3:57:39
//          */
//         @SuppressWarnings("resource")
//         public static String sendGet(String reqUrl, Map<String, String> params)
//                 throws Exception {
//             InputStream inputStream = null;
//             HttpGet request = new HttpGet();
//             try {
//                 String url = buildUrl(reqUrl, params);
//                 HttpClient client = new DefaultHttpClient();
//
//                 request.setHeader("Accept-Encoding", "gzip");
//                 request.setURI(new URI(url));
//
//                 HttpResponse response = client.execute(request);
//
//                 inputStream = response.getEntity().getContent();
//                 String result = getJsonStringFromGZIP(inputStream);
//                 return result;
//             } finally {
//                 if (inputStream != null) {
//                     inputStream.close();
//                 }
//                 request.releaseConnection();
//             }
//
//         }
//
//         /**
//          * @Description: http post请求共用方法
//          * @param @param reqUrl
//          * @param @param params
//          * @param @return
//          * @param @throws Exception
//          * @author dapengniao
//          * @date 2016年3月10日 下午3:57:53
//          */
//         @SuppressWarnings("resource")
//         public static String sendPost(String reqUrl, Map<String, String> params)
//                 throws Exception {
//             try {
//                 Set<String> set = params.keySet();
//                 List<NameValuePair> list = new ArrayList<NameValuePair>();
//                 for (String key : set) {
//                     list.add(new BasicNameValuePair(key, params.get(key)));
//                 }
//                 if (list.size() > 0) {
//                     try {
//                         HttpClient client = new DefaultHttpClient();
//                         HttpPost request = new HttpPost(reqUrl);
//
//                         request.setHeader("Accept-Encoding", "gzip");
//                         request.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
//
//                         HttpResponse response = client.execute(request);
//
//                         InputStream inputStream = response.getEntity().getContent();
//                         try {
//                             String result = getJsonStringFromGZIP(inputStream);
//
//                             return result;
//                         } finally {
//                             inputStream.close();
//                         }
//                     } catch (Exception ex) {
//                         ex.printStackTrace();
//                         throw new Exception("网络连接失败,请连接网络后再试");
//                     }
//                 } else {
//                     throw new Exception("参数不全，请稍后重试");
//                 }
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//                 throw new Exception("发送未知异常");
//             }
//         }
//
//         /**
//          * @Description: http post请求json数据
//          * @param @param urls
//          * @param @param params
//          * @param @return
//          * @param @throws ClientProtocolException
//          * @param @throws IOException
//          * @author dapengniao
//          * @date 2016年3月10日 下午3:58:15
//          */
//         public static String sendPostBuffer(String urls, String params)
//                 throws ClientProtocolException, IOException {
//             HttpPost request = new HttpPost(urls);
//
//             StringEntity se = new StringEntity(params, HTTP.UTF_8);
//             request.setEntity(se);
//             // 发送请求
//             @SuppressWarnings("resource")
//             HttpResponse httpResponse = new DefaultHttpClient().execute(request);
//             // 得到应答的字符串，这也是一个 JSON 格式保存的数据
//             String retSrc = EntityUtils.toString(httpResponse.getEntity());
//             request.releaseConnection();
//             return retSrc;
//
//         }
//
//         /**
//          * @Description: http请求发送xml内容
//          * @param @param urlStr
//          * @param @param xmlInfo
//          * @param @return
//          * @author dapengniao
//          * @date 2016年3月10日 下午3:58:32
//          */
//         public static String sendXmlPost(String urlStr, String xmlInfo) {
//             // xmlInfo xml具体字符串
//
//             try {
//                 URL url = new URL(urlStr);
//                 URLConnection con = url.openConnection();
//                 con.setDoOutput(true);
//                 con.setRequestProperty("Pragma:", "no-cache");
//                 con.setRequestProperty("Cache-Control", "no-cache");
//                 con.setRequestProperty("Content-Type", "text/xml");
//                 OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
//                 out.write(new String(xmlInfo.getBytes("utf-8")));
//                 out.flush();
//                 out.close();
//                 BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                 String lines = "";
//                 for (String line = br.readLine(); line != null; line = br.readLine()) {
//                     lines = lines + line;
//                 }
//                 return lines; // 返回请求结果
//             } catch (MalformedURLException e) {
//                 e.printStackTrace();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return "fail";
//         }
//
//         private static String getJsonStringFromGZIP(InputStream is) {
//             String jsonString = null;
//             try {
//                 BufferedInputStream bis = new BufferedInputStream(is);
//                 bis.mark(2);
//                 // 取前两个字节
//                 byte[] header = new byte[2];
//                 int result = bis.read(header);
//                 // reset输入流到开始位置
//                 bis.reset();
//                 // 判断是否是GZIP格式
//                 int headerData = getShort(header);
//                 // Gzip 流 的前两个字节是 0x1f8b
//                 if (result != -1 && headerData == 0x1f8b) {
//                     // LogUtil.i("HttpTask", " use GZIPInputStream  ");
//                     is = new GZIPInputStream(bis);
//                 } else {
//                     // LogUtil.d("HttpTask", " not use GZIPInputStream");
//                     is = bis;
//                 }
//                 InputStreamReader reader = new InputStreamReader(is, "utf-8");
//                 char[] data = new char[100];
//                 int readSize;
//                 StringBuffer sb = new StringBuffer();
//                 while ((readSize = reader.read(data)) > 0) {
//                     sb.append(data, 0, readSize);
//                 }
//                 jsonString = sb.toString();
//                 bis.close();
//                 reader.close();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//
//             return jsonString;
//         }
//
//         private static int getShort(byte[] data) {
//             return (data[0] << 8) | data[1] & 0xFF;
//         }
//
//         /**
//          * 构建get方式的url
//          *
//          * @param reqUrl
//          *            基础的url地址
//          * @param params
//          *            查询参数
//          * @return 构建好的url
//          */
//         public static String buildUrl(String reqUrl, Map<String, String> params) {
//             StringBuilder query = new StringBuilder();
//             Set<String> set = params.keySet();
//             for (String key : set) {
//                 query.append(String.format("%s=%s&", key, params.get(key)));
//             }
//             return reqUrl + "?" + query.toString();
//         }
//
//
//         /**
//          * get请求获取网址
//          * @param url
//          * @param charset
//          * @return
//          */
//         public static String sendGet(String url,String charset){
//             CloseableHttpClient httpClient=HttpClients.createDefault();
//             HttpGet get=new HttpGet(url);
//             CloseableHttpResponse response = null;
//             String result=null;
//             try {
//                 response=httpClient.execute(get);
//                 HttpEntity entity=response.getEntity();
//                 //System.out.println(entity.getContentType().getValue());
//                 result=EntityUtils.toString(entity,charset);
//             } catch (IOException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//             return result;
//         }
//         //获取tickect
//         public static synchronized String getJsTicket(String appId,String secret) throws Exception{
//             JSONObject jsonObject = new JSONObject();
//             String ticket = "";
//             if(access_Token ==""){//如果是第一次获取就直接去请求新的
//                 ticket = getTicket(appId,secret);
//             }else{//否则就请求旧的
//                 String result = sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_Token+"&type=jsapi","UTF-8");
//                 jsonObject = JSON.parseObject(result);
//                 int resultCode = jsonObject.getIntValue("errcode");
//                 if(resultCode!=0){//请求旧的如果不行
//                     ticket = getTicket(appId,secret);//再去请求新的
//                 }else{//如果请求的新的ok
//                     ticket = jsonObject.getString("ticket");//直接获取
//                 }
//             }
//             System.out.println("token:"+access_Token);
//             return ticket;
//         }
//         /**
//          * 获取最新的ticket
//          * @return
//          * @throws Exception
//          */
//         public static String getTicket(String appId,String secret) throws Exception{
//             JSONObject jsonObject = new JSONObject();
//             Map<String, String> params = new HashMap<String, String>();
//             params.put("grant_type", "client_credential");
//             params.put("appid",appId);//wx78c7f3bd1a8a0806
//             params.put("secret",secret);//8e93006f3b6d8f2f6edf7958393a0378
//             String jstoken = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
//             System.out.println(jstoken);
//             access_Token = net.sf.json.JSONObject.fromObject(jstoken).getString("access_token"); // 获取到token并赋值保存
//             String result = sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_Token+"&type=jsapi","UTF-8");
//             jsonObject = JSON.parseObject(result);
//             return jsonObject.getString("ticket");
//         }
//     }
// }
