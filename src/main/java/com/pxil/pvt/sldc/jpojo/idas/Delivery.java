
package com.pxil.pvt.sldc.jpojo.idas;

import java.util.HashMap;
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
    "IDAS"
})
@Generated("jsonschema2pojo")
public class Delivery {

    @JsonProperty("deliveryDate")
    private String deliveryDate;
    @JsonProperty("IDAS")
    private Idas idas;
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

    public Delivery withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    @JsonProperty("IDAS")
    public Idas getIdas() {
        return idas;
    }

    @JsonProperty("IDAS")
    public void setIdas(Idas idas) {
        this.idas = idas;
    }

    public Delivery withIdas(Idas idas) {
        this.idas = idas;
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

    public Delivery withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Delivery.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deliveryDate");
        sb.append('=');
        sb.append(((this.deliveryDate == null)?"<null>":this.deliveryDate));
        sb.append(',');
        sb.append("idas");
        sb.append('=');
        sb.append(((this.idas == null)?"<null>":this.idas));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.deliveryDate == null)? 0 :this.deliveryDate.hashCode()));
        result = ((result* 31)+((this.idas == null)? 0 :this.idas.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Delivery) == false) {
            return false;
        }
        Delivery rhs = ((Delivery) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.deliveryDate == rhs.deliveryDate)||((this.deliveryDate!= null)&&this.deliveryDate.equals(rhs.deliveryDate))))&&((this.idas == rhs.idas)||((this.idas!= null)&&this.idas.equals(rhs.idas))));
    }

}
