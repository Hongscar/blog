package com.hong.web;

import com.hong.domain.Article;
import com.hong.domain.Comment;
import com.hong.domain.Type;
import com.hong.service.Test_Service;
import com.hong.utils.PageBean;
import com.hong.utils.PageList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 9:58 2018/10/1
 */
@Controller
@Scope("session")
public class TestController {
    //private testService testService;
    private Test_Service testService;   //replace the MyService

    private List<Article> articles;

    private List<Type> types;

    private Article current_article;

    private PageList<Article> pageList;

    private PageBean<Article> pageBean;

    private List<Article> firstThreeArticles;

    private int temp = 1;

    @Autowired
    public void setTest_Service(Test_Service test_service) {
        this.testService = test_service;
    }

    @RequestMapping(value = "/wer.html")
    public String testPage() {
        return "qqq";
    }

    @RequestMapping(value = "/main.html")
    public String testMainPage() {
        return "index";
    }

    @RequestMapping(value = "/articleList.html")
    public ModelAndView testQQPage(String str) {

        ModelAndView modelAndView = new ModelAndView("article_list1");
        if (pageList == null || pageList.getPageData().size() == 0)
            pageList = new PageList<>(articles);

        //List<Article> articleList = testService.getPagerArticles(pageList.getCurrentPage(), pageList.getPageCount());
        List<Article> allArticles = testService.searchArticles(str);

        modelAndView.addObject("pagerList", pageList);
        int beginIndex = (pageList.getCurrentPage() - 1) * pageList.getPageCount();
        int endIndex = beginIndex + pageList.getPageCount() - 1;
        modelAndView.addObject("beginIndex", beginIndex);
        modelAndView.addObject("endIndex", endIndex);

        modelAndView.addObject("articles1", allArticles);
        return modelAndView;
    }

    @RequestMapping(value = "testqqq.html")
    public String testQQQPage() {
        return "temp";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Date: 2018/10/4 16:46
     */
    @RequestMapping(value = "/mainPage.html")
    public ModelAndView mainPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(temp++ + " : " + session.getAttribute("pager"));

        this.articles = testService.getAllArticles();

        List<Article> firstThreeArticles = testService.getThreeArticles();

        types = testService.getTypes();

        if (this.pageBean == null || this.pageBean.getPageData().size() == 0) {
            this.pageBean = (new PageBean<>(this.articles));
            this.pageList = (new PageList<>(this.articles));
            this.firstThreeArticles = firstThreeArticles;
        }

        ModelAndView modelAndView = new ModelAndView("main1");

        //PageBean<Article> temp11 = this.pageBean;
//        for (int i = 0; i < temp11.getPageData().size(); i++) {
//            System.out.println(temp11.getPageData().get(i).getTitle());
//            System.out.println(temp11.getPageData().get(i).getContent().substring(1, 30));
//            System.out.println(temp11.getPageData().get(i).getTimestamp());
//        }
        // System.out.println(this.pageBean.getPageData().size() + " , " + this.pageBean.getPageData().get(0).getTitle());

        modelAndView.addObject("articles", this.pageBean.getPageData());

        int count = this.pageBean.getFullData().size();
        modelAndView.addObject("count", count);

        session.setAttribute("pager", this.pageBean);

        modelAndView.addObject("firstArticle", this.firstThreeArticles.get(0));
        modelAndView.addObject("secondArticle", this.firstThreeArticles.get(1));
        modelAndView.addObject("threeArticle", this.firstThreeArticles.get(2));

        return modelAndView;
    }

