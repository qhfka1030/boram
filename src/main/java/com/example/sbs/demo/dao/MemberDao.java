package com.example.sbs.demo.dao;

import java.util.ArrayList;

import com.example.sbs.demo.controller.Member;

public class MemberDao {
	
	ArrayList<Member> members = new ArrayList<Member>();
	
	public ArrayList<Member> getMembers(){
		
		return members;
	}
	public void insertMember(String memId, String memName, String memPw) {
		Member a = new Member();
		
		a.setMemId(memId);
		a.setMemName(memName);
		a.setMemPw(memPw);
		
		members.add(a);
	}
	
	public Member getMember(String memId, String memPw){
		
		return members.get(getMemberNum(memId, memPw));
	}
	
	public int updateMember(String memId, String memPw, String newMemPw){
		
		int num = getMemberNum(memId, memPw);
		
		if(num == -1) {
			return -1;
		}
		
		Member m = members.get(num);
		m.setMemPw(newMemPw);
		
		members.set(num, m);
		
		return 1;
	}
	
	//public int deleteMember(String memId);
	
	public int getMemberNum(String memId, String memPw) {
		for(int i = 0; i<members.size(); i++) {
			Member m = members.get(i);
			if(m.getMemId().equals(memId) &&
					m.getMemPw().equals(memPw)) {
				return i;
			}
		}
		
		return -1;
	}
	
}
