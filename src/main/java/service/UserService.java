package service;

import Bean.User;

import java.util.ArrayList;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/29 23:26
 * @Version: 1.0
 */
public interface UserService {
    User SelectUserByname(String name, int key);
    User SelectUserByid(String id, int key);
    ArrayList<User> selectUserList();
}
