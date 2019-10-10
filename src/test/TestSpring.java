import com.hong.domain.Article;
import com.hong.service.Test_Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 15:27 2018/10/5
 */

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Test_Service testService = applicationContext.getBean(Test_Service.class);

        List<Article> articles = testService.getAllArticles();
        for (Article article : articles)
            System.out.println(article.getTitle());
    }
}
