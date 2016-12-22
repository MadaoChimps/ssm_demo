package cn.springmvc.service.impl;

import cn.springmvc.bean.Message;
import cn.springmvc.dao.MessageDao;
import cn.springmvc.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liumengyun01 on 16/12/20.
 */
@Component("msgService")
public class MessageServiceImpl implements MessageService {
    @Resource
    @Qualifier("mesDao")
    private MessageDao messDao;
    public Message getMessage(int id) {
        return messDao.getMessage(id);
    }

    public boolean delMessage(int id) {
        int flag = messDao.delMessage(id);
        return  flag ==1 ? true : false;
    }

    public int saveMessage(Message message) {
         messDao.saveMessage(message);
         if(message.getId()>0)
             return message.getId();
         else return -1;
    }

    public List<Message> getMessagePage(int page, int pagesize) {
        return messDao.getMessagePage((page-1)*pagesize,pagesize);
    }

    public boolean modMessage(Message message)
    {
        int flag = messDao.modMessage(message);
        return  flag ==1 ? true : false;
    }



    public int getMessageCnt() {
        return messDao.getMessageCount();
    }
}
