package com.online.edu.web.service.impl.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.web.dao.questions.QuestionsTagRelationDao;
import com.online.edu.web.entity.questions.QuestionsTagRelation;
import com.online.edu.web.service.questions.QuestionsTagRelationService;

/**
* 问答和 问答标签的 关联表service层接口实现
* @author www.inxedu.com
*/
@Service("questionsTagRelationService")
public class QuestionsTagRelationServiceImpl implements QuestionsTagRelationService {

	@Autowired
	private QuestionsTagRelationDao questionsTagRelationDao;
	@Override
	public Long addQuestionsTagRelation(QuestionsTagRelation questionsTagRelation) {
		return questionsTagRelationDao.addQuestionsTagRelation(questionsTagRelation);
	}

	@Override
	public List<QuestionsTagRelation> queryQuestionsTagRelation(QuestionsTagRelation questionsTagRelation) {
		return questionsTagRelationDao.queryQuestionsTagRelation(questionsTagRelation);
	}

}
