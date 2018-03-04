package com.online.edu.web.dao.impl.email;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.email.UserEmailMsgDao;
import com.online.edu.web.entity.email.UserEmailMsg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author http://www.inxedu.com
 */
@Repository("userEmailDao")
public class UserEmailMsgDaoImpl extends GenericDaoImpl implements UserEmailMsgDao {
	/**
     * 查询记录
     * 
     * @param userEmailMsg
     * @param page
     * @return
     */
    @Override
    public List<UserEmailMsg> queryUserEmailMsgList(UserEmailMsg userEmailMsg, PageEntity page) {
        return this.queryForListPage("UserEmailMsgMapper.queryUserEmailMsgList", userEmailMsg, page);
    }
    
    /**
     * 获得单个记录
     */
    @Override
    public UserEmailMsg queryUserEmailMsgById(Long id) {
        return this.selectOne("UserEmailMsgMapper.queryUserEmailMsgById", id);
    }
    
    /**
     * 添加发送用户邮箱记录
     */
    @Override
    public Long addUserEmailMsg(List<UserEmailMsg> userEmailMsgList) {
        return this.insert("UserEmailMsgMapper.addUserEmailMsg", userEmailMsgList);
    }
    
    /**
     * 更新 UserEmailMsg
     */
    @Override
    public void updateUserEmailMsgById(UserEmailMsg userEmailMsg){
        this.update("UserEmailMsgMapper.updateUserEmailMsgById",userEmailMsg);
    }
    
    /**
     * 删除发送邮件记录
     */
    @Override
    public void delUserEmailMsgById(Long id){
        this.delete("UserEmailMsgMapper.delUserEmailMsgById",id);
    }
    
    /**
     * 按条件查询邮箱记录
     */
    @Override
    public List<UserEmailMsg> queryUserEmailList(UserEmailMsg userEmailMsg){
        return this.selectList("UserEmailMsgMapper.queryUserEmailList", userEmailMsg);
    }
    
    /**
     * 更新邮件为已发送
     */
    @Override
    public void updateUserEmailStatus(UserEmailMsg userEmailMsg){
        this.update("UserEmailMsgMapper.updateUserEmailStatus",userEmailMsg);
    }
}
