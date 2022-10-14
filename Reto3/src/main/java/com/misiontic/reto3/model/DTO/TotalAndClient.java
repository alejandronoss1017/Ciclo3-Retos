package com.misiontic.reto3.model.DTO;

import com.misiontic.reto3.model.Client;

import lombok.Getter;
import lombok.Setter;

public class TotalAndClient {

    @Getter
    @Setter
    private Integer total;

    
    @Getter
    @Setter
    private Client client;

    public TotalAndClient(Integer integer, Client client2) {
    }
}
