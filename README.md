# es7
背景介绍：<br>
1.基于 ARM 架构 CPU，国产 Linux 操作系统，为内网做 Elasticsearch 7.12.1 （根据后续生态实际情况，调整为 7.10.2 ） + Springboot 2.5.0 的代码准备 <br>
2.本文采用 Adoptopenjdk 11.0.11+JVM OpenJ9-0.26.0 作为prod 即生产JDK，把 Oracle 1.8.0_191 HotSpot作为 dev 和 test (以实际情况为准)，即开发和测试环境JDK，生产环境JDK下载地址参见 https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9 <br>
3.目前已经安装配置 elasticsearch-analysis-ik-7.12.1，也可以事后根据需要替换为hanlp-restful 0.04 <br>
4.本工程建议安装部署 Kibana 7.12.1 , 主要目的是匹配 Elasticsearch 版本保持版本号一致 <br>
5.建议使用 Postman 8.5.1 作为开发测试工具 <br>
6.本文开发测试浏览器为 Chrome 91.0.4472.101 <br>
7.本工程开发 OS 为 macOS Big Sur 11.4 <br>
8.本工程使用 maven 版本为 3.8.1 <br>
9.中文分词采用 IK Analysis for Elasticsearch https://github.com/medcl/elasticsearch-analysis-ik/releases/tag/v7.12.1 （工程最近2天内有更新到了13.1版本）<br>
10.启动不同系统要注意第2条提到的不同 JDK 版本确认后，CLI 下使用 mvn spring-boot:run -P dev 启动开发环境， mvn spring-boot:run -P test 启动测试环境，mvn spring-boot:run -P prod 启动生产环境 <br>
11.因 Hanlp 具有8种分词模式可选，较IK总共2种分词模式更为丰富。但受限生态能力支持，若中文分词采用 hanlp，则 Elasticsearch 版本目前只能暂时降为 7.10.2 （ https://www.elastic.co/downloads/past-releases#elasticsearch 及对应的 https://www.elastic.co/downloads/past-releases/elasticsearch-7-10-2 ）, HanLP 参见 https://github.com/KennFalcon/elasticsearch-analysis-hanlp/releases/tag/v7.10.2 ，此时 Kibana 也将采用 7.10.2 参见 https://www.elastic.co/downloads/past-releases#kibana 及对应的 https://www.elastic.co/downloads/past-releases/kibana-7-10-2 ，中文分词库参见 https://github.com/hankcs/HanLP/releases <br>
12.为了更好理解本代码，参考文档https://github.com/bettermorn/KGCourse/wiki/%E7%9F%A5%E8%AF%86%E5%9B%BE%E8%B0%B1%E6%9E%84%E5%BB%BA%E5%B7%A5%E5%85%B7%E5%92%8C%E4%BB%A3%E7%A0%81%E9%80%9F%E6%9F%A5%E8%A1%A8 <br>

本工程启动的前置条件：<br>
1.必须安装 Elasticsearch 7.12.1 并启动 <br>
2.推荐启动 Kibana7.12.1 <br>

本地开发资源：<br>
KibanaDev Tools URL：http://localhost:5601/app/dev_tools#/console <br>
效果参见本地目录截图 src/test/data/screenShot<br>

windowws下碰到idea的报错：<br>
1.Error running 'ServiceStarter': Command line is too long. Shorten command line for ServiceStarter or also for Application default configuration. <br>
解法:修改项目下 .idea\workspace.xml，找到标签 <component name="PropertiesComponent">(大概在23行) ， 在标签里加一行  <property name="dynamic.classpath" value="true" /> <br>
2.jdk环境要一致,否则会出现各种不合符预期的情况：
留意 IDEA的Setting-Build,Execution,Deployment-Build Tools-Maven-Importing下的JDK for importer里面的内容一定要保证和自己本地环境一致的JDK <br>
3.推荐一个jdk：https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.11%2B9/OpenJDK11U-jdk_x64_windows_hotspot_11.0.11_9.zip
