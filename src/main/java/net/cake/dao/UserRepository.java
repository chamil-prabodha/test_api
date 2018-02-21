package net.cake.dao;

import javax.transaction.Transactional;
import net.cake.model.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Created by chamilp on 2/20/18.
 */
@Repository
@EnableJpaRepositories
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
  public User findUserByUserNameEquals(String userName);
}
