package com.lami.framework.repository.user;

import com.lami.framework.domain.user.User;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.group.IGroupRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends IGenericRepository<User, Long> {

    @Query(value = "select e from User e where e.username = :username")
    User findByUserName(@Param("username") String username);
}
