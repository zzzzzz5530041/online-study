package com.online.edu.web.service.email;


import com.online.edu.common.service.email.EmailService;
import com.online.edu.common.util.DateUtils;
import com.online.edu.common.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author http://www.inxedu.com
 */
public class EmailThread implements Runnable{
    //发送邮件service
    private EmailService emailService;
    //发送内容
    private String content;
    //标题
    private String title;
    private int sumNum=0;

    public int getSumNum() {
        return sumNum;
    }

    public void setSumNum(int sumNum) {
        this.sumNum = sumNum;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private  List<String> list = new ArrayList();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public EmailThread(List<String> list, String content, String title, EmailService emailService) {
        this.content = content;
        this.title = title;
        this.list.addAll(list);
        sumNum+=list.size();
        this.emailService = emailService;
    }
    public EmailThread() {
    }

    @Override
    public void run() {
        try {
            //每100个邮箱批量发一次，发完休息1秒，直到发完为止
            if(ObjectUtils.isNotNull(list)){
                while(true){
                    if(list.size()>0){
                        List l = queryList(100);
                        String[] arr = (String[])l.toArray(new String[l.size()]);
                        emailService.sendBatchMail(arr, content, title);
                        Thread.sleep(1000);
                    }else{
                        sumNum =0;
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获得要发送的list加锁
    public synchronized List queryList(int num){
        List newList = new ArrayList();
        if(ObjectUtils.isNotNull(list)){
            if(list.size()<=num){
                System.out.println("发送完成时间"+ DateUtils.getNowTime());
                for(int i=0;i<list.size();i++){
                    newList.add(list.get(i));
                }
                list = new ArrayList();
                return newList;
            }else{
                for(int i=0;i<num;i++){
                    newList.add(list.get(i));
                }
                for(int i=0;i<num;i++){
                    list.remove(0);
                }

            }
        }
        return newList;
    }

}
