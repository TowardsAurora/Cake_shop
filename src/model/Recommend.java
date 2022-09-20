package model;

public class Recommend {

    //定义private变量，与数据库中一致
    private int id;//定义推荐栏id
    private int type;//定义推荐商品type//1条幅 2热销 3新品
    private Goods goods;//定义推荐商品

    //id方法
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    //type方法
    public int getType(){
        return type;
    }
    public void setType(){
        this.type=type;
    }
    //goods方法
    public Goods getGoods(){
        return goods;
    }
    public void setGoods(Goods goods){
        this.goods=goods;
    }

    //构造
    public Recommend(int id,int type,Goods goods){
        super();
        this.id=id;
        this.type=type;
        this.goods=goods;
    }

}
