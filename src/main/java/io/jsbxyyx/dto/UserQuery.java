package io.jsbxyyx.dto;

import io.jsbxyyx.config.BaseQuery;
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
public class UserQuery extends BaseQuery {

    private static final long serialVersionUID = 1L;

    private Long id;

}
