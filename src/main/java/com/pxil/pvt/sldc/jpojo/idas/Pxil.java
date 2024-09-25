
package com.pxil.pvt.sldc.jpojo.idas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestedDeliveryDate",
    "ApiUser",
    "UsersSldc",
    "request_date",   
    "delivery"
})
@Generated("jsonschema2pojo")
public class Pxil {

    @JsonProperty("requestedDeliveryDate")
    private String requestedDeliveryDate;
    @JsonProperty("ApiUser")
    private String apiUser;
    
    @JsonProperty("UsersSldc")
    private String usersSldc;
    
    @JsonProperty("request_date")    
    private String requestDate;
    @JsonProperty("request_time")
    private String requestTime;
    @JsonProperty("delivery")
    private List<Delivery> delivery = new ArrayList<Delivery>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("requestedDeliveryDate")
    public String getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    @JsonProperty("requestedDeliveryDate")
    public void setRequestedDeliveryDate(String requestedDeliveryDate) {
        this.requestedDeliveryDate = requestedDeliveryDate;
    }

    public Pxil withRequestedDeliveryDate(String requestedDeliveryDate) {
        this.requestedDeliveryDate = requestedDeliveryDate;
        return this;
    }

    @JsonProperty("ApiUser")
    public String getApiUser() {
        return apiUser;
    }

    @JsonProperty("ApiUser")
    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public Pxil withApiUser(String apiUser) {
        this.apiUser = apiUser;
        return this;
    }
    
    
    @JsonProperty("UsersSldc")
    public String getUsersSldc() {
        return usersSldc;
    }

    @JsonProperty("UsersSldc")
    public void setUsersSldc(String usersSldc) {
        this.usersSldc = usersSldc;
    }

    public Pxil withUsersSldc(String usersSldc) {
        this.usersSldc = usersSldc;
        return this;
    }
    
    

    @JsonProperty("request_date")
    public String getRequestDate() {
        return requestDate;
    }

    @JsonProperty("request_date")
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Pxil withRequestDate(String requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    

    @JsonProperty("delivery")
    public List<Delivery> getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
    }

    public Pxil withDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Pxil withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pxil.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestedDeliveryDate");
        sb.append('=');
        sb.append(((this.requestedDeliveryDate == null)?"<null>":this.requestedDeliveryDate));
        sb.append(',');
        sb.append("apiUser");
        sb.append('=');
        sb.append(((this.apiUser == null)?"<null>":this.apiUser));
        sb.append(',');
        sb.append("requestDate");
        sb.append('=');
        sb.append(((this.requestDate == null)?"<null>":this.requestDate));
        sb.append(',');
       
        sb.append("delivery");
        sb.append('=');
        sb.append(((this.delivery == null)?"<null>":this.delivery));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        
        result = ((result* 31)+((this.delivery == null)? 0 :this.delivery.hashCode()));
        result = ((result* 31)+((this.requestedDeliveryDate == null)? 0 :this.requestedDeliveryDate.hashCode()));
        result = ((result* 31)+((this.requestDate == null)? 0 :this.requestDate.hashCode()));
        result = ((result* 31)+((this.apiUser == null)? 0 :this.apiUser.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pxil) == false) {
            return false;
        }
        Pxil rhs = ((Pxil) other);
        return (((((((this.delivery == rhs.delivery)||((this.delivery!= null)&&this.delivery.equals(rhs.delivery))))&&((this.requestedDeliveryDate == rhs.requestedDeliveryDate)||((this.requestedDeliveryDate!= null)&&this.requestedDeliveryDate.equals(rhs.requestedDeliveryDate))))&&((this.requestDate == rhs.requestDate)||((this.requestDate!= null)&&this.requestDate.equals(rhs.requestDate))))&&((this.apiUser == rhs.apiUser)||((this.apiUser!= null)&&this.apiUser.equals(rhs.apiUser))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
