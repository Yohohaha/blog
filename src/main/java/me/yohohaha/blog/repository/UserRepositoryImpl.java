package me.yohohaha.blog.repository;

import me.yohohaha.blog.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

/**
 * User Repository 接口实现
 * created at 2019/11/17 13:24:07
 *
 * @author Yohohaha
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> USER_MAP = new ConcurrentHashMap<>();

    private static AtomicLong ID_COUNTER = new AtomicLong();


    @Override
    public User saveOrUpdateUser(final User user) {
        Long id = user.getId();
        return USER_MAP.computeIfAbsent(id, id1 -> {
            user.setId(ID_COUNTER.incrementAndGet());
            return user;
        });
    }

    @Override
    public void deleteUser(final Long id) {
        USER_MAP.remove(id);
    }

    @Override
    public User getUserById(final Long id) {
        return USER_MAP.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(USER_MAP.values());
    }
}
