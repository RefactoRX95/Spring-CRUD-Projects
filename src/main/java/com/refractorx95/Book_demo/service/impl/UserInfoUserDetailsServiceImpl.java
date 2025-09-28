package com.refractorx95.Book_demo.service.impl;

import com.refractorx95.Book_demo.entity.UserInfo;
import com.refractorx95.Book_demo.mapper.UserInfoUserDetailsMapper;
import com.refractorx95.Book_demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <UserInfo> userInfo = userInfoRepository.findByUserName(username);
        return userInfo.map(UserInfoUserDetailsMapper::new)
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "Not found"));
    }


}
