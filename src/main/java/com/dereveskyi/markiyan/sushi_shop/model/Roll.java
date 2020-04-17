package com.dereveskyi.markiyan.sushi_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rolls")
public class Roll extends Food {
    @Column(name = "type")
    private String type;

    public Roll() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
