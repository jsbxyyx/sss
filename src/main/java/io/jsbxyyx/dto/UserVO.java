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
public class UserVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date createTime;

}
