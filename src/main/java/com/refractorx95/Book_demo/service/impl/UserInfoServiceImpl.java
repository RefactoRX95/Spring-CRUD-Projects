package com.refractorx95.Book_demo.service.impl;

import com.refractorx95.Book_demo.dto.UserInfoDto;
import com.refractorx95.Book_demo.entity.UserInfo;
import com.refractorx95.Book_demo.mapper.UserInfoMapper;
import com.refractorx95.Book_demo.repository.UserInfoRepository;
import com.refractorx95.Book_demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager  authenticationManager;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
       UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
       userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
       userInfoRepository.save(userInfo);
       return UserInfoMapper.toDto(userInfo);
    }

    @Override
    public String getUserInfo(UserInfoDto userInfoDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInfoDto.userName(), userInfoDto.password()
                )
        );
        if (authentication.isAuthenticated())
            return "Success";
        return  "Failure";
    }
}
