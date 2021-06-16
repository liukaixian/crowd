package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"} )
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "jerry", "123456", "小老鼠", "Jerry@qq.com", null);
        adminService.saveAdmin(admin);
    }
    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("我是debug");
        logger.error("我是error");
        logger.info("我是info");
        logger.warn("我是warn");


    }

    @Test
    public void testInsertAdmin(){

        for(int i = 0;i<1000;i++){
            adminMapper.insert(new Admin(null, "tom"+i, "123123", "小小"+i, "xiaoxiao"+i+"@qq.com", null));
        }
    }
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
