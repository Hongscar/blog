# blog
My own blog.Using SSM + Redis + Bootstrap + jQuery + Druid,writing in the last year(2018).

Change the properties in the /src/main/resources/applicationContext-mybatis.xml, and it will work.

What you need to change: the url and password of dataSource, the hostName and password of the connectionFactory(Redis)

------
SSM is Spring + SpringMVC + MyBatis,one of the most common web framework.

Redis is used for caching, you can remove it if you only want to test the SSM project.How to remove the redis:change the applicationContext
-mybatis.xml,remove the properties about redis.For example:poolConfig,connectionFactory,redisTemplate,methodCacheInterceptor,cache:annotation,
Then go to service/Test_Service,remove the annotation:@Cacheable.

Bootstrap and jQuery is used for making website page.Actually it's not a good choice to use jQuery,maybe React is better!!

Druid is one of the opensource datasource of Alibaba,you can change it back to the normal datasource such as C3P0,but we can have a monitor
of the data by using it.Open the monitor by this address: localhost:8000/blog/druid
The account is hong, password is root,you can find it in the web.xml
That's all.Thank you.You can chat with me by 84363715@qq.com.
