
package com.pxil.pvt.sldc.jpojo.rtm;

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
    "deliveryDate",
    "user",
    "sldc",
    "request_date",
    "request_time",
    "delivery"
})
@Generated("jsonschema2pojo")
public class Pxil {

    @JsonProperty("deliveryDate")
    private String deliveryDate;
    @JsonProperty("user")
    private String user;
    @JsonProperty("sldc")
    private String sldc;
    @JsonProperty("request_date")
    private String requestDate;
    @JsonProperty("request_time")
    private String requestTime;
    @JsonProperty("delivery")
    private List<Delivery> delivery = new ArrayList<Delivery>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("deliveryDate")
    public String getDeliveryDate() {
        return deliveryDate;
    }

    @JsonProperty("deliveryDate")
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Pxil withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public Pxil withUser(String user) {
        this.user = user;
        return this;
    }

    @JsonProperty("sldc")
    public String getSldc() {
        return sldc;
    }

    @JsonProperty("sldc")
    public void setSldc(String sldc) {
        this.sldc = sldc;
    }

    public Pxil withSldc(String sldc) {
        this.sldc = sldc;
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

    @JsonProperty("request_time")
    public String getRequestTime() {
        return requestTime;
    }

    @JsonProperty("request_time")
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public Pxil withRequestTime(String requestTime) {
        this.requestTime = requestTime;
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
        sb.append(Pxil .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deliveryDate");
        sb.append('=');
        sb.append(((this.deliveryDate == null)?"<null>":this.deliveryDate));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("sldc");
        sb.append('=');
        sb.append(((this.sldc == null)?"<null>":this.sldc));
        sb.append(',');
        sb.append("requestDate");
        sb.append('=');
        sb.append(((this.requestDate == null)?"<null>":this.requestDate));
        sb.append(',');
        sb.append("requestTime");
        sb.append('=');
        sb.append(((this.requestTime == null)?"<null>":this.requestTime));
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
        result = ((result* 31)+((this.requestTime == null)? 0 :this.requestTime.hashCode()));
        result = ((result* 31)+((this.delivery == null)? 0 :this.delivery.hashCode()));
        result = ((result* 31)+((this.requestDate == null)? 0 :this.requestDate.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.deliveryDate == null)? 0 :this.deliveryDate.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.sldc == null)? 0 :this.sldc.hashCode()));
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
        return ((((((((this.requestTime == rhs.requestTime)||((this.requestTime!= null)&&this.requestTime.equals(rhs.requestTime)))&&((this.delivery == rhs.delivery)||((this.delivery!= null)&&this.delivery.equals(rhs.delivery))))&&((this.requestDate == rhs.requestDate)||((this.requestDate!= null)&&this.requestDate.equals(rhs.requestDate))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.deliveryDate == rhs.deliveryDate)||((this.deliveryDate!= null)&&this.deliveryDate.equals(rhs.deliveryDate))))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.sldc == rhs.sldc)||((this.sldc!= null)&&this.sldc.equals(rhs.sldc))));
    }

}
