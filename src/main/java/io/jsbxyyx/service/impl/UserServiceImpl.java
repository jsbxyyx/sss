package io.jsbxyyx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import io.jsbxyyx.dto.UserDTO;
import io.jsbxyyx.dto.UserVO;
import io.jsbxyyx.entity.User;
import io.jsbxyyx.mapper.UserMapper;
import io.jsbxyyx.service.api.UserService;
import io.jsbxyyx.dto.UserQuery;
import io.jsbxyyx.dto.UserBO;
import io.jsbxyyx.util.JsonMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author jsbxyyx
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Page<UserBO> page(UserQuery query) {
        Page<UserBO> page = new Page();
        page.setCurrent(query.getCurrent());
        page.setSize(query.getSize());
        page = userMapper.selectByPage(page, query);
        return page;
    }

    @Override
    public Long add(UserDTO dto) {
        Assert.notNull(dto, "UserDTO is null");
        User user = JsonMapper.convertValue(dto, new TypeReference<User>() {
        });
        user.setId(null);
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public void update(UserDTO dto) {
        Assert.notNull(dto, "UserDTO is null");
        Assert.notNull(dto.getId(), "UserDTO.id is null");
        User user = userMapper.selectById(dto.getId());
        Assert.notNull(user, "user not found : " + dto.getId());
        if (user != null) {
            user.setName(dto.getName());
            userMapper.updateById(user);
        }
    }

    @Override
    public void delete(UserDTO dto) {
        Assert.notNull(dto, "UserDTO is null");
        Assert.notNull(dto.getId(), "UserDTO.id is null");
        userMapper.deleteById(dto.getId());
    }

    @Override
    public UserVO get(UserQuery query) {
        Assert.notNull(query, "UserQuery is null");
        Assert.notNull(query.getId(), "UserQuery.id is null");
        User user = userMapper.selectById(query.getId());
        if (user == null) {
            return null;
        }
        UserVO vo = JsonMapper.convertValue(user, new TypeReference<UserVO>() {
        });
        return vo;
    }

}
