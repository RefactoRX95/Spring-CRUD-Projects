package com.refractorx95.Book_demo.service.impl;

import com.refractorx95.Book_demo.dto.UserInfoDto;
import com.refractorx95.Book_demo.entity.UserInfo;
import com.refractorx95.Book_demo.mapper.UserInfoMapper;
import com.refractorx95.Book_demo.repository.UserInfoRepository;
import com.refractorx95.Book_demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
       UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
       userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
       userInfoRepository.save(userInfo);
       return UserInfoMapper.toDto(userInfo);
    }
}
