/*
 * Created on 2023-12-05 ( 16:25:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.pxil.sec.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JPA entity class for "ApiGroupRole"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="api_group_role")
@JsonIgnoreProperties({"apiGroup","apiRole","createdOn","createdBy","modifiedOn","modifiedBy","activeC"})
public class ApiGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="api_group_id", nullable=false)
    private Integer    apiGroupId ;

    @Column(name="api_role_id", nullable=false)
    private Integer    apiRoleId ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on")
    private Date       createdOn ;

    @Column(name="created_by")
    private Integer    createdBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_on")
    private Date       modifiedOn ;

    @Column(name="modified_by")
    private Integer    modifiedBy ;

    @Column(name="active_c", length=1)
    private String     activeC ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="api_group_id", referencedColumnName="id", insertable=false, updatable=false)
    private ApiGroup   apiGroup ; 

    @ManyToOne
    @JoinColumn(name="api_role_id", referencedColumnName="id", insertable=false, updatable=false)
    private ApiRole    apiRole ; 


    /**
     * Constructor
     */
    public ApiGroupRole() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setApiGroupId( Integer apiGroupId ) {
        this.apiGroupId = apiGroupId ;
    }
    public Integer getApiGroupId() {
        return this.apiGroupId;
    }

    public void setApiRoleId( Integer apiRoleId ) {
        this.apiRoleId = apiRoleId ;
    }
    public Integer getApiRoleId() {
        return this.apiRoleId;
    }

    public void setCreatedOn( Date createdOn ) {
        this.createdOn = createdOn ;
    }
    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedBy( Integer createdBy ) {
        this.createdBy = createdBy ;
    }
    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setModifiedOn( Date modifiedOn ) {
        this.modifiedOn = modifiedOn ;
    }
    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedBy( Integer modifiedBy ) {
        this.modifiedBy = modifiedBy ;
    }
    public Integer getModifiedBy() {
        return this.modifiedBy;
    }

    public void setActiveC( String activeC ) {
        this.activeC = activeC ;
    }
    public String getActiveC() {
        return this.activeC;
    }

    //--- GETTERS FOR LINKS
    public ApiGroup getApiGroup() {
        return this.apiGroup;
    } 

    public ApiRole getApiRole() {
        return this.apiRole;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(apiGroupId);
        sb.append("|");
        sb.append(apiRoleId);
        sb.append("|");
        sb.append(createdOn);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(modifiedOn);
        sb.append("|");
        sb.append(modifiedBy);
        sb.append("|");
        sb.append(activeC);
        return sb.toString(); 
    } 

}
