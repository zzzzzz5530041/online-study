package com.inxedu.os.edu.dao.impl.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.common.CommentDao;
import com.inxedu.os.edu.entity.common.Comment;
/**
 * 评论dao层实现
 * @author www.inxedu.com
 */
@Repository("commentDao")
public class CommentDaoImpl extends GenericDaoImpl implements CommentDao{

	@Override
	public List<Comment> getCommentByPage(Comment comment, PageEntity page) {
		return this.queryForListPageCount("CommentMapper.getCommentByPage", comment, page);
	}

	@Override
	public void addComment(Comment comment) {
		this.insert("CommentMapper.addComment", comment);
	}
	/**
	 * 更新评论
	 */
	@Override
	public void updateComment(Comment comment){
		this.update("CommentMapper.updateComment", comment);
	}
	/**
	 * 查询评论互动
	 */
	@Override
	public List<Comment> queryCommentInteraction(Comment comment){
		return this.selectList("CommentMapper.queryCommentInteraction", comment);
	}
	/**
	 * 更新评论点赞数,回复数等
	 */
	@Override
	public void updateCommentNum(Map<String,String> map){
		this.update("CommentMapper.updateCommentNum", map);
	}
	/**
	 * 查询评论
	 */
	@Override
	public Comment queryComment(Comment comment){
		return this.selectOne("CommentMapper.queryComment", comment);
	}
	/**
	 * 删除评论
	 */
	@Override
	public void delComment(int commentId){
		this.delete("CommentMapper.delComment", commentId);
	}

	@Override
	public List<Comment> queryCommentList(Comment comment) {
		return this.selectList("CommentMapper.queryCommentList", comment);
	}
}
