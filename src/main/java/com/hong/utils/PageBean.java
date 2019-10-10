package com.hong.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Seth
 * @Description: 用于主页面的文章预览分页，实现细节是数据库先获取所有文章，然后每次显示部分(3篇) (反了
 * @Date: Created in 8:41 2018/10/7
 */
@SuppressWarnings("unused")
public class PageBean<E> {
    private int currentPage = 1;    //当前页
    private int pageCount = 6;      //每页显示的行数
    private int totalCount;         //总记录数
    private int totalPage;          //总页数 = 总记录数 / 每页显示的行数 + 1
    private List<E> pageData = new ArrayList<>();       //分页查询到的数据
    private List<E> fullData = new ArrayList<>();       //所有的数据记录

    public PageBean() {

    }

    public PageBean(List<E> entities) {
        this.setTotalCount(entities.size());  //获取记录数
        this.setTotalPage(getTotalPage());  //获取默认总页数
        int current_first = pageCount * (currentPage - 1);  //当前页的第一个记录，默认为0
        this.setFullDate(entities);
        for (int i = current_first; i < current_first + pageCount; i++)
            addToPageData(entities.get(i));     //初始的当前页的记录
    }

    /**
     * @Description:
     * @param: []
     * @return: void
     * @Date: 2018/10/7 9:26
     */
    public void updatePageData() {
        int current_first = pageCount * (currentPage - 1);
        pageData.clear();
        for (int i = current_first; (i < current_first + pageCount) && i < totalCount; i++)
            addToPageData(fullData.get(i));
    }

    /**
     * @Description:
     * @param: [entity]
     * @return: void
     * @Date: 2018/10/7 9:05
     */
    private void addToPageData(E entity) {
        this.getPageData().add(entity);
    }

    /**
     * @Description: get the totalPage
     * @param: []
     * @return: int
     * @Date: 2018/10/7 8:44
     */
    public int getTotalPage() {
        if (totalCount % pageCount == 0) {
            totalPage = totalCount / pageCount;
        } else {
            totalPage = totalCount / pageCount + 1;
        }
        return totalPage;
    }

    public void prevPage() {
        if (currentPage == 1)
            currentPage = 1;
        else
            currentPage--;
    }

    public void nextPage() {
        if (currentPage == totalPage)
            currentPage = totalPage;
        else
            currentPage++;
    }

    public void firstPage() {
        setCurrentPage(1);
    }

    public void lastPage() {
        setCurrentPage(totalPage);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getPageData() {
        return pageData;
    }

    public void setPageData(List<E> pageData) {
        this.pageData = pageData;
    }

    public List<E> getFullData() {
        return fullData;
    }

    public void setFullDate(List<E> fullData) {
        this.fullData = fullData;
    }
}
