# es7
背景介绍：<br>
1.基于arm架构cpu，国产linux操作系统，为内网做ES7.12.1+Springboot2.5的代码准备<br>
2.本文采用adoptopenjdk11.0.11+jvmOpenJ9-0.26.0作为开发运行JDK，下载地址参见 https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9<br>
3.目前已经安装配置elasticsearch-analysis-ik-7.12.1，也可以事后根据需要替换为hanlp-restful0.04<br>
4.本工程建议安装和部署kibana7.12.1<br>
5.建议使用postman8.5.1作为开发测试工具
6.本文开发测试用chrome91.0.4472.77

本工程启动的前置条件：<br>
1.必须安装ES7.12.1并启动<br>
2.推荐启动kibana7.12.1<br>


工作更新<br>
2021.6.2<br>
1.es更新了Client由RestHighLevelClient代替TransportClient
