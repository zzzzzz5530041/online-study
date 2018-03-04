package com.online.edu.common.service.email;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author zhuyang
 * @version 1.0 2018/3/4
 */
public interface EmailService {
    void sendMail(String mailto, String text, String title) throws Exception;

    void sendBatchMail(String[] mailto, String text, String title);

    void sendMailWithFile(String mailto, String text, String title, String[] filePath) throws Exception;

    void sendBatchMailWithFile(String[] mailto, String text, String title, String[] filePath) throws Exception;


}
