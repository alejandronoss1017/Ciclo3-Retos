package com.misiontic.reto3.model.DTO;

import lombok.Getter;
import lombok.Setter;

public class CompletedAndCancelled {
    @Getter
    @Setter
    private Integer completed;

    @Getter
    @Setter
    private Integer cancelled;

    public CompletedAndCancelled(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

}
