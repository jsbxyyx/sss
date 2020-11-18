package io.jsbxyyx.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jsbxyyx
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDTO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

}
