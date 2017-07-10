package com.whr.model;

import javax.persistence.*;

@Table(name = "bus_customer_info")
public class BusCustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "customer_level")
    private String customerLevel;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "fax_no")
    private String faxNo;

    @Column(name = "link_man")
    private String linkMan;

    @Column(name = "link_mobile")
    private String linkMobile;

    @Column(name = "link_address")
    private String linkAddress;

    @Column(name = "receipt_address")
    private String receiptAddress;

    @Column(name = "tax_no")
    private String taxNo;

    @Column(name = "receipt_mobile")
    private String receiptMobile;

    @Column(name = "open_bank")
    private String openBank;

    @Column(name = "account_no")
    private String accountNo;

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
     * @return customer_level
     */
    public String getCustomerLevel() {
        return customerLevel;
    }

    /**
     * @param customerLevel
     */
    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    /**
     * @return customer_name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * @return delivery_address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * @param deliveryAddress
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    /**
     * @return mobile_no
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * @return fax_no
     */
    public String getFaxNo() {
        return faxNo;
    }

    /**
     * @param faxNo
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo == null ? null : faxNo.trim();
    }

    /**
     * @return link_man
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * @param linkMan
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * @return link_mobile
     */
    public String getLinkMobile() {
        return linkMobile;
    }

    /**
     * @param linkMobile
     */
    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile == null ? null : linkMobile.trim();
    }

    /**
     * @return link_address
     */
    public String getLinkAddress() {
        return linkAddress;
    }

    /**
     * @param linkAddress
     */
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    /**
     * @return receipt_address
     */
    public String getReceiptAddress() {
        return receiptAddress;
    }

    /**
     * @param receiptAddress
     */
    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress == null ? null : receiptAddress.trim();
    }

    /**
     * @return tax_no
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * @param taxNo
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    /**
     * @return receipt_mobile
     */
    public String getReceiptMobile() {
        return receiptMobile;
    }

    /**
     * @param receiptMobile
     */
    public void setReceiptMobile(String receiptMobile) {
        this.receiptMobile = receiptMobile == null ? null : receiptMobile.trim();
    }

    /**
     * @return open_bank
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * @param openBank
     */
    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    /**
     * @return account_no
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }
}