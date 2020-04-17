package com.dereveskyi.markiyan.sushi_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sets")
public class Set extends Food{
    @Column(name = "size")
    private String size;

    @Column(name = "ingredients")
    private String ingredients;

    public Set() {
        super();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
