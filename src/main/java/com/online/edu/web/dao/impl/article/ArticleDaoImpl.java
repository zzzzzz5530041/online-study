package com.online.edu.web.dao.impl.article;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.article.ArticleDao;
import com.online.edu.web.entity.article.Article;
import com.online.edu.web.entity.article.ArticleContent;
import com.online.edu.web.entity.article.QueryArticle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 文章DAO层接口 实现
 * @author
 */
@Repository("articleDao")
public class ArticleDaoImpl extends GenericDaoImpl implements ArticleDao {

	@Override
	public int createArticle(Article article) {
		this.insert("ArticleMapper.createArticle", article);
		return article.getArticleId();
	}

	@Override
	public void addArticleContent(ArticleContent content) {
		this.insert("ArticleMapper.addArticleContent", content);
	}

	@Override
	public void updateArticle(Article article) {
		this.update("ArticleMapper.updateArticle", article);
	}

	@Override
	public void updateArticleContent(ArticleContent content) {
		this.update("ArticleMapper.updateArticleContent", content);
	}

	@Override
	public void deleteArticleByIds(String articleIds) {
		this.delete("ArticleMapper.deleteArticleByIds", articleIds);
	}

	@Override
	public void deleteArticleContentByArticleIds(String articleIds) {
		this.delete("ArticleMapper.deleteArticleContentByArticleIds", articleIds);
	}

	@Override
	public Article queryArticleById(int articleId) {
		return this.selectOne("ArticleMapper.queryArticleById", articleId);
	}

	@Override
	public String queryArticleContentByArticleId(int articleId) {
		return this.selectOne("ArticleMapper.queryArticleContentByArticleId", articleId);
	}

	/**
	 * 分页查询文章列表
	 */
	@Override
	public List<Article> queryArticlePage(QueryArticle query, PageEntity page) {
		return this.queryForListPageCount("ArticleMapper.queryArticlePage", query, page);
	}

	@Override
	public void updateArticleNum(Map<String, String> map) {
		this.update("ArticleMapper.updateArticleNum", map);
	}

	/**
	 * 公共多条件查询文章资讯列表,用于前台
	 */
	@Override
	public List<Article> queryArticleList(QueryArticle queryArticle) {
		return this.selectList("ArticleMapper.queryArticleList", queryArticle);
	}

	@Override
	public int queryAllArticleCount() {
		return this.selectOne("ArticleMapper.queryAllArticleCount", null);
	}

}
