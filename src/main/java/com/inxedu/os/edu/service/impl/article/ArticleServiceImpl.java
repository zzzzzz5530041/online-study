package com.inxedu.os.edu.service.impl.article;

import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.article.ArticleDao;
import com.inxedu.os.edu.entity.article.Article;
import com.inxedu.os.edu.entity.article.ArticleContent;
import com.inxedu.os.edu.entity.article.QueryArticle;
import com.inxedu.os.edu.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author www.inxedu.com
 *
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public int createArticle(Article article) {
		return articleDao.createArticle(article);
	}

	@Override
	public void addArticleContent(ArticleContent content) {
		articleDao.addArticleContent(content);
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Override
	public void updateArticleContent(ArticleContent content) {
		articleDao.updateArticleContent(content);
	}

	@Override
	public void deleteArticleByIds(String[] articleIds) {
		if (articleIds != null && articleIds.length > 0) {
			String ids = "";
			for (int i = 0; i < articleIds.length; i++) {
				if (i < articleIds.length - 1) {
					ids += articleIds[i] + ",";
				} else {
					ids += articleIds[i];
				}
			}
			articleDao.deleteArticleByIds(ids);
			articleDao.deleteArticleContentByArticleIds(ids);
		}
	}

	@Override
	public Article queryArticleById(int articleId) {
		return articleDao.queryArticleById(articleId);
	}

	@Override
	public String queryArticleContentByArticleId(int articleId) {
		return articleDao.queryArticleContentByArticleId(articleId);
	}

	/**
	 * 分页查询文章列表
	 */
	@Override
	public List<Article> queryArticlePage(QueryArticle query, PageEntity page) {
		return articleDao.queryArticlePage(query, page);
	}

	@Override
	public void updateArticleNum(Map<String, String> map) {
		articleDao.updateArticleNum(map);
	}

	/**
	 * 公共多条件查询文章资讯列表,用于前台
	 */
	@Override
	public List<Article> queryArticleList(QueryArticle queryArticle) {
		return articleDao.queryArticleList(queryArticle);
	}

	@Override
	public int queryAllArticleCount() {
		return articleDao.queryAllArticleCount();
	}

}
