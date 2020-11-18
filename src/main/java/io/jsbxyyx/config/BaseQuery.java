package io.jsbxyyx.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jsbxyyx
 */
@Setter
@Getter
public abstract class BaseQuery implements java.io.Serializable {

    protected int current = 1;
    protected int size = 10;

}
