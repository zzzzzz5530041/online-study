package com.online.edu.web.service.impl.subject;

import com.online.edu.web.dao.subject.SubjectDao;
import com.online.edu.web.entity.subject.QuerySubject;
import com.online.edu.web.entity.subject.Subject;
import com.online.edu.web.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专业service实现
 * @author
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	@Override
	public int createSubject(Subject subject) {
		return subjectDao.createSubject(subject);
	}

	@Override
	public List<Subject> getSubjectList(QuerySubject query) {
		return subjectDao.getSubjectList(query);
	}

	@Override
	public void updateSubjectParentId(int subjectId, int parentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subjectId", subjectId);
		map.put("parentId", parentId);
		subjectDao.updateSubjectParentId(map);
	}

	@Override
	public void updateSubject(Subject subject) {
		subjectDao.updateSubject(subject);
	}
	/**
	 * 修改排序
	 */
	@Override
	public void updateSubjectSort(Subject subject){
		subjectDao.updateSubjectSort(subject);
	}

	@Override
	public void deleteSubject(int subjectId) {
		subjectDao.deleteSubject(subjectId);
	}

	@Override
	public Subject getSubjectBySubject(Subject subject) {
		return subjectDao.getSubjectBySubject(subject);
	}

	@Override
	public List<Subject> getSubjectListByOne(Long subjectId) {
		return subjectDao.getSubjectListByOne(subjectId);
	}
}
