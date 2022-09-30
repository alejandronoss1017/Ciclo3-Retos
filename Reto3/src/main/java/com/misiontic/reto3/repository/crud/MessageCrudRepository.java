package com.misiontic.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.misiontic.reto3.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
