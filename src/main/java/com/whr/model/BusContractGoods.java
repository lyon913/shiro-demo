package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_contract_goods")
public class BusContractGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_std")
    private String goodsStd;

    @Column(name = "goods_num")
    private Integer goodsNum;

    @Column(name = "sum_price")
    private Long sumPrice;

    @Column(name = "unit_price")
    private Long unitPrice;

    @Column(name = "goods_type")
    private String goodsType;

    private String comments;

    @Column(name = "op_create")
    private String opCreate;

    @Column(name = "op_modify")
    private String opModify;

    @Column(name = "gtm_create")
    private Date gtmCreate;

    @Column(name = "gtm_modify")
    private Date gtmModify;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return contract_no
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * @param contractNo
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return goods_std
     */
    public String getGoodsStd() {
        return goodsStd;
    }

    /**
     * @param goodsStd
     */
    public void setGoodsStd(String goodsStd) {
        this.goodsStd = goodsStd == null ? null : goodsStd.trim();
    }

    /**
     * @return goods_num
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * @param goodsNum
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * @return sum_price
     */
    public Long getSumPrice() {
        return sumPrice;
    }

    /**
     * @param sumPrice
     */
    public void setSumPrice(Long sumPrice) {
        this.sumPrice = sumPrice;
    }

    /**
     * @return unit_price
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice
     */
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return goods_type
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * @param goodsType
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    /**
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * @return op_create
     */
    public String getOpCreate() {
        return opCreate;
    }

    /**
     * @param opCreate
     */
    public void setOpCreate(String opCreate) {
        this.opCreate = opCreate == null ? null : opCreate.trim();
    }

    /**
     * @return op_modify
     */
    public String getOpModify() {
        return opModify;
    }

    /**
     * @param opModify
     */
    public void setOpModify(String opModify) {
        this.opModify = opModify == null ? null : opModify.trim();
    }

    /**
     * @return gtm_create
     */
    public Date getGtmCreate() {
        return gtmCreate;
    }

    /**
     * @param gtmCreate
     */
    public void setGtmCreate(Date gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    /**
     * @return gtm_modify
     */
    public Date getGtmModify() {
        return gtmModify;
    }

    /**
     * @param gtmModify
     */
    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }
}