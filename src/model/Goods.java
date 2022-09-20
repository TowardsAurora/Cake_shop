package model;

public class Goods {

    //定义private变量，与数据库中一致
    private int id;//商品id
    private String name;//商品名称
    private String cover;//商品封面图片
    private String image1;//商品详情图1
    private String image2;//商品详情图2
    private float price;//商品单价
    private String intro;//商品介绍
    private int stock;//商品库存
    private Type type;//商品类型


    //定义boolean判断工具
    private boolean isScroll;//商品是否为条幅展示
    private boolean isHot;//商品是否为热销品展示
    private boolean isNew;//商品是否为新品展示

    //Scroll方法
    public boolean getIsScroll(){
        return isScroll;
    }

    public void setScroll(boolean isScroll){
        this.isScroll=isScroll;
    }

    //Hot方法
    public  boolean getIsHot(){
        return isHot;
    }

    public void setHot(boolean isHot){
        this.isHot=isHot;
    }


    //isNew方法
    public boolean getIsNew(){
        return isNew;
    }

    public void setNew(boolean isNew){
        this.isNew=isNew;
    }

    //
    public void setTypeid(int typeid) {
        if(type==null) {
            type = new Type();
        }
        type.setId(typeid);
    }
    public void setTypename(String typename) {
        if(type==null) {
            type = new Type();
        }
        type.setName(typename);
    }


    @Override
    //String转换方法
    public String toString() {
        return "Goods [id=" + id + ", name=" + name + ", cover=" + cover + ", image1=" + image1 + ", image2=" + image2
                + ", price=" + price + ", intro=" + intro + ", stock=" + stock + ", type=" + type + "]";
    }

    //id方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //name方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //cover方法
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    //image1方法
    public String getImage1() {
        return image1;
    }
    public void setImage1(String image1) {
        this.image1 = image1;
    }
    //image2方法
    public String getImage2() {
        return image2;
    }
    public void setImage2(String image2) {
        this.image2 = image2;
    }
    //price方法
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    //intro方法
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    //stock方法
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    //type方法
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    //构造
    public Goods() {
        super();
    }
    public Goods(int id, String name, String cover, String image1, String image2, float price, String intro, int stock,
                 Type type) {
        super();
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.intro = intro;
        this.stock = stock;
        this.type = type;
    }
}
