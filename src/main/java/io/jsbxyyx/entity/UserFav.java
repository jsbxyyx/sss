package io.jsbxyyx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author jsbxyyx
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@TableName("tb_user_fav")
public class UserFav {

    private Long id;
    private Long userId;
    private String data;
    private Date createTime;

}