    /**
     * @Description:
     * @param: []
     * @return: java.lang.String
     * @Date: 2018/10/5 9:10
     */
    @RequestMapping(value = "addArticle.html")
    @ResponseBody
    public void addArticle(String title, String content, String type) throws Exception {
        List<Type> all_types = testService.getTypes();
        boolean flag = false;
        for (Type type1: all_types) {
            if (type1.getT_name().equals(type)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.err.println("No such Article type!");
            throw new Exception();
        }

        Article article = new Article();
        article.setContent(content);
        article.setTimestamp(new Timestamp(new Date().getTime()));
        article.setType(type);
        article.setTitle(title);

        testService.addArticle(article);
        testService.updateTypeNum(type);
    }

    /**
     * @Description:
     * @param: []
     * @return: java.lang.String
     * @Date: 2018/10/5 9:15
     */
    @RequestMapping(value = "tku.html")
    public String goToAdd() {
        return "add";
    }

    @RequestMapping(value = "addType.html")
    public String goToAddType() {
        return "addType";
    }

    @RequestMapping(value = "addArticleType.html")
    @ResponseBody
    public void addType(String type, String desc) throws Exception {
        List<Type> all_types = testService.getTypes();
        boolean flag = true;
        for (Type type1: all_types) {
            if (type1.getT_name().equals(type)) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.err.println("This type is already exist");
            throw new Exception();
        }
        Type new_type = new Type(type, 0, desc);

        testService.addType(new_type);

    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/5 15:52
     */
    @RequestMapping(value = "addComment.html")
    public String addComment(HttpServletRequest request) {
        String name = request.getParameter("name");
        String mailBox = request.getParameter("mail");
        String content = request.getParameter("content");
        Comment comment = new Comment();
        comment.setTimestamp(new Timestamp(new Date().getTime()));
        comment.setName(name);
        comment.setMailBox(mailBox);
        comment.setContent(content);
        testService.addComment(comment);

        List<Comment> comments = testService.getAllComments();
        request.getSession().setAttribute("comments", comments);
        return "index";
    }

    /**
     * @Description:
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Date: 2018/10/6 6:57
     */
    @RequestMapping(value = "articleType.html")
    @SuppressWarnings("unused")
    public ModelAndView goToType(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("article_type1");

        List<Article> articlesTypeList =
                testService.getPagerArticles(pageBean.getCurrentPage(), pageBean.getPageCount());

        modelAndView.addObject("types", types);
        modelAndView.addObject("articles1", articlesTypeList);

        return modelAndView;
    }

    /**
     * @Description: 
     * @param: [request, response, str]
     * @return: java.lang.String
     * @Date: 2019/5/2 10:58
     */
    @RequestMapping(value = "searchArticles.html")
    public ModelAndView searchArticle(HttpServletRequest request, HttpServletResponse response, String str) throws IOException {
        //JSONObject jsonObject = new JSONObject();


        articles = testService.searchArticles(str);

        ModelAndView modelAndView = new ModelAndView("article_type1");

        modelAndView.addObject("pagerList", pageList);
        int beginIndex = (pageList.getCurrentPage() - 1) * pageList.getPageCount();
        int endIndex = beginIndex + pageList.getPageCount() - 1;
        modelAndView.addObject("beginIndex", beginIndex);
        modelAndView.addObject("endIndex", endIndex);

        modelAndView.addObject("articles1", articles);
        return modelAndView;
    }

    @RequestMapping("findArticleByType.html")
    @ResponseBody
    public void findArticleByType(HttpServletRequest request, HttpServletResponse response, String type) throws IOException{
        JSONArray jsonArray = new JSONArray();

        articles = testService.findArticlesByType(type);
        for (Article article : articles) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("title", article.getTitle());
            jsonObject.put("id", article.getId());
            jsonArray.add(jsonObject);
//            System.out.println(jsonObject.toString());
//            System.out.println(jsonArray.toString());
        }

        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());

        //System.out.println(jsonArray.toString());

    }

