package com.online.edu.web.service.comment;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.entity.common.Comment;

import java.util.List;
import java.util.Map;
/**
 *  评论模块service接口
 *  @author
 */
public interface CommentService {
	/**
	 * 分页查询评论
	 */
	public List<Comment> getCommentByPage(Comment comment, PageEntity page);
	/**
	 * 添加评论
	 */
	public void addComment(Comment comment);
	/**
	 * 更新评论
	 */
	public void updateComment(Comment comment);
	/**
	 * 查询评论
	 */
	public Comment queryComment(Comment comment);
	/**
	 * 查询评论互动
	 */
	public List<Comment> queryCommentInteraction(Comment comment);
	/**
	 * 更新评论点赞数,回复数等
	 */
	public void updateCommentNum(Map<String, String> map);
	/**
	 * 删除评论
	 */
	public void delComment(int commentId);
	/**
	 * 查询评论 list
	 */
	public List<Comment> queryCommentList(Comment comment);
}
