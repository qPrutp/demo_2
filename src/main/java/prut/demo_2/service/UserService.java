package prut.demo_2.service;

import prut.demo_2.entity.User;

import java.util.List;

/**
 * Created by vasyl savitskyy on 20.11.2019.
 */
public interface UserService {

    User getById(Long id);
    List<User> getByName(String name);
    User            save(User user);
    User            update(User user);
    boolean         removeById(Long id);
    List<User>      getAll();

}
