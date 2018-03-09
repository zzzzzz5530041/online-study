package com.online.edu.web.service.impl.questions;

import com.online.edu.web.dao.questions.QuestionsTagDao;
import com.online.edu.web.entity.questions.QuestionsTag;
import com.online.edu.web.service.questions.QuestionsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专业service实现
 * @author
 */
@Service("questionsTagService")
public class QuestionsTagServiceImpl implements QuestionsTagService {

    @Autowired
    private QuestionsTagDao questionsTagDao;

	@Override
	public int createQuestionsTag(QuestionsTag questionsTag) {
		return questionsTagDao.createQuestionsTag(questionsTag);
	}

	@Override
	public List<QuestionsTag> getQuestionsTagList(QuestionsTag query) {
		return questionsTagDao.getQuestionsTagList(query);
	}

	@Override
	public void updateQuestionsTagParentId(int questionsTagId, int parentId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("questionsTagId", questionsTagId);
		map.put("parentId", parentId);
		questionsTagDao.updateQuestionsTagParentId(map);
	}

	@Override
	public void updateQuestionsTag(QuestionsTag questionsTag) {
		questionsTagDao.updateQuestionsTag(questionsTag);
	}

	@Override
	public void deleteQuestionsTag(int questionsTagId) {
		questionsTagDao.deleteQuestionsTag(questionsTagId);
	}
}
