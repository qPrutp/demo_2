package prut.demo_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prut.demo_2.entity.User;

import java.util.List;

/**
 * Created by vasyl savitskyy on 20.11.2019.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByName(String name);

}
