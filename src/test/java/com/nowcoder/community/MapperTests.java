package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(150);
        System.out.println(user);
//        User user1 = userMapper.selectByName("liubei");
//        System.out.println(user1);
//        User user2 = userMapper.selectByEmail("nowcoder101@sina.com");
//        System.out.println(user2);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123123");
        user.setSalt("aaa");
        user.setEmail("1212@email");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());


        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }

    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows = userMapper.updatePassword(150,"222222");
        System.out.println(rows);
        User user = userMapper.selectById(150);
        System.out.println(user);
    }
    @Test
    public void testDiscussPosts(){
       List<DiscussPost> list = discussPostMapper.selectDiscussPost(149,0,10);
        for(DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
