package com.dereveskyi.markiyan.sushi_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rolls")
public class Roll extends Food {
    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private String weight;

    public Roll() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
