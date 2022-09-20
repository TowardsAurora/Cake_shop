package service;

import dao.GoodsDao;
import model.Goods;
import model.Page;

import javax.management.monitor.StringMonitorMBean;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class GoodsService {

    //定义private goodsDao成员
    private GoodsDao goodsDao=new GoodsDao();

    //得到商品列表
    public List<Map<String, Object>> getGoodsList(int recommendType) {
        List<Map<String,Object>> list=null;
        try {
            list=goodsDao.getGoodsList(recommendType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //获得条幅展示的商品
    public List<Map<String,Object>> getScrollGood() {
        List<Map<String,Object>> list=null;
        try {
            list=goodsDao.getScrollGood();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据类型id来选择商品
    public List<Goods> selectGoodsByTypeID(int typeID, int pageNumber, int pageSize)
    {
        List<Goods> list=null;
        try {
            list=goodsDao.selectGoodsByTypeID(typeID,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    //根据类型id来选择页面
    public Page selectPageByTypeID(int typeID,int pageNumber)
    {
        Page p=new Page();
        p.setPageNumber(pageNumber);
        int totalCount=0;
        try {
            totalCount=goodsDao.getCountOfGoodsByTypeID(typeID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8,totalCount);

        List list=null;
        try {
            list=goodsDao.selectGoodsByTypeID(typeID,pageNumber,8);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        p.setList(list);
        return p;
    }


    //获取商品推荐页面
    public Page getGoodsRecommendPage(int type,int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = goodsDao.getRecommendCountOfGoodsByTypeID(type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        try {
            list = goodsDao.selectGoodsbyRecommend(type, pageNumber, 8);
            for(Goods g : (List<Goods>)list) {
                g.setScroll(goodsDao.isScroll(g));
                g.setHot(goodsDao.isHot(g));
                g.setNew(goodsDao.isNew(g));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    //根据id来获取商品
    public Goods getGoodsById(int id) {
        Goods g=null;
        try {
            g = goodsDao.getGoodsById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return g;
    }


    //得到商品搜索页面
    public Page getSearchGoodsPage(String keyword, int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
//			totalCount = goodsDao.getGoodsCount(typeId);
            totalCount = goodsDao.getSearchCount(keyword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        try {
//			list = goodsDao.selectGoods(keyword, pageNo, 8);
            list = goodsDao.selectSearchGoods(keyword,pageNumber,8);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }


    //添加推荐项方法
    public void addRecommend(int id,int type) {
        try {
            goodsDao.addRecommend(id, type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //移除推荐项方法
    public void removeRecommend(int id,int type) {
        try {
            goodsDao.removeRecommend(id, type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //插入推荐项方法
    public void insert(Goods goods) {
        try {
            goodsDao.insert(goods);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //更新推荐项方法
    public void update(Goods goods) {
        try {
            goodsDao.update(goods);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //根据goods id来删除goods
    public void delete(int id) {
        try {
            goodsDao.delete(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
