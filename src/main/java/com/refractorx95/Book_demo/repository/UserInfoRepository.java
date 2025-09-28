package com.refractorx95.Book_demo.repository;

import com.refractorx95.Book_demo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    Optional<UserInfo> findByUserName(String userName);

}
