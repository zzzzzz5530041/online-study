package com.online.edu.web.service.mobile;


/**
 * @author
 */
public class SmsThread extends Thread{
    private final SmsServiceStub sendSms;

    public SmsThread(SmsServiceStub sendSms) {
        this.sendSms = sendSms;
    }

    @Override
    public void run() {
        sendSms.sendmsg();
    }
}
