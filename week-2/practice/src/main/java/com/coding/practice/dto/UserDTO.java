package com.coding.practice.dto;

public class UserDTO {

    private Long userId;
    private String userName;
    private String email;
    private Integer age;


    public UserDTO(){}

    public UserDTO(Long userId, String name, String email, Integer age) {
        this.userId = userId;
        this.userName = name;
        this.email = email;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
