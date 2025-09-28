package com.refractorx95.Book_demo.mapper;

import com.refractorx95.Book_demo.dto.UserInfoDto;
import com.refractorx95.Book_demo.entity.UserInfo;

public class UserInfoMapper {

    public static UserInfoDto toDto(UserInfo userInfo)
    {
        return new UserInfoDto( userInfo.getUserName() ,userInfo.getPassword(),
                userInfo.getRoles());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto)
    {
        return new UserInfo(userInfoDto.userName(),userInfoDto.password(),
                userInfoDto.roles());
    }


}
