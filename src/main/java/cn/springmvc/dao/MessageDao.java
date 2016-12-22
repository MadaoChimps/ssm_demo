package cn.springmvc.dao;

import cn.springmvc.bean.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by liumengyun01 on 16/12/21.
 */
@Component("mesDao")
public interface MessageDao {
    /*private static  HashMap<Integer,Message> messMap = new HashMap<Integer,Message>();
    private int idCnt =0;
    public MessageDao()
     {
         for (; idCnt < 100; idCnt++) {
             {
                 Message temp = new Message();
                 temp.setId(idCnt);
                 temp.setUsername("user-"+idCnt);
                 temp.setTitle("t-"+idCnt);
                 temp.setBody("message-"+idCnt);
                 messMap.put(idCnt,temp);

             }
         }
     }
     public int saveMessage(Message message)
     {

         messMap.put(++idCnt,message);
         return idCnt;
     }

     public boolean delMessage(int id)
     {
         if(messMap.containsKey(id))
         {
             messMap.remove(id);
             return true;
         }else
         {
             return false;
         }

     }
     public Message getMessage(int id){
        if(messMap.containsKey(id))
        {

            return messMap.get(id);
        }else return null;
     }


    public int getMessageCount()
    {
        return messMap.size();
    }
    public List<Message> getMessage(int from,int to)
    {
        List<Message> res = new ArrayList<Message>();
        for (int i = from; i <=to ; i++) {
            if(messMap.containsKey(i))
                res.add(messMap.get(i));

        }
        return res;

    }
*/
    public  int getMessageCount();
    public List<Message> getMessagePage(int from,int to);
    public Message getMessage(int id);
    public int delMessage(int id);
    public int saveMessage(Message message);
    public int modMessage(Message message);
}
