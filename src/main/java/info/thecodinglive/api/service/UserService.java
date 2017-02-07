package info.thecodinglive.api.service;

import info.thecodinglive.api.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yun_dev1 on 2017-02-07.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<?> findAllUserList(){
        return userDao.selectAll();
    }
}
