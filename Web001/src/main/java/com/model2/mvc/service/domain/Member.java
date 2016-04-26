package com.model2.mvc.service.domain;

import java.sql.Date;

public class Member {
   
   private String userId;
   private String password;
   private String userName;
   private Date Birth;
   private String address;
   private int age;
   private String email;
   private String tel;
   
   
   public Member(){
      
   }

   public String getUserId() {
      return userId;
      
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public Date getBirth() {
      return Birth;
   }

   public void setBirth(Date birth) {
      Birth = birth;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   @Override
   public String toString() {
      return "Member [userId=" + userId + ", password=" + password + ", userName=" + userName + ", Birth=" + Birth
            + ", address=" + address + ", age=" + age + ", email=" + email + ", tel=" + tel + "]";
   }
   
}
