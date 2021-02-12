package com.ssm.dao;

import com.ssm.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao {
    public List<Users> findUserList();
}
