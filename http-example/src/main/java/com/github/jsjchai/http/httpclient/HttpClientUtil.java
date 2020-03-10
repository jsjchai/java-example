package com.github.jsjchai.http.httpclient;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    private static final int HTTP_OK = 200;

    private static final String UTF_8 = "utf-8";


    /**
     * 无参get请求
     *
     * @param url 请求链接
     * @return response
     */
    public static String get( String url ) {
        return get(url, null);
    }

    /**
     * get请求
     *
     * @param url   请求链接
     * @param param 参数
     * @return response
     */
    public static String get( String url, Map<String, Object> param ) {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String response = null;
        CloseableHttpResponse httResponse = null;

        try {
            HttpGet httpGet = new HttpGet(getUrl(url, param));
            httResponse = httpclient.execute(httpGet);
            if (httResponse.getStatusLine().getStatusCode() == HTTP_OK) {
                response = EntityUtils.toString(httResponse.getEntity(), UTF_8);
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            close(httResponse);
        }

        return response;
    }

    /**
     * 无参post请求
     *
     * @param url 请求链接
     * @return response
     */
    public static String post( String url ) {
        return post(url, null);
    }


    /**
     * post请求
     *
     * @param url   请求链接
     * @param param 参数
     * @return response
     */
    public static String post( String url, Map<String, Object> param ) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String response = null;

        HttpPost httpPost = new HttpPost(url);

        if (param != null && !param.isEmpty()) {
            List<NameValuePair> paramList = new ArrayList<>();
            param.forEach(( k, v ) -> paramList.add(new BasicNameValuePair(k, String.valueOf(v))));

            UrlEncodedFormEntity entity;
            try {
                // 模拟表单
                entity = new UrlEncodedFormEntity(paramList, UTF_8);
            } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
                return null;
            }
            httpPost.setEntity(entity);
        }

        CloseableHttpResponse httResponse = null;
        try {
            httResponse = httpclient.execute(httpPost);
            response = EntityUtils.toString(httResponse.getEntity(), UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(httResponse);
        }
        return response;
    }


    /**
     * 参数拼接
     *
     * @param url   请求链接
     * @param param 参数
     * @return uri
     * @throws URISyntaxException
     */
    private static URI getUrl( String url, Map<String, Object> param ) throws URISyntaxException {
        // 创建uri
        URIBuilder builder = new URIBuilder(url);

        if (param != null && !param.isEmpty()) {
            param.forEach(( k, v ) -> builder.addParameter(k, String.valueOf(v)));
        }

        return builder.build();
    }

    private static void close( CloseableHttpResponse httResponse ) {
        try {
            if (httResponse != null) {
                httResponse.close();
            }
        } catch (IOException ignored) {

        }
    }


}
