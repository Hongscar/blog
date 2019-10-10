package com.hong.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Seth
 * @Description: 用于"文章"子界面的分页，实现是根据页数，从数据库中获取相应数量的文章，然后全部输出。
 * @Date: Created in 16:31 2018/10/7
 */
@SuppressWarnings("unused")
public class PageList<E> {
    private int currentPage = 1;    //当前页
    private int pageCount = 8;      //每页显示的行数
    private int totalCount;         //总记录数
    private int totalPage;          //总页数 = 总记录数 / 每页显示的行数 + 1
    private List<E> pageData = new ArrayList<>();
    private List<E> fullData = new ArrayList<>();

    public PageList() {

    }

    public PageList(List<E> list) {
        this.setFullData(list); //所有记录
        this.setTotalCount(list.size());    //记录数
        this.setTotalPage(getTotalPage());  //默认总页数
        updatePageData();
    }

    public int getTotalPage() {
        if (totalCount % pageCount == 0) {
            totalPage = totalCount / pageCount;
        } else {
            totalPage = totalCount / pageCount + 1;
        }
        return totalPage;
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

    private void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getPageData() {
        return pageData;
    }

    private void setPageData(List<E> pageData) {
        this.pageData = pageData;
    }

    public List<E> getFullData() {
        return fullData;
    }

    private void setFullData(List<E> fullData) {
        this.fullData = fullData;
    }

    private void addToPageData(E entity) {
        this.getPageData().add(entity);
    }

    /**
     * @Description:
     * @param: []
     * @return: void
     * @Date: 2018/10/7 17:20
     */
    public void updatePageData() {
        int current_first = pageCount * (currentPage - 1);
        pageData.clear();
        for (int i = current_first; (i < current_first + pageCount) && i < totalCount; i++)
            addToPageData(fullData.get(i));
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
}
