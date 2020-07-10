package com.goods.entity;

public class Goods {
    private int id;//商品ID
    private int bm;//商品编码
    private String name;//商品名

    public Goods(int id, int bm, String name) {
        this.id = id;
        this.bm = bm;
        this.name = name;
    }

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBm() {
        return bm;
    }

    public void setBm(int bm) {
        this.bm = bm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", bm=" + bm +
                ", name='" + name + '\'' +
                '}';
    }
}
