package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Type {

    //定义private变量，与数据库中一致
    private int id;//定义商品类别id
    private String name;//定义商品类别名称
    private String encodeName;//定义商品解析名称

    //encodename方法
    public String getEncodeName(){
        return encodeName;
    }
    public void setEncodeName(String encodeName){
        this.encodeName=encodeName;
    }

    //id方法
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    //name方法
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
        try {
            this.encodeName=URLEncoder.encode(name,"utf-8");
        }catch (UnsupportedEncodingException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //构造
    public Type(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public Type() {
        super();
    }
    public Type(String name) {
        super();
        this.name = name;
    }
}
