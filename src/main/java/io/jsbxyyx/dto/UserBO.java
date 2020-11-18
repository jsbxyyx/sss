package io.jsbxyyx.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author jsbxyyx
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserBO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date createTime;

    private List<UserFavBO> userFavList;

}
