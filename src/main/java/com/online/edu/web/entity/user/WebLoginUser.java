package com.online.edu.web.entity.user;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;

/**
 * 外部登录用户信息
 * @author www.inxedu.com
 */
@EqualsAndHashCode(callSuper = false)
public class WebLoginUser implements Serializable{


   private Long id;// 主键 id
   private Long cusId;// 用户id
   private String email = "";// 邮件
   private String mobile = "";// 手机号
   private String nickname = "";// 用户名
   private String realname;// 真实姓名
   private int gender=0;// 性别：0男 1女
   private String avatar;// 头像地址

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getCusId() {
      return cusId;
   }

   public void setCusId(Long cusId) {
      this.cusId = cusId;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getMobile() {
      return mobile;
   }

   public void setMobile(String mobile) {
      this.mobile = mobile;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public String getRealname() {
      return realname;
   }

   public void setRealname(String realname) {
      this.realname = realname;
   }

   public int getGender() {
      return gender;
   }

   public void setGender(int gender) {
      this.gender = gender;
   }

   public String getAvatar() {
      return avatar;
   }

   public void setAvatar(String avatar) {
      this.avatar = avatar;
   }

   public String getUserInfo() {
      return userInfo;
   }

   public void setUserInfo(String userInfo) {
      this.userInfo = userInfo;
   }

   private String userInfo="";// 用户简介
}
