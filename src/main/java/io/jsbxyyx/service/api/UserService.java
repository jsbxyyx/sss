package io.jsbxyyx.service.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsbxyyx.dto.UserDTO;
import io.jsbxyyx.dto.UserQuery;
import io.jsbxyyx.dto.UserBO;
import io.jsbxyyx.dto.UserVO;

/**
 * @author jsbxyyx
 */
public interface UserService {

    Page<UserBO> page(UserQuery query);

    UserVO get(UserQuery query);

    Long add(UserDTO dto);

    void update(UserDTO dto);

    void delete(UserDTO dto);

}
