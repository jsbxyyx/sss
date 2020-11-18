package io.jsbxyyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsbxyyx.entity.User;
import io.jsbxyyx.dto.UserQuery;
import io.jsbxyyx.dto.UserBO;

/**
 * @author jsbxyyx
 */
public interface UserMapper extends BaseMapper<User> {

    Page<UserBO> selectByPage(Page<UserBO> page, UserQuery query);

}
