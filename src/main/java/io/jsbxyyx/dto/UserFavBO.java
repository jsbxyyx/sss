package io.jsbxyyx.dto;

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
public class UserFavBO implements java.io.Serializable {

    private Long id;
    private Long userId;
    private String data;
    private Date createTime;

}
