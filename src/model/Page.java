package model;

import java.util.List;

public class Page {

    //定义private变量
    private int pageNumber;//定义页号
    private int pageSize;//定义页的大小
    private int totalCount;//定义count总数
    private int totalPage;//定义总页数

    private List<Object> list;//定义List

    //放置页面方法
    public void SetPageSizeAndTotalCount(int pageSize,int totalCount)
    {
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        totalPage= (int)Math.ceil((double)totalCount/pageSize);
    }
    //pageNumber方法
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    //pageSize方法
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    //totalCount方法
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    //totalPage方法
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    //List方法
    public List<Object> getList() {
        return list;
    }
    public void setList(List<Object> list) {
        this.list = list;
    }
}
