package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_receipt_info")
public class BusReceiptInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "receipt_no")
    private String receiptNo;

    @Column(name = "open_time")
    private Date openTime;

    @Column(name = "open_sum")
    private Long openSum;

    private Long tax;

    @Column(name = "send_time")
    private Date sendTime;

    @Column(name = "waybill_no")
    private String waybillNo;

    @Column(name = "pay_accept")
    private String payAccept;

    @Column(name = "receipt_status")
    private String receiptStatus;

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
     * @return customer_no
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    /**
     * @return receipt_no
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * @param receiptNo
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    /**
     * @return open_time
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * @param openTime
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * @return open_sum
     */
    public Long getOpenSum() {
        return openSum;
    }

    /**
     * @param openSum
     */
    public void setOpenSum(Long openSum) {
        this.openSum = openSum;
    }

    /**
     * @return tax
     */
    public Long getTax() {
        return tax;
    }

    /**
     * @param tax
     */
    public void setTax(Long tax) {
        this.tax = tax;
    }

    /**
     * @return send_time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return waybill_no
     */
    public String getWaybillNo() {
        return waybillNo;
    }

    /**
     * @param waybillNo
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    /**
     * @return pay_accept
     */
    public String getPayAccept() {
        return payAccept;
    }

    /**
     * @param payAccept
     */
    public void setPayAccept(String payAccept) {
        this.payAccept = payAccept == null ? null : payAccept.trim();
    }

    /**
     * @return receipt_status
     */
    public String getReceiptStatus() {
        return receiptStatus;
    }

    /**
     * @param receiptStatus
     */
    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus == null ? null : receiptStatus.trim();
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