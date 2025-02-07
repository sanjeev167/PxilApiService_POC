/*
 * Created on 2024-01-08 ( 16:41:33 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.pxil.sec.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.pxil.pvt.entities.ApiScheduleWithLoss;

/**
 * JPA entity class for "PxGridNodeMstr"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="px_grid_node_mstr")
public class PxGridNodeMstr implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="gnm_grid_node_code", nullable=false, length=30)
    private String     gnmGridNodeCode;

    //--- ENTITY DATA FIELDS 
    @Column(name="gnm_node_desc", length=100)
    private String     gnmNodeDesc ;

    @Column(name="gnm_node_level")
    private BigDecimal gnmNodeLevel ;

    @Column(name="gnm_operating_entity", length=25)
    private String     gnmOperatingEntity ;

    @Column(name="gnm_phone_no", length=15)
    private String     gnmPhoneNo ;

    @Column(name="gnm_email_id", length=200)
    private String     gnmEmailId ;

    @Column(name="gnm_address1", length=100)
    private String     gnmAddress1 ;

    @Column(name="gnm_address2", length=100)
    private String     gnmAddress2 ;

    @Column(name="gnm_address3", length=100)
    private String     gnmAddress3 ;

    @Column(name="gnm_fax_no", length=15)
    private String     gnmFaxNo ;

    @Column(name="gnm_contact_person1", length=25)
    private String     gnmContactPerson1 ;

    @Column(name="gnm_contact_person2", length=25)
    private String     gnmContactPerson2 ;

    @Column(name="gnm_parent", length=30)
    private String     gnmParent ;

    @Column(name="gnm_grid_node_type", length=25)
    private String     gnmGridNodeType ;

    @Column(name="gnm_created_by", length=15)
    private String     gnmCreatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="gnm_created_dt")
    private Date       gnmCreatedDt ;

    @Column(name="gnm_modified_by", length=15)
    private String     gnmModifiedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="gnm_modified_dt")
    private Date       gnmModifiedDt ;

    @Column(name="gnm_is_active", length=1)
    private String     gnmIsActive ;

    @Column(name="gnm_loss_applicability", length=1)
    private String     gnmLossApplicability ;

    @Column(name="gnm_grid_node_id")
    private BigDecimal gnmGridNodeId ;

    @Column(name="gnm_charge_applicability", length=1)
    private String     gnmChargeApplicability ;

    @Column(name="gnm_qty_applied", length=25)
    private String     gnmQtyApplied ;

    @Column(name="gnm_applied_on_unittype", length=250)
    private String     gnmAppliedOnUnittype ;

    @Column(name="gnm_acc_code", length=50)
    private String     gnmAccCode ;

    @Column(name="gnm_grid_state_code")
    private BigDecimal gnmGridStateCode ;

    @Column(name="gnm_bid_area", length=30)
    private String     gnmBidArea ;

    @Column(name="old_grid_node_code", length=30)
    private String     oldGridNodeCode ;

    @Column(name="gnm_rldc_registration_code", length=20)
    private String     gnmRldcRegistrationCode ;

   

    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="pxGridNodeMstr")
    private List<ApiUser> listOfApiUser ; 

    @OneToMany(mappedBy="pxGridNodeMstr")
    private List<ApiScheduleWithLoss> listOfApiScheduleWithLoss ; 


    /**
     * Constructor
     */
    public PxGridNodeMstr() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setGnmGridNodeCode( String gnmGridNodeCode ) {
        this.gnmGridNodeCode = gnmGridNodeCode ;
    }
    public String getGnmGridNodeCode() {
        return this.gnmGridNodeCode;
    }

    public void setGnmNodeDesc( String gnmNodeDesc ) {
        this.gnmNodeDesc = gnmNodeDesc ;
    }
    public String getGnmNodeDesc() {
        return this.gnmNodeDesc;
    }

    public void setGnmNodeLevel( BigDecimal gnmNodeLevel ) {
        this.gnmNodeLevel = gnmNodeLevel ;
    }
    public BigDecimal getGnmNodeLevel() {
        return this.gnmNodeLevel;
    }

    public void setGnmOperatingEntity( String gnmOperatingEntity ) {
        this.gnmOperatingEntity = gnmOperatingEntity ;
    }
    public String getGnmOperatingEntity() {
        return this.gnmOperatingEntity;
    }

    public void setGnmPhoneNo( String gnmPhoneNo ) {
        this.gnmPhoneNo = gnmPhoneNo ;
    }
    public String getGnmPhoneNo() {
        return this.gnmPhoneNo;
    }

    public void setGnmEmailId( String gnmEmailId ) {
        this.gnmEmailId = gnmEmailId ;
    }
    public String getGnmEmailId() {
        return this.gnmEmailId;
    }

    public void setGnmAddress1( String gnmAddress1 ) {
        this.gnmAddress1 = gnmAddress1 ;
    }
    public String getGnmAddress1() {
        return this.gnmAddress1;
    }

    public void setGnmAddress2( String gnmAddress2 ) {
        this.gnmAddress2 = gnmAddress2 ;
    }
    public String getGnmAddress2() {
        return this.gnmAddress2;
    }

    public void setGnmAddress3( String gnmAddress3 ) {
        this.gnmAddress3 = gnmAddress3 ;
    }
    public String getGnmAddress3() {
        return this.gnmAddress3;
    }

    public void setGnmFaxNo( String gnmFaxNo ) {
        this.gnmFaxNo = gnmFaxNo ;
    }
    public String getGnmFaxNo() {
        return this.gnmFaxNo;
    }

    public void setGnmContactPerson1( String gnmContactPerson1 ) {
        this.gnmContactPerson1 = gnmContactPerson1 ;
    }
    public String getGnmContactPerson1() {
        return this.gnmContactPerson1;
    }

    public void setGnmContactPerson2( String gnmContactPerson2 ) {
        this.gnmContactPerson2 = gnmContactPerson2 ;
    }
    public String getGnmContactPerson2() {
        return this.gnmContactPerson2;
    }

    public void setGnmParent( String gnmParent ) {
        this.gnmParent = gnmParent ;
    }
    public String getGnmParent() {
        return this.gnmParent;
    }

    public void setGnmGridNodeType( String gnmGridNodeType ) {
        this.gnmGridNodeType = gnmGridNodeType ;
    }
    public String getGnmGridNodeType() {
        return this.gnmGridNodeType;
    }

    public void setGnmCreatedBy( String gnmCreatedBy ) {
        this.gnmCreatedBy = gnmCreatedBy ;
    }
    public String getGnmCreatedBy() {
        return this.gnmCreatedBy;
    }

    public void setGnmCreatedDt( Date gnmCreatedDt ) {
        this.gnmCreatedDt = gnmCreatedDt ;
    }
    public Date getGnmCreatedDt() {
        return this.gnmCreatedDt;
    }

    public void setGnmModifiedBy( String gnmModifiedBy ) {
        this.gnmModifiedBy = gnmModifiedBy ;
    }
    public String getGnmModifiedBy() {
        return this.gnmModifiedBy;
    }

    public void setGnmModifiedDt( Date gnmModifiedDt ) {
        this.gnmModifiedDt = gnmModifiedDt ;
    }
    public Date getGnmModifiedDt() {
        return this.gnmModifiedDt;
    }

    public void setGnmIsActive( String gnmIsActive ) {
        this.gnmIsActive = gnmIsActive ;
    }
    public String getGnmIsActive() {
        return this.gnmIsActive;
    }

    public void setGnmLossApplicability( String gnmLossApplicability ) {
        this.gnmLossApplicability = gnmLossApplicability ;
    }
    public String getGnmLossApplicability() {
        return this.gnmLossApplicability;
    }

    public void setGnmGridNodeId( BigDecimal gnmGridNodeId ) {
        this.gnmGridNodeId = gnmGridNodeId ;
    }
    public BigDecimal getGnmGridNodeId() {
        return this.gnmGridNodeId;
    }

    public void setGnmChargeApplicability( String gnmChargeApplicability ) {
        this.gnmChargeApplicability = gnmChargeApplicability ;
    }
    public String getGnmChargeApplicability() {
        return this.gnmChargeApplicability;
    }

    public void setGnmQtyApplied( String gnmQtyApplied ) {
        this.gnmQtyApplied = gnmQtyApplied ;
    }
    public String getGnmQtyApplied() {
        return this.gnmQtyApplied;
    }

    public void setGnmAppliedOnUnittype( String gnmAppliedOnUnittype ) {
        this.gnmAppliedOnUnittype = gnmAppliedOnUnittype ;
    }
    public String getGnmAppliedOnUnittype() {
        return this.gnmAppliedOnUnittype;
    }

    public void setGnmAccCode( String gnmAccCode ) {
        this.gnmAccCode = gnmAccCode ;
    }
    public String getGnmAccCode() {
        return this.gnmAccCode;
    }

    public void setGnmGridStateCode( BigDecimal gnmGridStateCode ) {
        this.gnmGridStateCode = gnmGridStateCode ;
    }
    public BigDecimal getGnmGridStateCode() {
        return this.gnmGridStateCode;
    }

    public void setGnmBidArea( String gnmBidArea ) {
        this.gnmBidArea = gnmBidArea ;
    }
    public String getGnmBidArea() {
        return this.gnmBidArea;
    }

    public void setOldGridNodeCode( String oldGridNodeCode ) {
        this.oldGridNodeCode = oldGridNodeCode ;
    }
    public String getOldGridNodeCode() {
        return this.oldGridNodeCode;
    }