    /**
     * @Description: 7:54 response the Ajax GET method,return the JSON data.
     * @param: [request, response]
     * @return: java.lang.String
     * @Date: 2018/10/6 17:00
     */
    @RequestMapping(value = "getTypeArticle.html")
    @SuppressWarnings("all")
    public String getTypeArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (Type type : types) {
            articles = testService.getTypeArticles(type);//
            for (Article article : articles) {
                JSONObject article_obj = new JSONObject();
                article_obj.put("time", article.getTimestamp().toString().split("\\s+")[0]);
                article_obj.put("title", article.getTitle());
                article_obj.put("id", article.getId());
                jsonArray.add(article_obj);
                //System.out.println(jsonArray.toString());
            }
            jsonObject.put(type.getT_name(), jsonArray);
            jsonArray.clear();
            // jsonObject.put(type.getT_name(), jsonArray);
        }
        //response.getWriter().print(jsonObject.toString()); //both ok
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());
        return null;
        //return jsonObject;  //not ok!
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/6 19:20
     */
    @RequestMapping(value = "article.html")
    public String goToArticle(HttpServletRequest request, String id) {   //HttpServletRequest request
        //String id = request.getParameter("id");
        Article article = testService.getIdArticle(id);
        //ArrayList<String> list = new ArrayList<>();
        request.getSession().setAttribute("article_detail_item", article);
        current_article = article;

        return "index";
    }

    /**
     * @Description:
     * @param: []
     * @return: java.lang.String
     * @Date: 2018/10/6 19:25
     */
    @RequestMapping(value = "article_detail.html")
    public String goToArticleDetail() {
        return "article_detail";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 6:40
     */
    @RequestMapping(value = "prev_article.html")
    public String goToPrevByTime(HttpServletRequest request) {
        current_article = testService.getPrevByTime(current_article);
        request.getSession().setAttribute("article_detail_item", current_article);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 7:24
     */
    @RequestMapping(value = "next_article.html")
    public String goToNextByTime(HttpServletRequest request) {
        current_article = testService.getNextByTime(current_article);
        request.getSession().setAttribute("article_detail_item", current_article);
        return "index";
    }


    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 15:07
     */
    @RequestMapping("prev_page.html")
    public String prevPage(HttpServletRequest request) {
        pageBean.prevPage();
        pageBean.updatePageData();
        request.getSession().setAttribute("pager", pageBean);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 15:46
     */
    @RequestMapping("first_page.html")
    public String firstPage(HttpServletRequest request) {
        pageBean.firstPage();
        pageBean.updatePageData();
        request.getSession().setAttribute("pager", pageBean);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 15:47
     */
    @RequestMapping("next_page.html")
    public String nextPage(HttpServletRequest request) {
        PageBean<Article> temp = this.pageBean;

        temp.nextPage();
        temp.updatePageData();

        request.getSession().setAttribute("pager", temp);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 15:48
     */
    @RequestMapping("last_page.html")
    public String lastPage(HttpServletRequest request) {
        pageBean.lastPage();
        pageBean.updatePageData();
        request.getSession().setAttribute("pager", pageBean);
        return "index";
    }


    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 17:17
     */
    @RequestMapping(value = "prev_pageList.html")
    public String prevPageList(HttpServletRequest request) {
        pageList.prevPage();
        pageList.updatePageData();
        request.getSession().setAttribute("pagerList", pageList);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 17:23
     */
    @RequestMapping(value = "first_pageList.html")
    public String firstPageList(HttpServletRequest request) {
        pageList.firstPage();
        pageList.updatePageData();
        request.getSession().setAttribute("pagerList", pageList);
        return "index";
    }


    @RequestMapping("next_pageList.html")
    public String nextPageList(HttpServletRequest request) {
        pageList.nextPage();
        pageList.updatePageData();
        request.getSession().setAttribute("pagerList", pageList);
        return "index";
    }

    /**
     * @Description:
     * @param: [request]
     * @return: java.lang.String
     * @Date: 2018/10/7 17:26
     */
    @RequestMapping("last_pageList.html")
    public String lastPageList(HttpServletRequest request) {
        pageList.lastPage();
        pageList.updatePageData();
        request.getSession().setAttribute("pagerList", pageList);
        return "index";
    }
}
