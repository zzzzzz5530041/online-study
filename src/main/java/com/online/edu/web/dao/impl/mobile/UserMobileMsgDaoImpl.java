package com.online.edu.web.dao.impl.mobile;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.mobile.UserMobileMsgDao;
import com.online.edu.web.entity.mobile.UserMobileMsg;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 *@author www.inxedu.com
 */
@Repository("userMobileDao")
public class UserMobileMsgDaoImpl extends GenericDaoImpl implements UserMobileMsgDao {
	/**
     * 短信记录列表
     * 
     * @param userMobileMsg
     * @param page
     * @return
     */
    @Override
    public List<UserMobileMsg> queryUserMobileMsgList(UserMobileMsg userMobileMsg, PageEntity page) {
        return this.queryForListPage("UserMobileMsgMapper.queryUserMobileMsgList", userMobileMsg, page);
    }
    
    /**
     * 获得单个记录
     * 
     * @param id
     * @return
     */
    @Override
    public UserMobileMsg queryUserMobileMsgById(Long id) {
        return this.selectOne("UserMobileMsgMapper.queryUserMobileMsgById", id);
    }
    
    /**
     * 删除短信
     */
    @Override
    public void delUserMobileMsg(Long id){
    	this.delete("UserMobileMsgMapper.delUserMobileMsg", id);
    }
    
    /**
     * 修改短信
     * @param userMobileMsg
     */
    @Override
    public void updateUserMobileMsg(UserMobileMsg userMobileMsg) {
		this.update("UserMobileMsgMapper.updateUserMobileMsg", userMobileMsg);
	}
    
    /**
     * 添加发送用户短信记录
     * @return
     */
    @Override
    public Long addUserMobileMsg(List<UserMobileMsg> userMobileMsgList) {
        return this.insert("UserMobileMsgMapper.addUserMobileMsg", userMobileMsgList);
    }
    
    /**
     * 查询和当前时间相等的短信记录 发送
     * @return
     */
    @Override
    public List<UserMobileMsg> queryNowMobileMsgList(Date nowDate){
    	return this.selectList("UserMobileMsgMapper.queryNowMobileMsgList", nowDate);
    }
    
    /**
     * 修改短信发送状态
     */
    @Override
    public void updateMsgStatus(Long id){
    	this.update("UserMobileMsgMapper.updateMsgStatus", id);
    }
}
