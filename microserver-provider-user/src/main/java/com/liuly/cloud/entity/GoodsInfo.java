package com.liuly.cloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Description: li.liu02@hand-china.com<br/>
 * date: 2018/9/4 8:52<br/>
 *
 * @author Liuly<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class GoodsInfo implements Serializable {

    private String crgoCpCd;

    private Integer lot;

    private BigDecimal frght;

    private String crgoType;

    private Date shipdateBgnTm;

    private Date shipdateEndTm;

    private String vslownChrtr;

    private String lpRange;

    private String dpRange;

    private String crgoArrngNoteId;

    private String id;

    private String cpType;

    private BigDecimal sumQlty;

    private Integer countSum;

    private String shippingPrice;

    private String cpCode;

    private String typeCode;

    private BigDecimal qltyFrom;

    private  BigDecimal qltyTo;

    private String crgoTypeName;

    private String prtyEnName;

    /**
     * 货物的来源，已控还是市场
     *
     ***/
    private String crgoFrom;

    public String getPrtyEnName() {
        return prtyEnName;
    }

    public void setPrtyEnName(String prtyEnName) {
        this.prtyEnName = prtyEnName;
    }

    public String getCrgoFrom() {
        return crgoFrom;
    }

    public void setCrgoFrom(String crgoFrom) {
        this.crgoFrom = crgoFrom;
    }

    public BigDecimal getQltyFrom() {
        return qltyFrom;
    }

    public void setQltyFrom(BigDecimal qltyFrom) {
        this.qltyFrom = qltyFrom;
    }

    public BigDecimal getQltyTo() {
        return qltyTo;
    }

    public void setQltyTo(BigDecimal qltyTo) {
        this.qltyTo = qltyTo;
    }

    public String getCrgoTypeName() {
        return crgoTypeName;
    }

    public void setCrgoTypeName(String crgoTypeName) {
        this.crgoTypeName = crgoTypeName;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "crgoCpCd='" + crgoCpCd + '\'' +
                ", lot=" + lot +
                ", frght=" + frght +
                ", crgoType='" + crgoType + '\'' +
                ", shipdateBgnTm=" + shipdateBgnTm +
                ", shipdateEndTm=" + shipdateEndTm +
                ", vslownChrtr='" + vslownChrtr + '\'' +
                ", lpRange='" + lpRange + '\'' +
                ", dpRange='" + dpRange + '\'' +
                ", crgoArrngNoteId='" + crgoArrngNoteId + '\'' +
                ", id='" + id + '\'' +
                ", cpType='" + cpType + '\'' +
                ", sumQlty=" + sumQlty +
                ", countSum=" + countSum +
                ", shippingPrice='" + shippingPrice + '\'' +
                ", cpCode='" + cpCode + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", crgoTypeName='" +crgoTypeName+'\''+
                ", prtyEnName='" +prtyEnName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final GoodsInfo data = (GoodsInfo) obj;
        if (this.getCrgoCpCd().equalsIgnoreCase(data.getCrgoCpCd())
                && data.getLot().equals(this.getLot()))
            return true;
        return false;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(String shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public BigDecimal getSumQlty() {
        return sumQlty;
    }

    public void setSumQlty(BigDecimal sumQlty) {
        this.sumQlty = sumQlty;
    }

    public Integer getCountSum() {
        return countSum;
    }

    public void setCountSum(Integer countSum) {
        this.countSum = countSum;
    }

    public String getCpType() {
        return cpType;
    }

    public void setCpType(String cpType) {
        this.cpType = cpType;
    }

    public String getCrgoArrngNoteId() {
        return crgoArrngNoteId;
    }

    public void setCrgoArrngNoteId(String crgoArrngNoteId) {
        this.crgoArrngNoteId = crgoArrngNoteId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCrgoCpCd() {
        return crgoCpCd;
    }

    public void setCrgoCpCd(String crgoCpCd) {
        this.crgoCpCd = crgoCpCd;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public BigDecimal getFrght() {
        return frght;
    }

    public void setFrght(BigDecimal frght) {
        this.frght = frght;
    }

    public String getCrgoType() {
        return crgoType;
    }

    public void setCrgoType(String crgoType) {
        this.crgoType = crgoType;
    }

    public Date getShipdateBgnTm() {
        return shipdateBgnTm;
    }

    public void setShipdateBgnTm(Date shipdateBgnTm) {
        this.shipdateBgnTm = shipdateBgnTm;
    }

    public Date getShipdateEndTm() {
        return shipdateEndTm;
    }

    public void setShipdateEndTm(Date shipdateEndTm) {
        this.shipdateEndTm = shipdateEndTm;
    }

    public String getVslownChrtr() {
        return vslownChrtr;
    }

    public void setVslownChrtr(String vslownChrtr) {
        this.vslownChrtr = vslownChrtr;
    }

    public String getLpRange() {
        return lpRange;
    }

    public void setLpRange(String lpRange) {
        this.lpRange = lpRange;
    }

    public String getDpRange() {
        return dpRange;
    }

    public void setDpRange(String dpRange) {
        this.dpRange = dpRange;
    }
}
