package service;

import dao.TypeDao;
import model.Type;
import java.sql.SQLException;
import java.util.List;


public class TypeService {

    //定义private typeDao成员
    TypeDao typeDao =new TypeDao();

    //获取所有种类
    public List<Type> GetAllType()
    {
        List<Type> list=null;
        try {
            list= typeDao.GetAllType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据type_id来选择typename
    public Type selectTypeNameByID(int typeid)
    {
        Type type=null;
        try {
            type= typeDao.selectTypeNameByID(typeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }


    //根据id来选择种类
    public Type select(int id) {
        Type t=null;
        try {
            t = typeDao.select(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    //插入新的种类
    public void insert(Type t) {
        try {
            typeDao.insert(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //更新种类
    public void update(Type t) {
        try {
            typeDao.update(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //根据id来删除种类
    public boolean delete(int id) {
        try {
            typeDao.delete(id);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
