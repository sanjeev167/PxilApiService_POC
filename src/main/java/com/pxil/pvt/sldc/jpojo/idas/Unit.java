
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
    "unitCode",
    "unitName",
    "pxCode",
    "segments"
})
@Generated("jsonschema2pojo")
public class Unit {

    @JsonProperty("unitCode")
    private String unitCode;
    @JsonProperty("unitName")
    private String unitName;
    @JsonProperty("pxCode")
    private String pxCode;
    @JsonProperty("segments")
    private List<Segment> segments = new ArrayList<Segment>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unitCode")
    public String getUnitCode() {
        return unitCode;
    }

    @JsonProperty("unitCode")
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Unit withUnitCode(String unitCode) {
        this.unitCode = unitCode;
        return this;
    }

    @JsonProperty("unitName")
    public String getUnitName() {
        return unitName;
    }

    @JsonProperty("unitName")
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Unit withUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    @JsonProperty("pxCode")
    public String getPxCode() {
        return pxCode;
    }

    @JsonProperty("pxCode")
    public void setPxCode(String pxCode) {
        this.pxCode = pxCode;
    }

    public Unit withPxCode(String pxCode) {
        this.pxCode = pxCode;
        return this;
    }

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public Unit withSegments(List<Segment> segments) {
        this.segments = segments;
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

    public Unit withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Unit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("unitCode");
        sb.append('=');
        sb.append(((this.unitCode == null)?"<null>":this.unitCode));
        sb.append(',');
        sb.append("unitName");
        sb.append('=');
        sb.append(((this.unitName == null)?"<null>":this.unitName));
        sb.append(',');
        sb.append("pxCode");
        sb.append('=');
        sb.append(((this.pxCode == null)?"<null>":this.pxCode));
        sb.append(',');
        sb.append("segments");
        sb.append('=');
        sb.append(((this.segments == null)?"<null>":this.segments));
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
        result = ((result* 31)+((this.unitName == null)? 0 :this.unitName.hashCode()));
        result = ((result* 31)+((this.pxCode == null)? 0 :this.pxCode.hashCode()));
        result = ((result* 31)+((this.unitCode == null)? 0 :this.unitCode.hashCode()));
        result = ((result* 31)+((this.segments == null)? 0 :this.segments.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Unit) == false) {
            return false;
        }
        Unit rhs = ((Unit) other);
        return ((((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.unitName == rhs.unitName)||((this.unitName!= null)&&this.unitName.equals(rhs.unitName))))&&((this.pxCode == rhs.pxCode)||((this.pxCode!= null)&&this.pxCode.equals(rhs.pxCode))))&&((this.unitCode == rhs.unitCode)||((this.unitCode!= null)&&this.unitCode.equals(rhs.unitCode))))&&((this.segments == rhs.segments)||((this.segments!= null)&&this.segments.equals(rhs.segments))));
    }

}
