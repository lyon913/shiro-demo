package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_contract_goods_file")
public class BusContractGoodsFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "file_type")
    private String fileType;

    private String comments;

    @Column(name = "op_create")
    private String opCreate;

    @Column(name = "op_modify")
    private String opModify;

    @Column(name = "gtm_create")
    private Date gtmCreate;

    @Column(name = "gtm_modify")
    private Date gtmModify;

    @Column(name = "goods_file")
    private byte[] goodsFile;

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
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return file_type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
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

    /**
     * @return goods_file
     */
    public byte[] getGoodsFile() {
        return goodsFile;
    }

    /**
     * @param goodsFile
     */
    public void setGoodsFile(byte[] goodsFile) {
        this.goodsFile = goodsFile;
    }
}