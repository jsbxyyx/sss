package io.jsbxyyx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsbxyyx.config.Result;
import io.jsbxyyx.dto.UserDTO;
import io.jsbxyyx.service.api.UserService;
import io.jsbxyyx.dto.UserQuery;
import io.jsbxyyx.dto.UserBO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jsbxyyx
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // http://127.0.0.1:8080/user/page?current=1&size=10
    @RequestMapping("/page")
    public Result page(UserQuery query) {
        Page<UserBO> page = userService.page(query);
        return Result.success(page);
    }

    @RequestMapping("/add")
    public Result add(UserDTO request) {
        Long id = userService.add(request);
        return Result.success(id);
    }

    @RequestMapping("/update")
    public Result update(UserDTO request) {
        userService.update(request);
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result delete(UserDTO request) {
        userService.delete(request);
        return Result.success();
    }

    @RequestMapping("/get")
    public Result get(UserQuery query) {
        userService.get(query);
        return Result.success();
    }

}