/*
    public void setGnmBidAreaOld( String gnmBidAreaOld ) {
        this.gnmBidAreaOld = gnmBidAreaOld ;
    }
    public String getGnmBidAreaOld() {
        return this.gnmBidAreaOld;
    }
*/
    public void setGnmRldcRegistrationCode( String gnmRldcRegistrationCode ) {
        this.gnmRldcRegistrationCode = gnmRldcRegistrationCode ;
    }
    public String getGnmRldcRegistrationCode() {
        return this.gnmRldcRegistrationCode;
    }

    

    //--- GETTERS FOR LINKS
    public List<ApiUser> getListOfApiUser() {
        return this.listOfApiUser;
    } 

    public List<ApiScheduleWithLoss> getListOfApiScheduleWithLoss() {
        return this.listOfApiScheduleWithLoss;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(gnmGridNodeCode);
        sb.append("|");
        sb.append(gnmNodeDesc);
        sb.append("|");
        sb.append(gnmNodeLevel);
        sb.append("|");
        sb.append(gnmOperatingEntity);
        sb.append("|");
        sb.append(gnmPhoneNo);
        sb.append("|");
        sb.append(gnmEmailId);
        sb.append("|");
        sb.append(gnmAddress1);
        sb.append("|");
        sb.append(gnmAddress2);
        sb.append("|");
        sb.append(gnmAddress3);
        sb.append("|");
        sb.append(gnmFaxNo);
        sb.append("|");
        sb.append(gnmContactPerson1);
        sb.append("|");
        sb.append(gnmContactPerson2);
        sb.append("|");
        sb.append(gnmParent);
        sb.append("|");
        sb.append(gnmGridNodeType);
        sb.append("|");
        sb.append(gnmCreatedBy);
        sb.append("|");
        sb.append(gnmCreatedDt);
        sb.append("|");
        sb.append(gnmModifiedBy);
        sb.append("|");
        sb.append(gnmModifiedDt);
        sb.append("|");
        sb.append(gnmIsActive);
        sb.append("|");
        sb.append(gnmLossApplicability);
        sb.append("|");
        sb.append(gnmGridNodeId);
        sb.append("|");
        sb.append(gnmChargeApplicability);
        sb.append("|");
        sb.append(gnmQtyApplied);
        sb.append("|");
        sb.append(gnmAppliedOnUnittype);
        sb.append("|");
        sb.append(gnmAccCode);
        sb.append("|");
        sb.append(gnmGridStateCode);
        sb.append("|");
        sb.append(gnmBidArea);
        sb.append("|");
        sb.append(oldGridNodeCode);
        sb.append("|");
      
        sb.append("|");
        sb.append(gnmRldcRegistrationCode);
        sb.append("|");
       
        sb.append("|");
       
        return sb.toString(); 
    } 

}
