package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_contract_pay")
public class BusContractPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "pay_money")
    private Long payMoney;

    @Column(name = "pay_accept")
    private String payAccept;

    @Column(name = "pay_mode")
    private String payMode;

    @Column(name = "pay_account")
    private String payAccount;

    @Column(name = "pay_status")
    private String payStatus;

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
     * @return pay_money
     */
    public Long getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
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
     * @return pay_mode
     */
    public String getPayMode() {
        return payMode;
    }

    /**
     * @param payMode
     */
    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    /**
     * @return pay_account
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * @param payAccount
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    /**
     * @return pay_status
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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