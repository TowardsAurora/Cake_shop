package service;

import dao.*;
import utils.*;
import model.*;
import java.sql.*;
import java.util.List;

public class OrderService {

    //定义private orderDao成员
    private OrderDao orderDao=new OrderDao();


    //添加订单
    public void addOrder(Order order) {
        Connection con = null;
        try {
            con = DataSourceUtils.getConnection();
            con.setAutoCommit(false);

            orderDao.insertOrder(con, order);
            int id = orderDao.getLastInsertId(con);
            order.setId(id);
            for(Orderitem item : order.getItemMap().values()) {
                orderDao.insertOrderItem(con, item);
            }

            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(con!=null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }

    //选择全部项目
    public List<Order> selectAll(int userid){
        List<Order> list=null;
        try {
            list = orderDao.selectAll(userid);
            for(Order o :list) {
                List<Orderitem> l = orderDao.selectAllItem(o.getId());
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    //获取订单页面
    public Page getOrderPage(int status,int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 10;
        int totalCount = 0;
        try {
            totalCount = orderDao.getOrderCount(status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        List list=null;
        try {
            list = orderDao.selectOrderList(status, pageNumber, pageSize);
            for(Order o :(List<Order>)list) {
                List<Orderitem> l = orderDao.selectAllItem(o.getId());
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    //更新交易状态
    public void updateStatus(int id,int status) {
        try {
            orderDao.updateStatus(id, status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //根据订单id来删除order
    public void delete(int id) {
        Connection con = null;
        try {
            con = DataSourceUtils.getDataSource().getConnection();
            con.setAutoCommit(false);

            orderDao.deleteOrderItem(con, id);
            orderDao.deleteOrder(con, id);
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(con!=null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }
}
