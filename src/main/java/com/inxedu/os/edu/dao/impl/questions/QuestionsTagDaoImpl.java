package com.inxedu.os.edu.dao.impl.questions;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.edu.dao.questions.QuestionsTagDao;
import com.inxedu.os.edu.entity.questions.QuestionsTag;

/**
 * QuestionsTag对象操作实现类
 * @author www.inxedu.com
 */
@Repository("questionsTagDao")
public class QuestionsTagDaoImpl extends GenericDaoImpl implements QuestionsTagDao {

	@Override
	public int createQuestionsTag(QuestionsTag questionsTag) {
		this.insert("QuestionsTagMapper.createQuestionsTag", questionsTag);
		return questionsTag.getQuestionsTagId();
	}

	@Override
	public List<QuestionsTag> getQuestionsTagList(QuestionsTag query) {
		return this.selectList("QuestionsTagMapper.getQuestionsTagList", query);
	}

	@Override
	public void updateQuestionsTagParentId(Map<String, Object> map) {
		this.update("QuestionsTagMapper.updateQuestionsTagParentId", map);
	}

	@Override
	public void updateQuestionsTag(QuestionsTag questionsTag) {
		this.update("QuestionsTagMapper.updateQuestionsTag", questionsTag);
	}

	@Override
	public void deleteQuestionsTag(int questionsTagId) {
		this.update("QuestionsTagMapper.deleteQuestionsTag", questionsTagId);
	}
	
}
