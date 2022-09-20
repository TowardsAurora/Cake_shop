package utils;

//导入c3p0连接池以便更方便的连接MySQL数据库。
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceUtils {

    //使用c3p0数据源
    private static DataSource dataSource=new ComboPooledDataSource();

    //getDataSource方法,来获取数据库中的数据
    public static DataSource getDataSource(){
        return dataSource;
    }

    //getConnection方法,用来连接数据库,并能够抛出异常
    public static Connection getConnection()throws SQLException{
        return dataSource.getConnection();
    }
}
