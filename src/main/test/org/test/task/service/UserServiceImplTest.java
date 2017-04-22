package org.test.task.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.test.task.dao.UserDao;
import org.test.task.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    UserDao dao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindByName() throws Exception {
        User user = new User(1, "Mark");
        when(dao.findByName(anyString())).thenReturn(user);
        Assert.assertEquals(userService.findByName(anyString()), user);
        verify(dao, atLeastOnce()).findByName(anyString());
    }

    @Test
    public void testSave() throws Exception {
        User user = new User(1, "Mark");
        doNothing().when(dao).save(any(User.class));
        userService.save(user);
        verify(dao, atLeastOnce()).save(user);
    }
}