package com.refractorx95.Book_demo.repository;

import com.refractorx95.Book_demo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {


}
