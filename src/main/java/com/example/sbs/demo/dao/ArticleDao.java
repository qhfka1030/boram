package com.example.sbs.demo.dao;

import java.util.ArrayList;

import com.example.sbs.demo.controller.Article;

public class ArticleDao {
	
	ArrayList<Article> articles = new ArrayList<Article>();
	
	public void insertArticle(int id, String title, String body, String nick) {
		Article a = new Article();
		
		a.setId(id);
		a.setTitle(title);
		a.setBody(body);
		a.setNick(nick);
		
		articles.add(a);
		
	}
	
	public ArrayList<Article> getArticles(){
		return articles;
	}
	
	public void updateArticle(int id, String title, String body) {
		
		int num = articleNum(id);
		Article a = articles.get(num);
		
		a.setTitle(title);
		a.setBody(body);
		
		articles.add(num, a);
	}
	
	public void deleteArticle(int id) {
		int num = articleNum(id);
		
		articles.remove(num);
	}
	
	public int articleNum(int id) {
		
		for(int i = 0; i<articles.size(); i++) {
			Article a = articles.get(i);
			if(a.getId()==id) {
				return i;
			}
		}
		
		return -1;
	}
	
}
