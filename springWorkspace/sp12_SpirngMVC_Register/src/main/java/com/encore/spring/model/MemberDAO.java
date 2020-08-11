package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberDAO {
	public List<Member> viewAllMember();
	public Member findMember(String id);
	public void registerMember(Member vo);
	public void updateMember(Member vo);
}