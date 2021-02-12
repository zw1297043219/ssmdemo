package com.ssm.service.impl;

import com.ssm.Exception.MyException;
import com.ssm.dao.UsersDao;
import com.ssm.entity.BizError;
import com.ssm.entity.Users;
import com.ssm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    public void doEX(String id) {
        switch (id){
            case "1":
                throw new MyException(BizError.SYSTEM_ERROR);
            case "2":
                throw new MyException(BizError.INVALID_ERROR);
            case "3":
                throw new MyException(BizError.NOT_AUTHRIOZED);
        }
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> userList = usersDao.findUserList();
        return userList;
    }
}
