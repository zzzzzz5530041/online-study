package com.online.edu.web.dao.impl.user;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.user.UserDao;
import com.online.edu.web.entity.user.QueryUser;
import com.online.edu.web.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 *
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl implements UserDao{

	@Override
	public int createUser(User user) {
		this.insert("UserMapper.createUser", user);
		return user.getUserId();
	}

	@Override
	public User queryUserById(int userId) {
		return this.selectOne("UserMapper.queryUserById", userId);
	}

	@Override
	public int checkMobile(String mobile) {
		return this.selectOne("UserMapper.checkMobile", mobile);
	}

	@Override
	public int checkEmail(String email) {
		return this.selectOne("UserMapper.checkEmail", email);
	}

	@Override
	public User getLoginUser(Map<String, Object> map) {
		return this.selectOne("UserMapper.getLoginUser", map);
	}

	@Override
	public void updateUserPwd(User user) {
		this.update("UserMapper.updateUserPwd", user);
	}

	@Override
	public List<User> queryUserListPage(QueryUser query, PageEntity page) {
		return this.queryForListPage("UserMapper.queryUserListPage", query, page);
	}

	@Override
	public void updateUserStates(User user) {
		this.update("UserMapper.updateUserStates", user);
	}

	@Override
	public void updateUser(User user) {
		this.update("UserMapper.updateUser", user);
	}

	@Override
	public void updateImg(User user) {
		this.update("UserMapper.updateImg", user);
	}

	@Override
	public int queryAllUserCount() {
		return this.selectOne("UserMapper.queryAllUserCount", null);
	}

	@Override
	public User queryUserByEmailOrMobile(String emailOrMobile) {
		return this.selectOne("UserMapper.queryUserByEmailOrMobile", emailOrMobile);
	}


	@Override
	public List<User> queryUsersByIds(List<Long> cusIds) throws Exception {
		 return this.selectList("UserMapper.queryCustomerInCusIds", cusIds);
	}
	
	/**
     * 通过标识更新未读数加一
     * 
     */
	@Override
    public void updateUnReadMsgNumAddOne(String falg,Long cusId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("falg", falg);
        map.put("cusId", cusId);
        this.update("UserMapper.updateUnReadMsgNumAddOne", map);
    }
    
    /**
     * 通过标识更新未读数清零
     * 
     */
	@Override
    public void updateUnReadMsgNumReset(String falg,Long cusId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("falg", falg);
        map.put("cusId", cusId);
        this.update("UserMapper.updateUnReadMsgNumReset", map);
    }


	@Override
	public void updateCusForLST(Long cusId, Date date) {
		Map<String,Object> map = new HashMap<String,Object>();
        map.put("cusId", cusId);
        map.put("date", date);
        this.update("UserMapper.updateCusForLST", map);
	}

	@Override
	public List<User> getUserListPage(User user, PageEntity page) {
		return this.queryForListPage("UserMapper.getUserListPage", user, page);
	}
	
}
