package me.yohohaha.blog.repository;

import me.yohohaha.blog.domain.User;

import java.util.List;

/**
 * User Repository 接口
 * created at 2019/11/17 13:18:51
 *
 * @author Yohohaha
 */
public interface UserRepository {
    /**
     * 创建或修改用户
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();
}
