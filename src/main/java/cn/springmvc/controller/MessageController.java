package cn.springmvc.controller;

import cn.springmvc.bean.Message;
import cn.springmvc.service.MessageService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by liumengyun01 on 16/12/21.
 */
@Controller
@EnableWebMvc
@RequestMapping(value = "/msg")
public class MessageController {
    @Resource
    @Qualifier("msgService")
    private MessageService messService;


    @RequestMapping(value="/showMessage",method=RequestMethod.GET)
    public  @ResponseBody
    Message showMess(@RequestParam int id){

        Message message = this.messService.getMessage(id);
        return message;


    }



    @RequestMapping(value = "/showPage", method = {RequestMethod.GET})
    public
    @ResponseBody List<Message> showMess(@RequestParam("page") int page, @RequestParam("pagesize") int pagesize) {

        List<Message> msl = this.messService.getMessagePage(page, pagesize);
        return  msl;

    }




    @RequestMapping("/addMessage")
    public
    @ResponseBody
    Map<String,String> saveMess(@RequestParam("username") String username, @RequestParam("title") String title, @RequestParam("body") String body) {
       Map<String,String> res = new HashMap<String,String>();
        Message message = new Message();
        message.setUsername(username);
        message.setBody(body);
        message.setTitle(title);
        try {

            int id = this.messService.saveMessage(message);
            if (id < 0) {
                res.put("result", "failed");

            } else
                res.put("result", "success");

        } catch (Exception e) {
            res.put("result", "failed");


        }

        return res;


    }





    @RequestMapping(value="/delMessage",method = {RequestMethod.GET})
    @ResponseBody
    public  Map<String,String> delMess(@RequestParam("id") int id) {

          Map<String,String> res = new HashMap<String,String>();
        try {
            boolean flag = this.messService.delMessage(id);
            if (!flag) {
                res.put("result", "failed");
            } else
                res.put("result", "success");

        } catch (Exception e) {

            res.put("result", "failed");
        }

        return res;

    }
    @RequestMapping(value="/modMessage",method = {RequestMethod.POST})
    public
    @ResponseBody
    Map<String,String> modMess(@RequestParam("id") int id,@RequestParam("username") String username, @RequestParam("title") String title, @RequestParam("body") String body) {
        Map<String,String> res = new HashMap<String,String>();
        Message message = new Message();
        message.setUsername(username);
        message.setBody(body);
        message.setTitle(title);
        message.setId(id);
        try {

            boolean flag = this.messService.modMessage(message);
            if (!flag) {
                res.put("result", "failed");

            } else
                res.put("result", "success");

        } catch (Exception e) {
            res.put("result", "failed");


        }

        return res;


    }



    @RequestMapping("/countMessage")
    @ResponseBody
    public Map<String,String> getCountMessage()
    {
         Map<String,String> res = new HashMap<String,String>();

        res.put("count",String.valueOf(this.messService.getMessageCnt()));
        return res;

    }

}
