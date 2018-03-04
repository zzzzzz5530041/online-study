package com.online.edu.web.entity.article;

import java.io.Serializable;


/**
 * 文章内容
 * @author www.inxedu.com
 */
public class ArticleContent implements Serializable{

	private static final long serialVersionUID = 9026163273595049826L;
	/**文章ID*/
	private int articleId;
	/**文章对应的内容*/
	private String content;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
