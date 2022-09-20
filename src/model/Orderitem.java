package model;

public class Orderitem {

    //定义private变量，与数据库中一致
    private int id;//定义订单项id
    private float price;//定义商品价格
    private int amount;//定义商品数量
    private String goodsName;//定义商品名称
    private Goods goods;//定义商品
    private Order order;//定义订单


    public void setName(String name) {
        this.goodsName=name;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    //id方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //price方法
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    //amount方法
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    //goods方法
    public Goods getGoods() {
        return goods;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    //order方法
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    //构造
    public Orderitem(float price, int amount, Goods goods, Order order) {
        super();
        this.price = price;
        this.amount = amount;
        this.goods = goods;
        this.order = order;
    }
}
