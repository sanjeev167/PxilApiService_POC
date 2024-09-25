
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
    "cleared_volume_non_solar",
    "cleared_volume_solar",
    "cleared_volume_hydro",
    "cleared_volume_total",
    "real_time_curtailment",
    "final_schedule_volume_hydro",
    "final_schedule_volume_non_solar",
    "final_schedule_volume_solar",
    "final_schedule_volume_total"
})
@Generated("jsonschema2pojo")
public class Gdam {

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
    @JsonProperty("cleared_volume_non_solar")
    private List<Double> clearedVolumeNonSolar = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("cleared_volume_solar")
    private List<Double> clearedVolumeSolar = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("cleared_volume_hydro")
    private List<Double> clearedVolumeHydro = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("cleared_volume_total")
    private List<Double> clearedVolumeTotal = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("real_time_curtailment")
    private List<Double> realTimeCurtailment = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("final_schedule_volume_hydro")
    private List<Double> finalScheduleVolumeHydro = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("final_schedule_volume_non_solar")
    private List<Double> finalScheduleVolumeNonSolar = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("final_schedule_volume_solar")
    private List<Double> finalScheduleVolumeSolar = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("final_schedule_volume_total")
    private List<Double> finalScheduleVolumeTotal = new ArrayList<Double>(Collections.nCopies (96, 0.0));
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

