
package com.pxil.pvt.sldc.jpojo.idas;

import java.util.ArrayList;
import java.util.Collections;
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
    "withoutLoss",
    "withRegionLoss",
    "withSldcLoss"
})
@Generated("jsonschema2pojo")
public class Sell {

    @JsonProperty("withoutLoss")
    private List<Double> withoutLoss = new ArrayList<Double>(Collections.nCopies (96, 0.0));  
    @JsonProperty("withRegionLoss")
    private List<Double> withRegionLoss = new ArrayList<Double>(Collections.nCopies (96, 0.0));  
    @JsonProperty("withSldcLoss")
    private List<Double> withSldcLoss = new ArrayList<Double>(Collections.nCopies (96, 0.0));  
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("withoutLoss")
    public List<Double> getWithoutLoss() {
        return withoutLoss;
    }

    @JsonProperty("withoutLoss")
    public void setWithoutLoss(List<Double> withoutLoss) {
        this.withoutLoss = withoutLoss;
    }

    public Sell withWithoutLoss(List<Double> withoutLoss) {
        this.withoutLoss = withoutLoss;
        return this;
    }

    @JsonProperty("withRegionLoss")
    public List<Double> getWithRegionLoss() {
        return withRegionLoss;
    }

    @JsonProperty("withRegionLoss")
    public void setWithRegionLoss(List<Double> withRegionLoss) {
        this.withRegionLoss = withRegionLoss;
    }

    public Sell withWithRegionLoss(List<Double> withRegionLoss) {
        this.withRegionLoss = withRegionLoss;
        return this;
    }

    @JsonProperty("withSldcLoss")
    public List<Double> getWithSldcLoss() {
        return withSldcLoss;
    }

    @JsonProperty("withSldcLoss")
    public void setWithSldcLoss(List<Double> withSldcLoss) {
        this.withSldcLoss = withSldcLoss;
    }

    public Sell withWithSldcLoss(List<Double> withSldcLoss) {
        this.withSldcLoss = withSldcLoss;
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

    public Sell withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Sell.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("withoutLoss");
        sb.append('=');
        sb.append(((this.withoutLoss == null)?"<null>":this.withoutLoss));
        sb.append(',');
        sb.append("withRegionLoss");
        sb.append('=');
        sb.append(((this.withRegionLoss == null)?"<null>":this.withRegionLoss));
        sb.append(',');
        sb.append("withSldcLoss");
        sb.append('=');
        sb.append(((this.withSldcLoss == null)?"<null>":this.withSldcLoss));
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
        result = ((result* 31)+((this.withRegionLoss == null)? 0 :this.withRegionLoss.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.withSldcLoss == null)? 0 :this.withSldcLoss.hashCode()));
        result = ((result* 31)+((this.withoutLoss == null)? 0 :this.withoutLoss.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sell) == false) {
            return false;
        }
        Sell rhs = ((Sell) other);
        return (((((this.withRegionLoss == rhs.withRegionLoss)||((this.withRegionLoss!= null)&&this.withRegionLoss.equals(rhs.withRegionLoss)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.withSldcLoss == rhs.withSldcLoss)||((this.withSldcLoss!= null)&&this.withSldcLoss.equals(rhs.withSldcLoss))))&&((this.withoutLoss == rhs.withoutLoss)||((this.withoutLoss!= null)&&this.withoutLoss.equals(rhs.withoutLoss))));
    }

}
