package com.ss.spring.member.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	// 클래스 멤버 변수는 작성!
	private String id;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String phone;
	private String address;
	private String email;
	private String[] hobby; // 축구,야구,영화보기
	private Date enrollDate;

}