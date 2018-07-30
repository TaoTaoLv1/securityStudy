package com.ywt.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户名：" + username);
        String encode ="{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
        //enabled 是否可用
        //accountNonExpired 是否过期
        //credentialsNonExpired 密码是否过期
        //accountNonLocked 账户是否被锁定 false：被锁定
        return new User(username, new BCryptPasswordEncoder().encode("123456"),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
