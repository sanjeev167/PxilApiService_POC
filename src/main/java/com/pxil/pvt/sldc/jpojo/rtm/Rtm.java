
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
    "reginalEntityName",
    "reginalEntityCode",
    "regionalInjectionLossPer",
    "regionalWithdrawalLossPer",
    "stateInjectionLossPer",
    "stateWithdrawalLossPer",
    "units"
})
@Generated("jsonschema2pojo")
public class Rtm {

    @JsonProperty("reginalEntityName")
    private String reginalEntityName;
    @JsonProperty("reginalEntityCode")
    private String reginalEntityCode;
    @JsonProperty("regionalInjectionLossPer")
    private String regionalInjectionLossPer;
    @JsonProperty("regionalWithdrawalLossPer")
    private String regionalWithdrawalLossPer;
    @JsonProperty("stateInjectionLossPer")
    private String stateInjectionLossPer;
    @JsonProperty("stateWithdrawalLossPer")
    private String stateWithdrawalLossPer;
    @JsonProperty("units")
    private List<Unit> units = new ArrayList<Unit>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reginalEntityName")
    public String getReginalEntityName() {
        return reginalEntityName;
    }

    @JsonProperty("reginalEntityName")
    public void setReginalEntityName(String reginalEntityName) {
        this.reginalEntityName = reginalEntityName;
    }

    public Rtm withReginalEntityName(String reginalEntityName) {
        this.reginalEntityName = reginalEntityName;
        return this;
    }

    @JsonProperty("reginalEntityCode")
    public String getReginalEntityCode() {
        return reginalEntityCode;
    }

    @JsonProperty("reginalEntityCode")
    public void setReginalEntityCode(String reginalEntityCode) {
        this.reginalEntityCode = reginalEntityCode;
    }

    public Rtm withReginalEntityCode(String reginalEntityCode) {
        this.reginalEntityCode = reginalEntityCode;
        return this;
    }

    @JsonProperty("regionalInjectionLossPer")
    public String getRegionalInjectionLossPer() {
        return regionalInjectionLossPer;
    }

    @JsonProperty("regionalInjectionLossPer")
    public void setRegionalInjectionLossPer(String regionalInjectionLossPer) {
        this.regionalInjectionLossPer = regionalInjectionLossPer;
    }

    public Rtm withRegionalInjectionLossPer(String regionalInjectionLossPer) {
        this.regionalInjectionLossPer = regionalInjectionLossPer;
        return this;
    }

    @JsonProperty("regionalWithdrawalLossPer")
    public String getRegionalWithdrawalLossPer() {
        return regionalWithdrawalLossPer;
    }

    @JsonProperty("regionalWithdrawalLossPer")
    public void setRegionalWithdrawalLossPer(String regionalWithdrawalLossPer) {
        this.regionalWithdrawalLossPer = regionalWithdrawalLossPer;
    }

    public Rtm withRegionalWithdrawalLossPer(String regionalWithdrawalLossPer) {
        this.regionalWithdrawalLossPer = regionalWithdrawalLossPer;
        return this;
    }

    @JsonProperty("stateInjectionLossPer")
    public String getStateInjectionLossPer() {
        return stateInjectionLossPer;
    }

    @JsonProperty("stateInjectionLossPer")
    public void setStateInjectionLossPer(String stateInjectionLossPer) {
        this.stateInjectionLossPer = stateInjectionLossPer;
    }

    public Rtm withStateInjectionLossPer(String stateInjectionLossPer) {
        this.stateInjectionLossPer = stateInjectionLossPer;
        return this;
    }

    @JsonProperty("stateWithdrawalLossPer")
    public String getStateWithdrawalLossPer() {
        return stateWithdrawalLossPer;
    }

    @JsonProperty("stateWithdrawalLossPer")
    public void setStateWithdrawalLossPer(String stateWithdrawalLossPer) {
        this.stateWithdrawalLossPer = stateWithdrawalLossPer;
    }