    public Gdam withDate(String date) {
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

    public Gdam withPurchaseBid(List<Double> purchaseBid) {
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

    public Gdam withSellBid(List<Double> sellBid) {
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

    public Gdam withMcv(List<Double> mcv) {
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

    public Gdam withMcp(List<Double> mcp) {
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

    public Gdam withCongestion(List<Double> congestion) {
        this.congestion = congestion;
        return this;
    }

    @JsonProperty("cleared_volume_non_solar")
    public List<Double> getClearedVolumeNonSolar() {
        return clearedVolumeNonSolar;
    }

    @JsonProperty("cleared_volume_non_solar")
    public void setClearedVolumeNonSolar(List<Double> clearedVolumeNonSolar) {
        this.clearedVolumeNonSolar = clearedVolumeNonSolar;
    }

    public Gdam withClearedVolumeNonSolar(List<Double> clearedVolumeNonSolar) {
        this.clearedVolumeNonSolar = clearedVolumeNonSolar;
        return this;
    }

    @JsonProperty("cleared_volume_solar")
    public List<Double> getClearedVolumeSolar() {
        return clearedVolumeSolar;
    }

    @JsonProperty("cleared_volume_solar")
    public void setClearedVolumeSolar(List<Double> clearedVolumeSolar) {
        this.clearedVolumeSolar = clearedVolumeSolar;
    }

    public Gdam withClearedVolumeSolar(List<Double> clearedVolumeSolar) {
        this.clearedVolumeSolar = clearedVolumeSolar;
        return this;
    }

    @JsonProperty("cleared_volume_hydro")
    public List<Double> getClearedVolumeHydro() {
        return clearedVolumeHydro;
    }

    @JsonProperty("cleared_volume_hydro")
    public void setClearedVolumeHydro(List<Double> clearedVolumeHydro) {
        this.clearedVolumeHydro = clearedVolumeHydro;
    }

    public Gdam withClearedVolumeHydro(List<Double> clearedVolumeHydro) {
        this.clearedVolumeHydro = clearedVolumeHydro;
        return this;
    }

    @JsonProperty("cleared_volume_total")
    public List<Double> getClearedVolumeTotal() {
        return clearedVolumeTotal;
    }

    @JsonProperty("cleared_volume_total")
    public void setClearedVolumeTotal(List<Double> clearedVolumeTotal) {
        this.clearedVolumeTotal = clearedVolumeTotal;
    }

    public Gdam withClearedVolumeTotal(List<Double> clearedVolumeTotal) {
        this.clearedVolumeTotal = clearedVolumeTotal;
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

    public Gdam withRealTimeCurtailment(List<Double> realTimeCurtailment) {
        this.realTimeCurtailment = realTimeCurtailment;
        return this;
    }

    @JsonProperty("final_schedule_volume_hydro")
    public List<Double> getFinalScheduleVolumeHydro() {
        return finalScheduleVolumeHydro;
    }

    @JsonProperty("final_schedule_volume_hydro")
    public void setFinalScheduleVolumeHydro(List<Double> finalScheduleVolumeHydro) {
        this.finalScheduleVolumeHydro = finalScheduleVolumeHydro;
    }

    public Gdam withFinalScheduleVolumeHydro(List<Double> finalScheduleVolumeHydro) {
        this.finalScheduleVolumeHydro = finalScheduleVolumeHydro;
        return this;
    }

    @JsonProperty("final_schedule_volume_non_solar")
    public List<Double> getFinalScheduleVolumeNonSolar() {
        return finalScheduleVolumeNonSolar;
    }

    @JsonProperty("final_schedule_volume_non_solar")
    public void setFinalScheduleVolumeNonSolar(List<Double> finalScheduleVolumeNonSolar) {
        this.finalScheduleVolumeNonSolar = finalScheduleVolumeNonSolar;
    }

    public Gdam withFinalScheduleVolumeNonSolar(List<Double> finalScheduleVolumeNonSolar) {
        this.finalScheduleVolumeNonSolar = finalScheduleVolumeNonSolar;
        return this;
    }

    @JsonProperty("final_schedule_volume_solar")
    public List<Double> getFinalScheduleVolumeSolar() {
        return finalScheduleVolumeSolar;
    }

    @JsonProperty("final_schedule_volume_solar")
    public void setFinalScheduleVolumeSolar(List<Double> finalScheduleVolumeSolar) {
        this.finalScheduleVolumeSolar = finalScheduleVolumeSolar;
    }

    public Gdam withFinalScheduleVolumeSolar(List<Double> finalScheduleVolumeSolar) {
        this.finalScheduleVolumeSolar = finalScheduleVolumeSolar;
        return this;
    }

    @JsonProperty("final_schedule_volume_total")
    public List<Double> getFinalScheduleVolumeTotal() {
        return finalScheduleVolumeTotal;
    }

    @JsonProperty("final_schedule_volume_total")
    public void setFinalScheduleVolumeTotal(List<Double> finalScheduleVolumeTotal) {
        this.finalScheduleVolumeTotal = finalScheduleVolumeTotal;
    }

    public Gdam withFinalScheduleVolumeTotal(List<Double> finalScheduleVolumeTotal) {
        this.finalScheduleVolumeTotal = finalScheduleVolumeTotal;
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

    public Gdam withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Gdam.class.getName()).append('@').append(Double.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("clearedVolumeNonSolar");
        sb.append('=');
        sb.append(((this.clearedVolumeNonSolar == null)?"<null>":this.clearedVolumeNonSolar));
        sb.append(',');
        sb.append("clearedVolumeSolar");
        sb.append('=');
        sb.append(((this.clearedVolumeSolar == null)?"<null>":this.clearedVolumeSolar));
        sb.append(',');
        sb.append("clearedVolumeHydro");
        sb.append('=');
        sb.append(((this.clearedVolumeHydro == null)?"<null>":this.clearedVolumeHydro));
        sb.append(',');
        sb.append("clearedVolumeTotal");
        sb.append('=');
        sb.append(((this.clearedVolumeTotal == null)?"<null>":this.clearedVolumeTotal));
        sb.append(',');
        sb.append("realTimeCurtailment");
        sb.append('=');
        sb.append(((this.realTimeCurtailment == null)?"<null>":this.realTimeCurtailment));
        sb.append(',');
        sb.append("finalScheduleVolumeHydro");
        sb.append('=');
        sb.append(((this.finalScheduleVolumeHydro == null)?"<null>":this.finalScheduleVolumeHydro));
        sb.append(',');
        sb.append("finalScheduleVolumeNonSolar");
        sb.append('=');
        sb.append(((this.finalScheduleVolumeNonSolar == null)?"<null>":this.finalScheduleVolumeNonSolar));
        sb.append(',');
        sb.append("finalScheduleVolumeSolar");
        sb.append('=');
        sb.append(((this.finalScheduleVolumeSolar == null)?"<null>":this.finalScheduleVolumeSolar));
        sb.append(',');
        sb.append("finalScheduleVolumeTotal");
        sb.append('=');
        sb.append(((this.finalScheduleVolumeTotal == null)?"<null>":this.finalScheduleVolumeTotal));
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
        result = ((result* 31)+((this.clearedVolumeSolar == null)? 0 :this.clearedVolumeSolar.hashCode()));
        result = ((result* 31)+((this.realTimeCurtailment == null)? 0 :this.realTimeCurtailment.hashCode()));
        result = ((result* 31)+((this.clearedVolumeHydro == null)? 0 :this.clearedVolumeHydro.hashCode()));
        result = ((result* 31)+((this.finalScheduleVolumeTotal == null)? 0 :this.finalScheduleVolumeTotal.hashCode()));
        result = ((result* 31)+((this.clearedVolumeNonSolar == null)? 0 :this.clearedVolumeNonSolar.hashCode()));
        result = ((result* 31)+((this.finalScheduleVolumeSolar == null)? 0 :this.finalScheduleVolumeSolar.hashCode()));
        result = ((result* 31)+((this.clearedVolumeTotal == null)? 0 :this.clearedVolumeTotal.hashCode()));
        result = ((result* 31)+((this.finalScheduleVolumeHydro == null)? 0 :this.finalScheduleVolumeHydro.hashCode()));
        result = ((result* 31)+((this.mcp == null)? 0 :this.mcp.hashCode()));
        result = ((result* 31)+((this.finalScheduleVolumeNonSolar == null)? 0 :this.finalScheduleVolumeNonSolar.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.congestion == null)? 0 :this.congestion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gdam) == false) {
            return false;
        }
        Gdam rhs = ((Gdam) other);
        return (((((((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.sellBid == rhs.sellBid)||((this.sellBid!= null)&&this.sellBid.equals(rhs.sellBid))))&&((this.mcv == rhs.mcv)||((this.mcv!= null)&&this.mcv.equals(rhs.mcv))))&&((this.purchaseBid == rhs.purchaseBid)||((this.purchaseBid!= null)&&this.purchaseBid.equals(rhs.purchaseBid))))&&((this.clearedVolumeSolar == rhs.clearedVolumeSolar)||((this.clearedVolumeSolar!= null)&&this.clearedVolumeSolar.equals(rhs.clearedVolumeSolar))))&&((this.realTimeCurtailment == rhs.realTimeCurtailment)||((this.realTimeCurtailment!= null)&&this.realTimeCurtailment.equals(rhs.realTimeCurtailment))))&&((this.clearedVolumeHydro == rhs.clearedVolumeHydro)||((this.clearedVolumeHydro!= null)&&this.clearedVolumeHydro.equals(rhs.clearedVolumeHydro))))&&((this.finalScheduleVolumeTotal == rhs.finalScheduleVolumeTotal)||((this.finalScheduleVolumeTotal!= null)&&this.finalScheduleVolumeTotal.equals(rhs.finalScheduleVolumeTotal))))&&((this.clearedVolumeNonSolar == rhs.clearedVolumeNonSolar)||((this.clearedVolumeNonSolar!= null)&&this.clearedVolumeNonSolar.equals(rhs.clearedVolumeNonSolar))))&&((this.finalScheduleVolumeSolar == rhs.finalScheduleVolumeSolar)||((this.finalScheduleVolumeSolar!= null)&&this.finalScheduleVolumeSolar.equals(rhs.finalScheduleVolumeSolar))))&&((this.clearedVolumeTotal == rhs.clearedVolumeTotal)||((this.clearedVolumeTotal!= null)&&this.clearedVolumeTotal.equals(rhs.clearedVolumeTotal))))&&((this.finalScheduleVolumeHydro == rhs.finalScheduleVolumeHydro)||((this.finalScheduleVolumeHydro!= null)&&this.finalScheduleVolumeHydro.equals(rhs.finalScheduleVolumeHydro))))&&((this.mcp == rhs.mcp)||((this.mcp!= null)&&this.mcp.equals(rhs.mcp))))&&((this.finalScheduleVolumeNonSolar == rhs.finalScheduleVolumeNonSolar)||((this.finalScheduleVolumeNonSolar!= null)&&this.finalScheduleVolumeNonSolar.equals(rhs.finalScheduleVolumeNonSolar))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.congestion == rhs.congestion)||((this.congestion!= null)&&this.congestion.equals(rhs.congestion))));
    }

}
