package com.ss.mvc.member.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int no;			  //사용자 고유 번호
	private String id;        //아이디
	private String password;  //비번
	private String role;	  // 관리자,일반사용자
	private String name;
	private String phone;
	private String email;
	private String address;
	private String hobby;
	private String status;
	private Date enrollDate;  // 회원가입 날짜
	private Date modifyDate;  // 사용자 정보가 수정된 날짜
}
