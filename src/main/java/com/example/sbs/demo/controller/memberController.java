package com.example.sbs.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbs.demo.dao.MemberDao;

@Controller
public class memberController {
	
	MemberDao dao = new MemberDao();
	
	@RequestMapping("addMember")
	@ResponseBody
	public String add(String memId, String memName, String memPw){
		dao.insertMember(memId, memName, memPw);
		
		return "회원에 가입되셨습니다";
	}
	
	@RequestMapping("memberList")
	@ResponseBody
	public ArrayList<Member> members() {
		ArrayList<Member> list = dao.getMembers();
		
		return list;
	}
	
	@RequestMapping("selectMember")
	@ResponseBody
	public Member select(String memId, String memPw) {
		return dao.getMember(memId, memPw);
	}
	
	public String update(String memId, String memPw, String newMemPw) {
		int result = dao.updateMember(memId, newMemPw, newMemPw);
		
		if(result == 1) {
			return "회원정보가 수정되었습니다";
		}
		
		return "패스워드를 다시입력하세요";
	}
	
	public String delete(String memId, String memPw) {
		return "";
	}
	
	
}
