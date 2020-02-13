package prut.demo_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prut.demo_2.dao.UserDao;
import prut.demo_2.entity.User;

import java.util.List;

/**
 * Created by vasyl savitskyy on 20.11.2019.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Long id) {
        User user = userDao.getOne(id);
        return user;
    }

    @Override
    public List<User> getByName(String name) {
        List<User> list = userDao.findByName(name);
        return list;
    }

    @Override
    public User save(User user) {
        User newUser = userDao.save(user);
        return newUser;
    }

    @Override
    public User update(User user) {
        User newUser = userDao.save(user);
        return newUser;
    }

    @Override
    public boolean removeById(Long id) {
        userDao.deleteById(id);
        return  !userDao.existsById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
