package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_contract_info")
public class BusContractInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String buyer;

    private String seller;

    @Column(name = "contract_date")
    private Date contractDate;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "customer_no")
    private String customerNo;

    private Long total;

    private Long favour;

    private String standard;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "delivery_place")
    private String deliveryPlace;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "pay_condition")
    private String payCondition;

    @Column(name = "contract_status")
    private String contractStatus;

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
     * @return buyer
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * @param buyer
     */
    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    /**
     * @return seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * @param seller
     */
    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    /**
     * @return contract_date
     */
    public Date getContractDate() {
        return contractDate;
    }

    /**
     * @param contractDate
     */
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
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
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * @return favour
     */
    public Long getFavour() {
        return favour;
    }

    /**
     * @param favour
     */
    public void setFavour(Long favour) {
        this.favour = favour;
    }

    /**
     * @return standard
     */
    public String getStandard() {
        return standard;
    }

    /**
     * @param standard
     */
    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    /**
     * @return delivery_date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return delivery_place
     */
    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    /**
     * @param deliveryPlace
     */
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace == null ? null : deliveryPlace.trim();
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
     * @return pay_condition
     */
    public String getPayCondition() {
        return payCondition;
    }

    /**
     * @param payCondition
     */
    public void setPayCondition(String payCondition) {
        this.payCondition = payCondition == null ? null : payCondition.trim();
    }

    /**
     * @return contract_status
     */
    public String getContractStatus() {
        return contractStatus;
    }

    /**
     * @param contractStatus
     */
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
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