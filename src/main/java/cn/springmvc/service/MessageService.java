package cn.springmvc.service;

import cn.springmvc.bean.Message;

import java.util.List;

/**
 * Created by liumengyun01 on 16/12/20.
 */
public interface MessageService {
    public  Message getMessage(int id);
    public boolean delMessage(int id);

    public int saveMessage(Message message);

    public int getMessageCnt();
    public List<Message> getMessagePage(int page,int pagesize);
    public boolean modMessage(Message message);
}
