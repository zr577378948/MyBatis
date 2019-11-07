package com.zr.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    //获取当前对象用于加锁
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
    //创建SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;
    public SqlSessionFactoryUtils(){}
    //获取SqlSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return  sqlSessionFactory;
        }
    }


    public static SqlSession openSqlSession(){
        if(sqlSessionFactory==null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
