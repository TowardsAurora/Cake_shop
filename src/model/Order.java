package model;

import utils.PriceUtils;
import java.util.*;

public class Order {
    //定义private变量，与数据库中一致
    private int id;//定义订单id
    private float total;//定义商品总额
    private int amount;//定义商品数量
    private int status;//定义支付状态//1未付款/2已付款/3已发货/4已完成
    private int paytype;//定义支付方式//1微信/2支付宝/3货到付款
    private String name;//定义用户昵称
    private String phone;//定义用户联系电话
    private String address;//定义用户收货地址
    private Date datetime;//定义订单日期
    private User user;//定义用户


    //创建item映射
    private Map<Integer,Orderitem> itemMap = new HashMap<Integer,Orderitem>();
    //创建item表
    private List<Orderitem> itemList = new ArrayList<Orderitem>();
    public void setUsername(String username) {
        user = new User();
        user.setUsername(username);
    }
    //添加商品方法
    public void addGoods(Goods g) {
        if(itemMap.containsKey(g.getId())) {
            Orderitem item = itemMap.get(g.getId());
            item.setAmount(item.getAmount()+1);
        }else {
            Orderitem item = new Orderitem(g.getPrice(),1,g,this);
            itemMap.put(g.getId(), item);
        }
        amount++;
        total = PriceUtils.add(total, g.getPrice());
    }
    //itemList方法
    public List<Orderitem> getItemList() {
        return itemList;
    }
    public void setItemList(List<Orderitem> itemList) {
        this.itemList = itemList;
    }

    //减少商品
    public void lessen(int goodsid) {
        if(itemMap.containsKey(goodsid)) {
            Orderitem item = itemMap.get(goodsid);
            item.setAmount(item.getAmount()-1);
            amount--;
            total = PriceUtils.subtract(total, item.getPrice());
            if(item.getAmount()<=0) {
                itemMap.remove(goodsid);
            }
        }
    }
    //删除商品
    public void delete(int goodsid)
    {
        if(itemMap.containsKey(goodsid)) {
            Orderitem item = itemMap.get(goodsid);
            total = PriceUtils.subtract(total, item.getAmount()*item.getPrice());
            amount-=item.getAmount();
            itemMap.remove(goodsid);
        }
    }

    //itemMap方法
    public Map<Integer, Orderitem> getItemMap() {
        return itemMap;
    }
    public void setItemMap(Map<Integer, Orderitem> itemMap) {
        this.itemMap = itemMap;
    }

    //id方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //total方法
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    //amount方法
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    //status方法
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    //paytype方法
    public int getPaytype() {
        return paytype;
    }
    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }
    //name方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //phone方法
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //address方法
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //datetime方法
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    //user方法
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Order(){
        super();
    }
}
