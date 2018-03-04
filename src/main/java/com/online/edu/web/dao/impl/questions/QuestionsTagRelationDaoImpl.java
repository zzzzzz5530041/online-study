package com.online.edu.web.dao.impl.questions;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.questions.QuestionsTagRelationDao;
import com.online.edu.web.entity.questions.QuestionsTagRelation;

/**
 * 问答和 问答标签的 关联表 实现类
 * @author www.inxedu.com
 */
@Repository("questionsTagRelationDao")
public class QuestionsTagRelationDaoImpl extends GenericDaoImpl implements QuestionsTagRelationDao {

	@Override
	public Long addQuestionsTagRelation(QuestionsTagRelation questionsTagRelation) {
		return this.insert("QuestionsTagRelationMapper.createQuestionsTagRelation", questionsTagRelation);
	}

	@Override
	public List<QuestionsTagRelation> queryQuestionsTagRelation(QuestionsTagRelation questionsTagRelation) {
		return this.selectList("QuestionsTagRelationMapper.queryQuestionsTagRelation", questionsTagRelation);
	}

}
