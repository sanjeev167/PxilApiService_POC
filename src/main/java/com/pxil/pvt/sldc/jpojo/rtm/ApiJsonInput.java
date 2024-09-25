
package com.pxil.pvt.sldc.jpojo.rtm;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author sanjeevkumar
 * 11-Dec-2023
 * 2:32:40 pm 
 * Objective : This is a top level class which will be used for final json creation required for regulatory api json response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PXIL"
})
@Generated("jsonschema2pojo")
public class ApiJsonInput {

    @JsonProperty("PXIL")
    private com.pxil.pvt.sldc.jpojo.rtm.Pxil pxil = new com.pxil.pvt.sldc.jpojo.rtm.Pxil();
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    

    @JsonProperty("PXIL")
    public com.pxil.pvt.sldc.jpojo.rtm.Pxil getPxil() {
        return pxil;
    }

    @JsonProperty("PXIL")
    public void setPxil(com.pxil.pvt.sldc.jpojo.rtm.Pxil pxil) {
        this.pxil = pxil;
    }

    public ApiJsonInput withPxil(com.pxil.pvt.sldc.jpojo.rtm.Pxil pxil) {
        this.pxil = pxil;
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

    public ApiJsonInput withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiJsonInput.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pxil");
        sb.append('=');
        sb.append(((this.pxil == null)?"<null>":this.pxil));
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
        result = ((result* 31)+((this.pxil == null)? 0 :this.pxil.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiJsonInput) == false) {
            return false;
        }
        ApiJsonInput rhs = ((ApiJsonInput) other);
        return (((this.pxil == rhs.pxil)||((this.pxil!= null)&&this.pxil.equals(rhs.pxil)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
