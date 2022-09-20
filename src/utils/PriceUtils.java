package utils;

//导入BigDecimal，用来对超过16位有效位的数进行精确的运算。
import java.math.BigDecimal;

public class PriceUtils {

    /*
    //测试用例
    public static void main(String[] args) {
        //选择double方法进行测试
        double item_a=9.0;
        double item_b=3.0;
        System.out.println("item_a+item_b="+add(item_a,item_b));// 加法运算
        System.out.println("item_a-item_b="+subtract(item_a,item_b));// 减法运算

    }
    */


    //定义float类型 add方法
    public static float add(float item_a,float item_b){
        BigDecimal big_item_a=new BigDecimal(Float.toString(item_a));
        BigDecimal big_item_b=new BigDecimal(Float.toString(item_b));
        return big_item_a.add(big_item_b).floatValue();
    }


    //定义double类型 add方法
    public static double add(double item_a,double item_b){
        BigDecimal big_item_a=new BigDecimal(Double.toString(item_a));
        BigDecimal big_item_b=new BigDecimal(Double.toString(item_b));
        return big_item_a.add(big_item_b).doubleValue();
    }


    //定义float类型 subtract方法
    public static float subtract(float item_a,float item_b){
        BigDecimal big_item_a=new BigDecimal(Float.toString(item_a));
        BigDecimal big_item_b=new BigDecimal(Float.toString(item_b));
        return big_item_a.subtract(big_item_b).floatValue();
    }


    //定义double类型 subtract方法
    public static double subtract(double item_a,double item_b){
        BigDecimal big_item_a=new BigDecimal(Double.toString(item_a));
        BigDecimal big_item_b=new BigDecimal(Double.toString(item_b));
        return big_item_a.subtract(big_item_b).doubleValue();
    }
}
