package com.whr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_staff_info")
public class BusStaffInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "staff_no")
    private String staffNo;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_position")
    private String staffPosition;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "leave_date")
    private Date leaveDate;

    @Column(name = "staff_type")
    private String staffType;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "bank_acc")
    private String bankAcc;

    @Column(name = "ss_flag")
    private String ssFlag;

    @Column(name = "tel_no")
    private String telNo;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "fax_no")
    private String faxNo;

    private String email;

    @Column(name = "staff_status")
    private String staffStatus;

    private String comments;

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
     * @return staff_no
     */
    public String getStaffNo() {
        return staffNo;
    }

    /**
     * @param staffNo
     */
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    /**
     * @return short_name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * @return staff_name
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * @return staff_position
     */
    public String getStaffPosition() {
        return staffPosition;
    }

    /**
     * @param staffPosition
     */
    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition == null ? null : staffPosition.trim();
    }

    /**
     * @return entry_date
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return leave_date
     */
    public Date getLeaveDate() {
        return leaveDate;
    }

    /**
     * @param leaveDate
     */
    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    /**
     * @return staff_type
     */
    public String getStaffType() {
        return staffType;
    }

    /**
     * @param staffType
     */
    public void setStaffType(String staffType) {
        this.staffType = staffType == null ? null : staffType.trim();
    }

    /**
     * @return card_no
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * @return bank_acc
     */
    public String getBankAcc() {
        return bankAcc;
    }

    /**
     * @param bankAcc
     */
    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc == null ? null : bankAcc.trim();
    }

    /**
     * @return ss_flag
     */
    public String getSsFlag() {
        return ssFlag;
    }

    /**
     * @param ssFlag
     */
    public void setSsFlag(String ssFlag) {
        this.ssFlag = ssFlag == null ? null : ssFlag.trim();
    }

    /**
     * @return tel_no
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return staff_status
     */
    public String getStaffStatus() {
        return staffStatus;
    }

    /**
     * @param staffStatus
     */
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus == null ? null : staffStatus.trim();
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
}