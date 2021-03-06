package com.online.edu.web.service.impl.letter;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.letter.MsgSystemDao;
import com.online.edu.web.entity.letter.MsgSystem;
import com.online.edu.web.service.letter.MsgReceiveService;
import com.online.edu.web.service.letter.MsgSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description 系统消息
 * @author
 */
@Service("msgSystemService")
public class MsgSystemServiceImpl implements MsgSystemService {

    @Autowired
    private MsgSystemDao msgSystemDao;
    @Autowired
    private MsgReceiveService msgReceiveService;

    @Override
    public Long addMsgSystem(MsgSystem msgSystem) throws Exception {
        return msgSystemDao.addMsgSystem(msgSystem);
    }

    /**
     * 查询系统消息
     * @param msgSystem
     * @throws Exception
     */
    @Override
    public List<MsgSystem> queryMsgSystemList(MsgSystem msgSystem, PageEntity page) throws Exception {
        return msgSystemDao.queryMsgSystemList(msgSystem, page);
    }

    /**
     * 通过id删除系统消息
     * @return
     * @throws Exception
     */
    @Override
    public void delMsgSystemById(String ids) throws Exception {
        msgSystemDao.delMsgSystemById(ids);
    }

    /**
     * 查询大于传入的时间的系统系统消息
     * @throws Exception
     */
    @Override
    public List<MsgSystem> queryMSListByLT(Date lastTime) throws Exception {
        return msgSystemDao.queryMSListByLT(lastTime);
    }

    /**
     * 检查系统消息过期更新字段 删除过期的站内信
     * @throws Exception
     */
    @Override
    public void updatePast() throws Exception {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 180);
        Date endDate = dft.parse(dft.format(date.getTime()));
        msgReceiveService.delMsgReceivePast(endDate);
        msgSystemDao.updateMsgSystemPastTime(endDate);

    }

    
}
