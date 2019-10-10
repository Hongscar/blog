//import com.hong.dao.mybatis.ArticleMybatisDao;
import com.hong.domain.Article;
import com.hong.domain.Comment;
import com.hong.domain.Type;
import com.hong.service.Test_Service;
import com.hong.web.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.List;
import java.lang.ClassLoader;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 9:33 2018/10/18
 */

@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
@Rollback
@Transactional
public class testMybatis extends AbstractTransactionalTestNGSpringContextTests {
    //@Autowired
    //private Mybatis_Service service;

    @Autowired
    private Test_Service service1;

   // @Autowired
   // private ArticleMybatisDao dao;

    //err
    @Test
    public void testMethod() {
        Article article = new Article();
        String title;
       // article = service.getArticle(57);
        System.out.println(article.getTitle());
        System.out.println(article.getTimestamp());
        Assert.assertEquals("javaWEB为什么放弃JSP", article.getTitle());
    }

    @Test
    public void testMethod22() {
        String title;
        title = service1.doSomeBusiness(57);
        System.out.println(title);
        Assert.assertEquals("javaWEB为什么放弃JSP", title);
    }

//    @Test
//    public void testM3() {
//        Article article = new Article();
//        List<Article> articles = service1.getArts();
//        for (Article article1 : articles)
//            System.out.println(article1.getTitle());
//    }
//
//    @Test
//    @Rollback(false)
//    public void testM4() {
//        Article article = new Article();
//        article.setTitle("test134");
//        article.setContent("测试一下");
//        article.setType("Java");
//        service1.addArt(article);
//    }
//
//    @Test
//    public void testGetArticle() {
//        Article article = service1.getArticle("集合小结");
//        System.out.println(article.getType() + " , " + article.getId());
//    }
//
//    @Test
//    @Rollback(false)
//    public void testDel() {
//        service1.delArtile("test134");
//    }
//
//    @Test
//    public void testPrev() {
//        Article article = service1.getIdArticle(56);
//        System.out.println(article.getTitle());
//        System.out.println(article.getContent().substring(1,40));
//
//        System.out.println(article.getTimestamp());
//        Article article1 = service1.getNextByTime(article);
//        System.out.println(article1.getTitle() + " , " + article1.getTimestamp());
//    }

    @Test
    public void testPager() {
        List<Article> articles = service1.getPagerArticles(1, 3);
        for (Article article : articles)
            System.out.println(article.getTitle());
    }

    @Test
    public void testComment() {
        Comment comment = new Comment();
        comment.setName("Tony");
        comment.setMailBox("4535@qq.com");
        comment.setContent("Good,nice job!");
        service1.addComment(comment);
        List<Comment> comments = service1.getAllComments();
        for (Comment comment1 : comments)
            System.out.println(comment1.getName() + "," + comment1.getContent() + "," +
             comment1.getMailBox() + "," + comment1.getId() + "," + comment1.getTimestamp());
    }

    @Test
    public void testType() {
        List<Type> types = service1.getTypes();
        for (Type type: types)
            System.out.println(type.getT_name() + " : " + type.getNumber());
    }

    @Test
    public void testSearch() {
        String str = "%s%";
        List<Article> articleList = service1.searchArticles(str);
        for (Article article : articleList)
            System.out.println(article.getTitle());
    }

    @Test
//    @Rollback(false)
    public void addSth() throws InterruptedException {

        TestController testController = new TestController();

        int i = service1.getJava();
        System.out.println(i);

        Article article = new Article();
        article.setType("Java");
        article.setContent("azxc zxc asrwe ds  xcv xcasda a");
        article.setTitle("Test888");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article.setTimestamp(timestamp);

        int j = service1.getJava();
        System.out.println(j);
    }

    @Test
    public void testMy() {
        double a = 3.51f;
        float f = 1.99f;
        int i = (int)a + (int)f;
        System.err.println(i);
    }
}
