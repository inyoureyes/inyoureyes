package Utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 初始化连接池
 * @author Administrator
 *
 */
public class GetConnection {
    private static  DataSource dataSource;
    static {
    	dataSource = new ComboPooledDataSource();
    }
    public static QueryRunner getConnection(){
    	
      
       return new QueryRunner(dataSource);
    }
}
