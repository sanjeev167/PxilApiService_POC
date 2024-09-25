
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
    "sourceType",
    "buy",
    "sell"
})
@Generated("jsonschema2pojo")
public class Segment {

    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("buy")
    private Buy buy;
    @JsonProperty("sell")
    private Sell sell;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sourceType")
    public String getSourceType() {
        return sourceType;
    }

    @JsonProperty("sourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Segment withSourceType(String sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    @JsonProperty("buy")
    public Buy getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(Buy buy) {
        this.buy = buy;
    }

    public Segment withBuy(Buy buy) {
        this.buy = buy;
        return this;
    }

    @JsonProperty("sell")
    public Sell getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(Sell sell) {
        this.sell = sell;
    }

    public Segment withSell(Sell sell) {
        this.sell = sell;
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

    public Segment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Segment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sourceType");
        sb.append('=');
        sb.append(((this.sourceType == null)?"<null>":this.sourceType));
        sb.append(',');
        sb.append("buy");
        sb.append('=');
        sb.append(((this.buy == null)?"<null>":this.buy));
        sb.append(',');
        sb.append("sell");
        sb.append('=');
        sb.append(((this.sell == null)?"<null>":this.sell));
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
        result = ((result* 31)+((this.sourceType == null)? 0 :this.sourceType.hashCode()));
        result = ((result* 31)+((this.buy == null)? 0 :this.buy.hashCode()));
        result = ((result* 31)+((this.sell == null)? 0 :this.sell.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Segment) == false) {
            return false;
        }
        Segment rhs = ((Segment) other);
        return (((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.sourceType == rhs.sourceType)||((this.sourceType!= null)&&this.sourceType.equals(rhs.sourceType))))&&((this.buy == rhs.buy)||((this.buy!= null)&&this.buy.equals(rhs.buy))))&&((this.sell == rhs.sell)||((this.sell!= null)&&this.sell.equals(rhs.sell))));
    }

}
