package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

import javax.sql.DataSource;


public class C3P0Utils {
	
	private static DataSource ds ;

    static {

        try {
            //��ʼ�����ӳض���
            ds = new ComboPooledDataSource("testc3p0");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * ��ȡ����Connection����
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
	
	


}
