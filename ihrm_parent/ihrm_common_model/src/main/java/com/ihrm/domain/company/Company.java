package com.ihrm.domain.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 公司信息实体类
 *
 * 实体类和数据库表的映射
 *      1、主键属性的映射
 *      2、普通属性的映射
 *
 */
@Entity
@Table(name = "co_company")
@AllArgsConstructor     //自动创建满参构造方法
@NoArgsConstructor  //无参构造方法
public class Company implements Serializable {

    private static final long serialVersionUID = 594829320797158219L;

    /**
     * 主键映射
     */
    @Id
    private String id;

    @Column(name = "name")
    private String name;    //公司名称

    @Column(name = "manager_id")
    private String managerId;   //企业登录账户ID

    @Column(name = "version")
    private String version;     //当前版本

    @Column(name = "renewal_date")
    private Date renewalDate;   //续期时间

    @Column(name = "expiration_date")
    private Date expirationDate;    //到期时间

    @Column(name = "company_area")
    private String companyArea;     //公司地区

    @Column(name = "company_address")
    private String companyAddress;  //公司地址

    @Column(name = "business_license_id")
    private String businessLicenseId;   //营业执照

    @Column(name = "legal_representative")
    private String legalRepresentative; //法人代表

    @Column(name = "company_phone")
    private String companyPhone;    //公司电话

    @Column(name = "mailbox")
    private String mailbox;     //邮箱

    @Column(name = "company_size")
    private String companySize; //公司规模

    @Column(name = "industry")
    private String industry;    //所属行业

    @Column(name = "remarks")
    private String remarks;     //备注

    @Column(name = "audit_state")
    private String auditState;  //审核状态

    @Column(name = "state")
    private Integer state;      //状态

    @Column(name = "balance")
    private Double balance;     //当前余额

    @Column(name = "create_time")
    private Date createTime;       //创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(String businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
