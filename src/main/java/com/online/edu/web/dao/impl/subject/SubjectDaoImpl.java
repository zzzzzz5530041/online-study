package com.online.edu.web.dao.impl.subject;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.subject.SubjectDao;
import com.online.edu.web.entity.subject.QuerySubject;
import com.online.edu.web.entity.subject.Subject;

/**
 * Subject对象操作实现类
 * @author
 */
@Repository("subjectDao")
public class SubjectDaoImpl extends GenericDaoImpl implements SubjectDao {

	@Override
	public int createSubject(Subject subject) {
		this.insert("SubjectMapper.createSubject", subject);
		return subject.getSubjectId();
	}

	@Override
	public List<Subject> getSubjectList(QuerySubject query) {
		return this.selectList("SubjectMapper.getSubjectList", query);
	}

	@Override
	public void updateSubjectParentId(Map<String, Object> map) {
		this.update("SubjectMapper.updateSubjectParentId", map);
	}

	@Override
	public void updateSubject(Subject subject) {
		this.update("SubjectMapper.updateSubject", subject);
	}
	/**
	 * 修改排序
	 */
	@Override
	public void updateSubjectSort(Subject subject){
		this.update("SubjectMapper.updateSubjectSort", subject);
	}

	@Override
	public void deleteSubject(int subjectId) {
		this.update("SubjectMapper.deleteSubject", subjectId);
	}

	@Override
	public Subject getSubjectBySubject(Subject subject) {
		return this.selectOne("SubjectMapper.getSubjectBySubject", subject);
	}

	@Override
	public List<Subject> getSubjectListByOne(Long subjectId) {
		return this.selectList("SubjectMapper.getSubjectListByOne", subjectId);
	}

}
