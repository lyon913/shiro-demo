package com.whr.model;

import java.util.Date;

public class BusReceiptInfo {
    private Integer id;

    private String customerNo;

    private String receiptNo;

    private Date openTime;

    private Long openSum;

    private Long tax;

    private Date sendTime;

    private String waybillNo;

    private String payAccept;

    private String receiptStatus;

    private String comments;

    private String opCreate;

    private String opModify;

    private Date gtmCreate;

    private Date gtmModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Long getOpenSum() {
        return openSum;
    }

    public void setOpenSum(Long openSum) {
        this.openSum = openSum;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    public String getPayAccept() {
        return payAccept;
    }

    public void setPayAccept(String payAccept) {
        this.payAccept = payAccept == null ? null : payAccept.trim();
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus == null ? null : receiptStatus.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getOpCreate() {
        return opCreate;
    }

    public void setOpCreate(String opCreate) {
        this.opCreate = opCreate == null ? null : opCreate.trim();
    }

    public String getOpModify() {
        return opModify;
    }

    public void setOpModify(String opModify) {
        this.opModify = opModify == null ? null : opModify.trim();
    }

    public Date getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(Date gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public Date getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }
}