# es7
背景介绍：<br>
1.基于 ARM 架构 CPU，国产 Linux 操作系统，为内网做 Elasticsearch 7.12.1 + Springboot 2.5.0 的代码准备<br>
2.本文采用 Adoptopenjdk 11.0.11+JVM OpenJ9-0.26.0 作为prod 即生产JDK，把Oracle 1.8.0_191 HotSpot作为dev和test，即开发和测试环境JDK，生产环境JDK下载地址参见 https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9 <br>
3.目前已经安装配置 elasticsearch-analysis-ik-7.12.1，也可以事后根据需要替换为hanlp-restful 0.04<br>
4.本工程建议安装部署 Kibana 7.12.1<br>
5.建议使用 Postman 8.5.1 作为开发测试工具<br>
6.本文开发测试用 Chrome 91.0.4472.77<br>
7.本工程开发 OS 为 macOS Big Sur 11.4<br>
8.本工程使用 maven 版本为 3.8.1
9.启动不同系统要注意第2条提到的不同 JDK 版本确认后，CLI 下使用 mvn spring-boot:run -P dev 启动开发环境， mvn spring-boot:run -P test 启动测试环境，mvn spring-boot:run -P prod 启动生产环境<br>

本工程启动的前置条件：<br>
1.必须安装 Elasticsearch 7.12.1 并启动<br>
2.推荐启动 Kibana7.12.1<br>


工作更新<br>
2021.6.2<br>
1.es更新了Client由RestHighLevelClient代替TransportClient

