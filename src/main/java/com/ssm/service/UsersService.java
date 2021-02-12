package com.ssm.service;

import com.ssm.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> findAllUsers();

    void doEX(String id);
}
