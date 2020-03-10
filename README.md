# java常用的第三方jar包
## [Apache commons](https://commons.apache.org/)
> Apache Commons封装了许多好用的工具类，使我们在开发中编写少量的代码，提高编码效率

常用的组件：

| 组件 | 功能介绍 |
| ------ | ------ |
|Lang|java基本对象方法的工具类包 如：StringUtils等|
| Codec | 处理常用的编码方法的工具类包 例如DES、SHA1、MD5、Base64等 |
| Collections | 对java集合框架扩展操作 | 
|Email|java发送邮件 对javamail的封装|
|IO|io工具的封装|

## [guava](https://github.com/google/guava)
> 谷歌开源的常用工具类，遵循高效的java语法实践，高效设计良好的API

常用核心库：

* [集合](https://github.com/google/guava/wiki/CollectionUtilitiesExplained)
* [字符串处理](https://github.com/google/guava/wiki/StringsExplained)
* [I/O](https://github.com/google/guava/wiki/IOExplained)

## [fastjson](https://github.com/alibaba/fastjson)
> 阿里开源的json工具类，可以将java对象转化成json字符串，也可以将JSON字符串转换为等效的Java对象
```java
 //java对象转化成json字符串
 User user = new User();
 user.setId("10000");
 user.setName("Tom");
 String jsonString = JSON.toJSONString(user);
 
 //JSON字符串转换为Java对象
 User u = JSON.parseObject(jsonString,User.class);
```
## [joda-time](https://www.joda.org/joda-time/)
> 由于Java SE 8之前的标准日期和时间类使用起来过于繁琐。joda-time替代了jdk的日期实现。从Java SE 8开始，请使用jdk自带的java.time
```java
// joda-time
DateTime dateTime = new DateTime();
// 90天以后的时间
dateTime.plusDays(90).toString("yyyy-MM-dd hh:mm:ss");

//jdk8以后
DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
LocalDateTime now = LocalDateTime.now();
now.plus(day, ChronoUnit.DAYS).format(pattern);
```
## http
[okhttp](https://square.github.io/okhttp/)
> OkHttp是一个高效的HTTP客户端,它的请求/响应API是用连贯构建器(Builder)和不变性设计的。它支持同步阻塞调用和带回调的异步调用
* HTTP/2支持允许对同一主机的所有请求共享一个套接字
* 连接池减少了请求延迟(如果HTTP/2不可用)
* 透明的GZIP压缩了下载文件的大小
* 响应缓存完全避免了网络中的重复请求

[httpclient ](http://hc.apache.org/httpcomponents-client-4.5.x/index.html)
> jdk自带的java.net软件包提供了用于通过HTTP访问资源的基本功能，但它并未提供许多应用程序所需的全部灵活性或功能。HttpClient试图通过提供一个高效，最新且功能丰富的软件包来实现这一空白，以实现最新HTTP标准和建议的客户端

[jdk HTTP Client API](https://openjdk.java.net/groups/net/httpclient/intro.html)
> jdk11 http client取代遗留的java.net.HttpURLConnection,统一http请求客户端。支持HTTP/1.1和HTTP/2(同步和异步编程模型)，将请求和响应主体作为响应流处理，并遵循熟悉的构建器模式。
```java
 HttpClient client = HttpClient.newHttpClient();
 HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com/"))
                .GET()
                .build();
 //同步
 HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
```

## 参考文档
* [Joda-Time 简介](https://www.ibm.com/developerworks/cn/java/j-jodatime.html)
* [JDK11 中的新特性——HTTP Client](http://www.yesdata.net/2018/10/09/http-client-in-jdk11/)



