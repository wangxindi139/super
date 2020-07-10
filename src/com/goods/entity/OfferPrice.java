package com.goods.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class OfferPrice {
    private int offerid;//价格ID
    private Date ostart;//价格有效期开始时间
    private Date oend;//价格有效期结束时间
    private int id;//与product关联外键
    private double price;//单价
    private String pricetype;//价格类型

    public OfferPrice(int offerid, Date ostart, Date oend, int id, double price, String pricetype) {
        this.offerid = offerid;
        this.ostart = ostart;
        this.oend = oend;
        this.id = id;
        this.price = price;
        this.pricetype = pricetype;
    }

    public OfferPrice() {
    }

    public int getOfferid() {
        return offerid;
    }

    public void setOfferid(int offerid) {
        this.offerid = offerid;
    }

    public Date getOstart() {
        return ostart;
    }

    public void setOstart(Date ostart) {
        this.ostart = ostart;
    }

    public Date getOend() {
        return oend;
    }

    public void setOend(Date oend) {
        this.oend = oend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    @Override
    public String toString() {
        return "OfferPrice{" +
                "offerid=" + offerid +
                ", ostart=" + ostart +
                ", oend=" + oend +
                ", id=" + id +
                ", price=" + price +
                ", pricetype='" + pricetype + '\'' +
                '}';
    }
}
