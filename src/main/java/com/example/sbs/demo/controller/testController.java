package com.example.sbs.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbs.demo.dao.ArticleDao;

@Controller
public class testController {
	
	ArticleDao dao = new ArticleDao();
	
	@RequestMapping("addArticle")
	@ResponseBody
	public String add(int id, String title, String body, String nick){
		dao.insertArticle(id, title, body, nick);
		
		return "게시물이 저장되었습니다";
	}
	
	
	@RequestMapping("list")
	@ResponseBody
	public ArrayList<Article> list() {
		ArrayList<Article> list = dao.getArticles();
		
		return list;
	}
	
	@RequestMapping("updateArticle")
	@ResponseBody
	public String update(int id, String title, String body) {
		dao.updateArticle(id, title, body);
		
		return "게시물이 수정되었습니다.";
	}
	
	@RequestMapping("deleteArticle")
	@ResponseBody
	public String delete(int id) {
		dao.deleteArticle(id);
		
		return "게시물이 삭제되었습니다.";
	}
	
	
	
}
