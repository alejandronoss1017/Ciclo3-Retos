package com.usa.proyectoa.poyectoa.service;


import com.usa.proyectoa.poyectoa.entities.Message;
import com.usa.proyectoa.poyectoa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getId()==null){
            return messageRepository.save(m);
        }else {
            Optional<Message> e= messageRepository.getMessage(m.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return messageRepository.save(m);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Message> a = messageRepository.getMessage(id);
        if(a.isPresent()){
            messageRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }

}