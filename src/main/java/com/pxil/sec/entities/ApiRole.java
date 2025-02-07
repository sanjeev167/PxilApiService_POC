/*
 * Created on 2023-12-05 ( 16:25:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.pxil.sec.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JPA entity class for "ApiRole"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="api_role")
@JsonIgnoreProperties({"createdOn","createdBy","modifiedOn","modifiedBy","activeC"})
public class ApiRole implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="role_name", nullable=false, length=100)
    private String     roleName ;

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
    @OneToMany(mappedBy="apiRole",fetch = FetchType.EAGER)
    private List<ApiGroupRole> listOfApiGroupRole ; 


    /**
     * Constructor
     */
    public ApiRole() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setRoleName( String roleName ) {
        this.roleName = roleName ;
    }
    public String getRoleName() {
        return this.roleName;
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
    public List<ApiGroupRole> getListOfApiGroupRole() {
        return this.listOfApiGroupRole;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(roleName);
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
