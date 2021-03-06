package com.online.edu.web.service.impl.praise;

import com.online.edu.web.dao.praise.PraiseDao;
import com.online.edu.web.entity.praise.Praise;
import com.online.edu.web.entity.questions.Questions;
import com.online.edu.web.entity.questions.QuestionsComment;
import com.online.edu.web.service.article.ArticleService;
import com.online.edu.web.service.comment.CommentService;
import com.online.edu.web.service.praise.PraiseService;
import com.online.edu.web.service.questions.QuestionsCommentService;
import com.online.edu.web.service.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 点赞服务接口实现
 *@author
 */
@Service("praiseService")
public class PraiseServiceImpl implements PraiseService {

	@Autowired
	private PraiseDao praiseDao;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionsCommentService questionsCommentService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	
	
	@Override
	public Long addPraise(Praise praise) {
		//根据点赞目标 type 修改相应的 点赞总数
		//点赞类型 1问答点赞 2问答评论点赞
		int type=praise.getType();
		if(type==1){
			Questions questions=questionsService.getQuestionsById(praise.getTargetId());
			questions.setPraiseCount(questions.getPraiseCount()+1);
			questionsService.updateQuestions(questions);
		}else if (type==2) {
			QuestionsComment questionsComment=questionsCommentService.getQuestionsCommentById(praise.getTargetId());
			questionsComment.setPraiseCount(questionsComment.getPraiseCount()+1);
			questionsCommentService.updateQuestionsComment(questionsComment);
		}
		//点赞类型为3的是文章点赞
		if(type==3){
			Map<String,String> map = new HashMap<String,String>();
			map.put("num","+1");
			map.put("type", "praiseCount");
			map.put("articleId", praise.getTargetId()+"");
			articleService.updateArticleNum(map);
		}
		//点赞类型为4的是评论点赞
		if(type==4){
			Map<String,String> map = new HashMap<String,String>();
			map.put("num","+1");
			map.put("type", "praiseCount");
			map.put("commentId", praise.getTargetId()+"");
			commentService.updateCommentNum(map);
		}
		return praiseDao.addPraise(praise);
	}

	@Override
	public int queryPraiseCount(Praise praise) {
		return praiseDao.queryPraiseCount(praise);
	}

}
