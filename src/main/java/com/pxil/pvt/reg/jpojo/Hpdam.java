
package com.pxil.pvt.reg.jpojo;


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
    "date",
    "purchase_bid",
    "sell_bid",
    "MCV",
    "MCP",
    "congestion",
    "cleared_volume",
    "real_time_curtailment",
    "final_schedule_volume"
})
@Generated("jsonschema2pojo")
public class Hpdam {

    @JsonProperty("date")
    private String date;
    @JsonProperty("purchase_bid")
    private List<Double> purchaseBid = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("sell_bid")
    private List<Double> sellBid = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("MCV")
    private List<Double> mcv = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("MCP")
    private List<Double> mcp = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("congestion")
    private List<Double> congestion = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("cleared_volume")
    private List<Double> clearedVolume = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("real_time_curtailment")
    private List<Double> realTimeCurtailment = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("final_schedule_volume")
    private List<Double> finalScheduleVolume = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public Hpdam withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("purchase_bid")
    public List<Double> getPurchaseBid() {
        return purchaseBid;
    }

    @JsonProperty("purchase_bid")
    public void setPurchaseBid(List<Double> purchaseBid) {
        this.purchaseBid = purchaseBid;
    }

    public Hpdam withPurchaseBid(List<Double> purchaseBid) {
        this.purchaseBid = purchaseBid;
        return this;
    }

    @JsonProperty("sell_bid")
    public List<Double> getSellBid() {
        return sellBid;
    }

    @JsonProperty("sell_bid")
    public void setSellBid(List<Double> sellBid) {
        this.sellBid = sellBid;
    }

    public Hpdam withSellBid(List<Double> sellBid) {
        this.sellBid = sellBid;
        return this;
    }

    @JsonProperty("MCV")
    public List<Double> getMcv() {
        return mcv;
    }

    @JsonProperty("MCV")
    public void setMcv(List<Double> mcv) {
        this.mcv = mcv;
    }

    public Hpdam withMcv(List<Double> mcv) {
        this.mcv = mcv;
        return this;
    }

    @JsonProperty("MCP")
    public List<Double> getMcp() {
        return mcp;
    }

    @JsonProperty("MCP")
    public void setMcp(List<Double> mcp) {
        this.mcp = mcp;
    }

    public Hpdam withMcp(List<Double> mcp) {
        this.mcp = mcp;
        return this;
    }

    @JsonProperty("congestion")
    public List<Double> getCongestion() {
        return congestion;
    }

    @JsonProperty("congestion")
    public void setCongestion(List<Double> congestion) {
        this.congestion = congestion;
    }

    public Hpdam withCongestion(List<Double> congestion) {
        this.congestion = congestion;
        return this;
    }

    @JsonProperty("cleared_volume")
    public List<Double> getClearedVolume() {
        return clearedVolume;
    }

    @JsonProperty("cleared_volume")
    public void setClearedVolume(List<Double> clearedVolume) {
        this.clearedVolume = clearedVolume;
    }

    public Hpdam withClearedVolume(List<Double> clearedVolume) {
        this.clearedVolume = clearedVolume;
        return this;
    }

    @JsonProperty("real_time_curtailment")
    public List<Double> getRealTimeCurtailment() {
        return realTimeCurtailment;
    }

    @JsonProperty("real_time_curtailment")
    public void setRealTimeCurtailment(List<Double> realTimeCurtailment) {
        this.realTimeCurtailment = realTimeCurtailment;
    }

    public Hpdam withRealTimeCurtailment(List<Double> realTimeCurtailment) {
        this.realTimeCurtailment = realTimeCurtailment;
        return this;
    }

    @JsonProperty("final_schedule_volume")
    public List<Double> getFinalScheduleVolume() {
        return finalScheduleVolume;
    }

    @JsonProperty("final_schedule_volume")
    public void setFinalScheduleVolume(List<Double> finalScheduleVolume) {
        this.finalScheduleVolume = finalScheduleVolume;
    }

    public Hpdam withFinalScheduleVolume(List<Double> finalScheduleVolume) {
        this.finalScheduleVolume = finalScheduleVolume;
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

    public Hpdam withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Hpdam.class.getName()).append('@').append(Double.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("purchaseBid");
        sb.append('=');
        sb.append(((this.purchaseBid == null)?"<null>":this.purchaseBid));
        sb.append(',');
        sb.append("sellBid");
        sb.append('=');
        sb.append(((this.sellBid == null)?"<null>":this.sellBid));
        sb.append(',');
        sb.append("mcv");
        sb.append('=');
        sb.append(((this.mcv == null)?"<null>":this.mcv));
        sb.append(',');
        sb.append("mcp");
        sb.append('=');
        sb.append(((this.mcp == null)?"<null>":this.mcp));
        sb.append(',');
        sb.append("congestion");
        sb.append('=');
        sb.append(((this.congestion == null)?"<null>":this.congestion));
        sb.append(',');
        sb.append("clearedVolume");
        sb.append('=');
        sb.append(((this.clearedVolume == null)?"<null>":this.clearedVolume));
        sb.append(',');
        sb.append("realTimeCurtailment");
        sb.append('=');
        sb.append(((this.realTimeCurtailment == null)?"<null>":this.realTimeCurtailment));
        sb.append(',');
        sb.append("finalScheduleVolume");
        sb.append('=');
        sb.append(((this.finalScheduleVolume == null)?"<null>":this.finalScheduleVolume));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.sellBid == null)? 0 :this.sellBid.hashCode()));
        result = ((result* 31)+((this.mcv == null)? 0 :this.mcv.hashCode()));
        result = ((result* 31)+((this.purchaseBid == null)? 0 :this.purchaseBid.hashCode()));
        result = ((result* 31)+((this.realTimeCurtailment == null)? 0 :this.realTimeCurtailment.hashCode()));
        result = ((result* 31)+((this.finalScheduleVolume == null)? 0 :this.finalScheduleVolume.hashCode()));
        result = ((result* 31)+((this.mcp == null)? 0 :this.mcp.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.clearedVolume == null)? 0 :this.clearedVolume.hashCode()));
        result = ((result* 31)+((this.congestion == null)? 0 :this.congestion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hpdam) == false) {
            return false;
        }
        Hpdam rhs = ((Hpdam) other);
        return (((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.sellBid == rhs.sellBid)||((this.sellBid!= null)&&this.sellBid.equals(rhs.sellBid))))&&((this.mcv == rhs.mcv)||((this.mcv!= null)&&this.mcv.equals(rhs.mcv))))&&((this.purchaseBid == rhs.purchaseBid)||((this.purchaseBid!= null)&&this.purchaseBid.equals(rhs.purchaseBid))))&&((this.realTimeCurtailment == rhs.realTimeCurtailment)||((this.realTimeCurtailment!= null)&&this.realTimeCurtailment.equals(rhs.realTimeCurtailment))))&&((this.finalScheduleVolume == rhs.finalScheduleVolume)||((this.finalScheduleVolume!= null)&&this.finalScheduleVolume.equals(rhs.finalScheduleVolume))))&&((this.mcp == rhs.mcp)||((this.mcp!= null)&&this.mcp.equals(rhs.mcp))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.clearedVolume == rhs.clearedVolume)||((this.clearedVolume!= null)&&this.clearedVolume.equals(rhs.clearedVolume))))&&((this.congestion == rhs.congestion)||((this.congestion!= null)&&this.congestion.equals(rhs.congestion))));
    }

}
