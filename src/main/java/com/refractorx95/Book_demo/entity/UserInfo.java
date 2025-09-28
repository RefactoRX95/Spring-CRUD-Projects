package com.refractorx95.Book_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

        private String userName;

        private String password;

        private String roles;

    public UserInfo(String userName, String password, String roles) {
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getRoles() {
        return roles;
    }
}
