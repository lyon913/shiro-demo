package com.xqx.test.security;

import java.util.List;

/**
 * Created by Lyon on 2016/10/30.
 */
public interface UserDetails {
    String getLoginName();
    String getPassword();
    List<String> getRoles();
}
