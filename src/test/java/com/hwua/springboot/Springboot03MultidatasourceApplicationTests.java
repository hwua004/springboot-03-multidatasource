package com.hwua.springboot;

import com.hwua.springboot.dao.read.ReadDao;
import com.hwua.springboot.dao.write.WriteDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03MultidatasourceApplicationTests {
    @Autowired
    private ReadDao readDao;

    @Autowired
    private WriteDao writeDao;

    @Test
    public void contextLoads() {
        Map<String,Object> map=readDao.readInfo(1);
        System.out.println(map);
        int a=writeDao.writeInfo(map);
        System.out.println(a);
    }

}
