Logback是由log4j创始人设计的又一个开源日志组件。logback当前分成三个模块：logback-core,logback-classic和logback-access。
logback-core :其它两个模块的基础模块
logback-classic:log4j的一个改良版本（此外logback-classic完整实现SLF4J API使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging）
logback-access:访问模块与Servlet容器集成提供通过Http来访问日志的功能

当我们使用logback-classic.jar时，应用启动，logback会按照如下顺序进行扫描：
在系统配置文件System Properties中寻找是否有logback.configurationFile对应的value
在classpath下寻找是否有logback.groovy（即logback支持groovy与xml两种配置方式）
在classpath下寻找是否有logback-test.xml
在classpath下寻找是否有logback.xml
以上任何一项找到之后都会停止，如果全部都不满足，则默认使用ch.qos.logback.classic.BasicConfigurator的configure方法，
构造一个ConsoleAppender用于向控制台输出日志，默认日志输出格式为”%d{HH:mm:ss.SSS} [%thread] %-5level %org.zpli.logger{36} – %msg%n”。
