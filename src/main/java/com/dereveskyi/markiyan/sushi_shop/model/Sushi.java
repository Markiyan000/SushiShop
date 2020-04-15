package com.dereveskyi.markiyan.sushi_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "sushi")
public class Sushi extends Food{

    @Column(name = "type")
    private String type;

    public Sushi() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