    public Rtm withStateWithdrawalLossPer(String stateWithdrawalLossPer) {
        this.stateWithdrawalLossPer = stateWithdrawalLossPer;
        return this;
    }

    @JsonProperty("units")
    public List<Unit> getUnits() {
        return units;
    }

    @JsonProperty("units")
    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public Rtm withUnits(List<Unit> units) {
        this.units = units;
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

    public Rtm withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Rtm.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reginalEntityName");
        sb.append('=');
        sb.append(((this.reginalEntityName == null)?"<null>":this.reginalEntityName));
        sb.append(',');
        sb.append("reginalEntityCode");
        sb.append('=');
        sb.append(((this.reginalEntityCode == null)?"<null>":this.reginalEntityCode));
        sb.append(',');
        sb.append("regionalInjectionLossPer");
        sb.append('=');
        sb.append(((this.regionalInjectionLossPer == null)?"<null>":this.regionalInjectionLossPer));
        sb.append(',');
        sb.append("regionalWithdrawalLossPer");
        sb.append('=');
        sb.append(((this.regionalWithdrawalLossPer == null)?"<null>":this.regionalWithdrawalLossPer));
        sb.append(',');
        sb.append("stateInjectionLossPer");
        sb.append('=');
        sb.append(((this.stateInjectionLossPer == null)?"<null>":this.stateInjectionLossPer));
        sb.append(',');
        sb.append("stateWithdrawalLossPer");
        sb.append('=');
        sb.append(((this.stateWithdrawalLossPer == null)?"<null>":this.stateWithdrawalLossPer));
        sb.append(',');
        sb.append("units");
        sb.append('=');
        sb.append(((this.units == null)?"<null>":this.units));
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
        result = ((result* 31)+((this.reginalEntityName == null)? 0 :this.reginalEntityName.hashCode()));
        result = ((result* 31)+((this.regionalInjectionLossPer == null)? 0 :this.regionalInjectionLossPer.hashCode()));
        result = ((result* 31)+((this.reginalEntityCode == null)? 0 :this.reginalEntityCode.hashCode()));
        result = ((result* 31)+((this.stateInjectionLossPer == null)? 0 :this.stateInjectionLossPer.hashCode()));
        result = ((result* 31)+((this.units == null)? 0 :this.units.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.regionalWithdrawalLossPer == null)? 0 :this.regionalWithdrawalLossPer.hashCode()));
        result = ((result* 31)+((this.stateWithdrawalLossPer == null)? 0 :this.stateWithdrawalLossPer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rtm) == false) {
            return false;
        }
        Rtm rhs = ((Rtm) other);
        return (((((((((this.reginalEntityName == rhs.reginalEntityName)||((this.reginalEntityName!= null)&&this.reginalEntityName.equals(rhs.reginalEntityName)))&&((this.regionalInjectionLossPer == rhs.regionalInjectionLossPer)||((this.regionalInjectionLossPer!= null)&&this.regionalInjectionLossPer.equals(rhs.regionalInjectionLossPer))))&&((this.reginalEntityCode == rhs.reginalEntityCode)||((this.reginalEntityCode!= null)&&this.reginalEntityCode.equals(rhs.reginalEntityCode))))&&((this.stateInjectionLossPer == rhs.stateInjectionLossPer)||((this.stateInjectionLossPer!= null)&&this.stateInjectionLossPer.equals(rhs.stateInjectionLossPer))))&&((this.units == rhs.units)||((this.units!= null)&&this.units.equals(rhs.units))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.regionalWithdrawalLossPer == rhs.regionalWithdrawalLossPer)||((this.regionalWithdrawalLossPer!= null)&&this.regionalWithdrawalLossPer.equals(rhs.regionalWithdrawalLossPer))))&&((this.stateWithdrawalLossPer == rhs.stateWithdrawalLossPer)||((this.stateWithdrawalLossPer!= null)&&this.stateWithdrawalLossPer.equals(rhs.stateWithdrawalLossPer))));
    }

}
