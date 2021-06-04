# es7
背景介绍：<br>
1.基于 ARM 架构 CPU，国产 Linux 操作系统，为内网做 Elasticsearch 7.12.1 + Springboot 2.5.0 的代码准备<br>
2.本文采用 Adoptopenjdk 11.0.11+JVM OpenJ9-0.26.0 作为开发运行 JDK，下载地址参见 https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9 <br>
3.目前已经安装配置 elasticsearch-analysis-ik-7.12.1，也可以事后根据需要替换为hanlp-restful 0.04<br>
4.本工程建议安装部署 Kibana 7.12.1<br>
5.建议使用 Postman 8.5.1 作为开发测试工具<br>
6.本文开发测试用 Chrome 91.0.4472.77<br>
7.本工程开发 OS 为 macOS Big Sur 11.4

本工程启动的前置条件：<br>
1.必须安装 Elasticsearch 7.12.1 并启动<br>
2.推荐启动 Kibana7.12.1<br>


工作更新<br>
2021.6.2<br>
1.es更新了Client由RestHighLevelClient代替TransportClient

