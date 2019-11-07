package com.zr.main;

import com.zr.mapper.RoleMapper;
import com.zr.pojo.Role;
import com.zr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.logging.Logger;

public class ChapterMain
{
    public static void main(String[] args) {
       // Logger log = (Logger) Logger.getLogger(String.valueOf(ChapterMain.class));
        SqlSession sqlSession = null;
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper roleMapper = (RoleMapper) sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.findRoles("1").get(0);
       // log.info(role.getRoleName());
        System.out.println(role.toString());

    }
}
