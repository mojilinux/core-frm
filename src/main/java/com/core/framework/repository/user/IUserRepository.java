package com.core.framework.repository.user;

import com.core.framework.domain.user.User;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends IGenericRepository<User, String> {

    @Query(value = "select e from User e where e.username = :username")
    User findByUserName(@Param("username") String username);
}
