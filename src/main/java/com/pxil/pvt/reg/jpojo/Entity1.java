
package com.pxil.pvt.reg.jpojo;


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
    "DAM_buy",
    "DAM_sell",
    "RTM_buy",
    "RTM_sell",
    "GDAM_solar_buy",
    "GDAM_solar_sell",
    "GDAM_non_solar_buy",
    "GDAM_non_solar_sell",
    "GDAM_hydro_buy",
    "GDAM_hydro_sell",
    "GDAM_total_buy",
    "GDAM_total_sell",
    "TAM_buy",
    "TAM_sell",
    "GTAM_solar_buy",
    "GTAM_solar_sell",
    "GTAM_non_solar_buy",
    "GTAM_non_solar_sell",
    "GTAM_hydro_buy",
    "GTAM_hydro_sell",
    "GTAM_total_buy",
    "GTAM_total_sell",
    "Intraday_buy",
    "Intraday_sell",
    "DAC_buy",
    "W3"
})
@Generated("jsonschema2pojo")
public class Entity1 {

    @JsonProperty("DAM_buy")
    private String dAMBuy;
    @JsonProperty("DAM_sell")
    private String dAMSell;
    @JsonProperty("RTM_buy")
    private String rTMBuy;
    @JsonProperty("RTM_sell")
    private String rTMSell;
    @JsonProperty("GDAM_solar_buy")
    private String gDAMSolarBuy;
    @JsonProperty("GDAM_solar_sell")
    private String gDAMSolarSell;
    @JsonProperty("GDAM_non_solar_buy")
    private String gDAMNonSolarBuy;
    @JsonProperty("GDAM_non_solar_sell")
    private String gDAMNonSolarSell;
    @JsonProperty("GDAM_hydro_buy")
    private String gDAMHydroBuy;
    @JsonProperty("GDAM_hydro_sell")
    private String gDAMHydroSell;
    @JsonProperty("GDAM_total_buy")
    private String gDAMTotalBuy;
    @JsonProperty("GDAM_total_sell")
    private String gDAMTotalSell;
    @JsonProperty("TAM_buy")
    private String tAMBuy;
    @JsonProperty("TAM_sell")
    private String tAMSell;
    @JsonProperty("GTAM_solar_buy")
    private String gTAMSolarBuy;
    @JsonProperty("GTAM_solar_sell")
    private String gTAMSolarSell;
    @JsonProperty("GTAM_non_solar_buy")
    private String gTAMNonSolarBuy;
    @JsonProperty("GTAM_non_solar_sell")
    private String gTAMNonSolarSell;
    @JsonProperty("GTAM_hydro_buy")
    private String gTAMHydroBuy;
    @JsonProperty("GTAM_hydro_sell")
    private String gTAMHydroSell;
    @JsonProperty("GTAM_total_buy")
    private String gTAMTotalBuy;
    @JsonProperty("GTAM_total_sell")
    private String gTAMTotalSell;
    @JsonProperty("Intraday_buy")
    private String intradayBuy;
    @JsonProperty("Intraday_sell")
    private String intradaySell;
    @JsonProperty("DAC_buy")
    private String dACBuy;
    @JsonProperty("W3")
    private List<Integer> w3 = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DAM_buy")
    public String getDAMBuy() {
        return dAMBuy;
    }

    @JsonProperty("DAM_buy")
    public void setDAMBuy(String dAMBuy) {
        this.dAMBuy = dAMBuy;
    }

    public Entity1 withDAMBuy(String dAMBuy) {
        this.dAMBuy = dAMBuy;
        return this;
    }

    @JsonProperty("DAM_sell")
    public String getDAMSell() {
        return dAMSell;
    }

    @JsonProperty("DAM_sell")
    public void setDAMSell(String dAMSell) {
        this.dAMSell = dAMSell;
    }

    public Entity1 withDAMSell(String dAMSell) {
        this.dAMSell = dAMSell;
        return this;
    }

    @JsonProperty("RTM_buy")
    public String getRTMBuy() {
        return rTMBuy;
    }

    @JsonProperty("RTM_buy")
    public void setRTMBuy(String rTMBuy) {
        this.rTMBuy = rTMBuy;
    }

    public Entity1 withRTMBuy(String rTMBuy) {
        this.rTMBuy = rTMBuy;
        return this;
    }

    @JsonProperty("RTM_sell")
    public String getRTMSell() {
        return rTMSell;
    }

    @JsonProperty("RTM_sell")
    public void setRTMSell(String rTMSell) {
        this.rTMSell = rTMSell;
    }

    public Entity1 withRTMSell(String rTMSell) {
        this.rTMSell = rTMSell;
        return this;
    }

    @JsonProperty("GDAM_solar_buy")
    public String getGDAMSolarBuy() {
        return gDAMSolarBuy;
    }

    @JsonProperty("GDAM_solar_buy")
    public void setGDAMSolarBuy(String gDAMSolarBuy) {
        this.gDAMSolarBuy = gDAMSolarBuy;
    }

    public Entity1 withGDAMSolarBuy(String gDAMSolarBuy) {
        this.gDAMSolarBuy = gDAMSolarBuy;
        return this;
    }

    @JsonProperty("GDAM_solar_sell")
    public String getGDAMSolarSell() {
        return gDAMSolarSell;
    }

    @JsonProperty("GDAM_solar_sell")
    public void setGDAMSolarSell(String gDAMSolarSell) {
        this.gDAMSolarSell = gDAMSolarSell;
    }

    public Entity1 withGDAMSolarSell(String gDAMSolarSell) {
        this.gDAMSolarSell = gDAMSolarSell;
        return this;
    }

    @JsonProperty("GDAM_non_solar_buy")
    public String getGDAMNonSolarBuy() {
        return gDAMNonSolarBuy;
    }

    @JsonProperty("GDAM_non_solar_buy")
    public void setGDAMNonSolarBuy(String gDAMNonSolarBuy) {
        this.gDAMNonSolarBuy = gDAMNonSolarBuy;
    }

    public Entity1 withGDAMNonSolarBuy(String gDAMNonSolarBuy) {
        this.gDAMNonSolarBuy = gDAMNonSolarBuy;
        return this;
    }

    @JsonProperty("GDAM_non_solar_sell")
    public String getGDAMNonSolarSell() {
        return gDAMNonSolarSell;
    }

    @JsonProperty("GDAM_non_solar_sell")
    public void setGDAMNonSolarSell(String gDAMNonSolarSell) {
        this.gDAMNonSolarSell = gDAMNonSolarSell;
    }

    public Entity1 withGDAMNonSolarSell(String gDAMNonSolarSell) {
        this.gDAMNonSolarSell = gDAMNonSolarSell;
        return this;
    }

    @JsonProperty("GDAM_hydro_buy")
    public String getGDAMHydroBuy() {
        return gDAMHydroBuy;
    }

    @JsonProperty("GDAM_hydro_buy")
    public void setGDAMHydroBuy(String gDAMHydroBuy) {
        this.gDAMHydroBuy = gDAMHydroBuy;
    }

    public Entity1 withGDAMHydroBuy(String gDAMHydroBuy) {
        this.gDAMHydroBuy = gDAMHydroBuy;
        return this;
    }

    @JsonProperty("GDAM_hydro_sell")
    public String getGDAMHydroSell() {
        return gDAMHydroSell;
    }

    @JsonProperty("GDAM_hydro_sell")
    public void setGDAMHydroSell(String gDAMHydroSell) {
        this.gDAMHydroSell = gDAMHydroSell;
    }

    public Entity1 withGDAMHydroSell(String gDAMHydroSell) {
        this.gDAMHydroSell = gDAMHydroSell;
        return this;
    }

    @JsonProperty("GDAM_total_buy")
    public String getGDAMTotalBuy() {
        return gDAMTotalBuy;
    }

    @JsonProperty("GDAM_total_buy")
    public void setGDAMTotalBuy(String gDAMTotalBuy) {
        this.gDAMTotalBuy = gDAMTotalBuy;
    }

    public Entity1 withGDAMTotalBuy(String gDAMTotalBuy) {
        this.gDAMTotalBuy = gDAMTotalBuy;
        return this;
    }

    @JsonProperty("GDAM_total_sell")
    public String getGDAMTotalSell() {
        return gDAMTotalSell;
    }

    @JsonProperty("GDAM_total_sell")
    public void setGDAMTotalSell(String gDAMTotalSell) {
        this.gDAMTotalSell = gDAMTotalSell;
    }

    public Entity1 withGDAMTotalSell(String gDAMTotalSell) {
        this.gDAMTotalSell = gDAMTotalSell;
        return this;
    }

    @JsonProperty("TAM_buy")
    public String getTAMBuy() {
        return tAMBuy;
    }

    @JsonProperty("TAM_buy")
    public void setTAMBuy(String tAMBuy) {
        this.tAMBuy = tAMBuy;
    }

    public Entity1 withTAMBuy(String tAMBuy) {
        this.tAMBuy = tAMBuy;
        return this;
    }

    @JsonProperty("TAM_sell")
    public String getTAMSell() {
        return tAMSell;
    }

    @JsonProperty("TAM_sell")
    public void setTAMSell(String tAMSell) {
        this.tAMSell = tAMSell;
    }

    public Entity1 withTAMSell(String tAMSell) {
        this.tAMSell = tAMSell;
        return this;
    }

    @JsonProperty("GTAM_solar_buy")
    public String getGTAMSolarBuy() {
        return gTAMSolarBuy;
    }

    @JsonProperty("GTAM_solar_buy")
    public void setGTAMSolarBuy(String gTAMSolarBuy) {
        this.gTAMSolarBuy = gTAMSolarBuy;
    }

    public Entity1 withGTAMSolarBuy(String gTAMSolarBuy) {
        this.gTAMSolarBuy = gTAMSolarBuy;
        return this;
    }

    @JsonProperty("GTAM_solar_sell")
    public String getGTAMSolarSell() {
        return gTAMSolarSell;
    }

    @JsonProperty("GTAM_solar_sell")
    public void setGTAMSolarSell(String gTAMSolarSell) {
        this.gTAMSolarSell = gTAMSolarSell;
    }

    public Entity1 withGTAMSolarSell(String gTAMSolarSell) {
        this.gTAMSolarSell = gTAMSolarSell;
        return this;
    }

    @JsonProperty("GTAM_non_solar_buy")
    public String getGTAMNonSolarBuy() {
        return gTAMNonSolarBuy;
    }

    @JsonProperty("GTAM_non_solar_buy")
    public void setGTAMNonSolarBuy(String gTAMNonSolarBuy) {
        this.gTAMNonSolarBuy = gTAMNonSolarBuy;
    }

    public Entity1 withGTAMNonSolarBuy(String gTAMNonSolarBuy) {
        this.gTAMNonSolarBuy = gTAMNonSolarBuy;
        return this;
    }

    @JsonProperty("GTAM_non_solar_sell")
    public String getGTAMNonSolarSell() {
        return gTAMNonSolarSell;
    }

    @JsonProperty("GTAM_non_solar_sell")
    public void setGTAMNonSolarSell(String gTAMNonSolarSell) {
        this.gTAMNonSolarSell = gTAMNonSolarSell;
    }

    public Entity1 withGTAMNonSolarSell(String gTAMNonSolarSell) {
        this.gTAMNonSolarSell = gTAMNonSolarSell;
        return this;
    }

    @JsonProperty("GTAM_hydro_buy")
    public String getGTAMHydroBuy() {
        return gTAMHydroBuy;
    }

    @JsonProperty("GTAM_hydro_buy")
    public void setGTAMHydroBuy(String gTAMHydroBuy) {
        this.gTAMHydroBuy = gTAMHydroBuy;
    }

    public Entity1 withGTAMHydroBuy(String gTAMHydroBuy) {
        this.gTAMHydroBuy = gTAMHydroBuy;
        return this;
    }

    @JsonProperty("GTAM_hydro_sell")
    public String getGTAMHydroSell() {
        return gTAMHydroSell;
    }

    @JsonProperty("GTAM_hydro_sell")
    public void setGTAMHydroSell(String gTAMHydroSell) {
        this.gTAMHydroSell = gTAMHydroSell;
    }

    public Entity1 withGTAMHydroSell(String gTAMHydroSell) {
        this.gTAMHydroSell = gTAMHydroSell;
        return this;
    }

    @JsonProperty("GTAM_total_buy")
    public String getGTAMTotalBuy() {
        return gTAMTotalBuy;
    }

    @JsonProperty("GTAM_total_buy")
    public void setGTAMTotalBuy(String gTAMTotalBuy) {
        this.gTAMTotalBuy = gTAMTotalBuy;
    }

    public Entity1 withGTAMTotalBuy(String gTAMTotalBuy) {
        this.gTAMTotalBuy = gTAMTotalBuy;
        return this;
    }

    @JsonProperty("GTAM_total_sell")
    public String getGTAMTotalSell() {
        return gTAMTotalSell;
    }

    @JsonProperty("GTAM_total_sell")
    public void setGTAMTotalSell(String gTAMTotalSell) {
        this.gTAMTotalSell = gTAMTotalSell;
    }

    public Entity1 withGTAMTotalSell(String gTAMTotalSell) {
        this.gTAMTotalSell = gTAMTotalSell;
        return this;
    }

    @JsonProperty("Intraday_buy")
    public String getIntradayBuy() {
        return intradayBuy;
    }

    @JsonProperty("Intraday_buy")
    public void setIntradayBuy(String intradayBuy) {
        this.intradayBuy = intradayBuy;
    }

    public Entity1 withIntradayBuy(String intradayBuy) {
        this.intradayBuy = intradayBuy;
        return this;
    }

    @JsonProperty("Intraday_sell")
    public String getIntradaySell() {
        return intradaySell;
    }

    @JsonProperty("Intraday_sell")
    public void setIntradaySell(String intradaySell) {
        this.intradaySell = intradaySell;
    }

    public Entity1 withIntradaySell(String intradaySell) {
        this.intradaySell = intradaySell;
        return this;
    }

    @JsonProperty("DAC_buy")
    public String getDACBuy() {
        return dACBuy;
    }

    @JsonProperty("DAC_buy")
    public void setDACBuy(String dACBuy) {
        this.dACBuy = dACBuy;
    }

    public Entity1 withDACBuy(String dACBuy) {
        this.dACBuy = dACBuy;
        return this;
    }

    @JsonProperty("W3")
    public List<Integer> getW3() {
        return w3;
    }

    @JsonProperty("W3")
    public void setW3(List<Integer> w3) {
        this.w3 = w3;
    }

    public Entity1 withW3(List<Integer> w3) {
        this.w3 = w3;
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

    public Entity1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Entity1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dAMBuy");
        sb.append('=');
        sb.append(((this.dAMBuy == null)?"<null>":this.dAMBuy));
        sb.append(',');
        sb.append("dAMSell");
        sb.append('=');
        sb.append(((this.dAMSell == null)?"<null>":this.dAMSell));
        sb.append(',');
        sb.append("rTMBuy");
        sb.append('=');
        sb.append(((this.rTMBuy == null)?"<null>":this.rTMBuy));
        sb.append(',');
        sb.append("rTMSell");
        sb.append('=');
        sb.append(((this.rTMSell == null)?"<null>":this.rTMSell));
        sb.append(',');
        sb.append("gDAMSolarBuy");
        sb.append('=');
        sb.append(((this.gDAMSolarBuy == null)?"<null>":this.gDAMSolarBuy));
        sb.append(',');
        sb.append("gDAMSolarSell");
        sb.append('=');
        sb.append(((this.gDAMSolarSell == null)?"<null>":this.gDAMSolarSell));
        sb.append(',');
        sb.append("gDAMNonSolarBuy");
        sb.append('=');
        sb.append(((this.gDAMNonSolarBuy == null)?"<null>":this.gDAMNonSolarBuy));
        sb.append(',');
        sb.append("gDAMNonSolarSell");
        sb.append('=');
        sb.append(((this.gDAMNonSolarSell == null)?"<null>":this.gDAMNonSolarSell));
        sb.append(',');
        sb.append("gDAMHydroBuy");
        sb.append('=');
        sb.append(((this.gDAMHydroBuy == null)?"<null>":this.gDAMHydroBuy));
        sb.append(',');
        sb.append("gDAMHydroSell");
        sb.append('=');
        sb.append(((this.gDAMHydroSell == null)?"<null>":this.gDAMHydroSell));
        sb.append(',');
        sb.append("gDAMTotalBuy");
        sb.append('=');
        sb.append(((this.gDAMTotalBuy == null)?"<null>":this.gDAMTotalBuy));
        sb.append(',');
        sb.append("gDAMTotalSell");
        sb.append('=');
        sb.append(((this.gDAMTotalSell == null)?"<null>":this.gDAMTotalSell));
        sb.append(',');
        sb.append("tAMBuy");
        sb.append('=');
        sb.append(((this.tAMBuy == null)?"<null>":this.tAMBuy));
        sb.append(',');
        sb.append("tAMSell");
        sb.append('=');
        sb.append(((this.tAMSell == null)?"<null>":this.tAMSell));
        sb.append(',');
        sb.append("gTAMSolarBuy");
        sb.append('=');
        sb.append(((this.gTAMSolarBuy == null)?"<null>":this.gTAMSolarBuy));
        sb.append(',');
        sb.append("gTAMSolarSell");
        sb.append('=');
        sb.append(((this.gTAMSolarSell == null)?"<null>":this.gTAMSolarSell));
        sb.append(',');
        sb.append("gTAMNonSolarBuy");
        sb.append('=');
        sb.append(((this.gTAMNonSolarBuy == null)?"<null>":this.gTAMNonSolarBuy));
        sb.append(',');
        sb.append("gTAMNonSolarSell");
        sb.append('=');
        sb.append(((this.gTAMNonSolarSell == null)?"<null>":this.gTAMNonSolarSell));
        sb.append(',');
        sb.append("gTAMHydroBuy");
        sb.append('=');
        sb.append(((this.gTAMHydroBuy == null)?"<null>":this.gTAMHydroBuy));
        sb.append(',');
        sb.append("gTAMHydroSell");
        sb.append('=');
        sb.append(((this.gTAMHydroSell == null)?"<null>":this.gTAMHydroSell));
        sb.append(',');
        sb.append("gTAMTotalBuy");
        sb.append('=');
        sb.append(((this.gTAMTotalBuy == null)?"<null>":this.gTAMTotalBuy));
        sb.append(',');
        sb.append("gTAMTotalSell");
        sb.append('=');
        sb.append(((this.gTAMTotalSell == null)?"<null>":this.gTAMTotalSell));
        sb.append(',');
        sb.append("intradayBuy");
        sb.append('=');
        sb.append(((this.intradayBuy == null)?"<null>":this.intradayBuy));
        sb.append(',');
        sb.append("intradaySell");
        sb.append('=');
        sb.append(((this.intradaySell == null)?"<null>":this.intradaySell));
        sb.append(',');
        sb.append("dACBuy");
        sb.append('=');
        sb.append(((this.dACBuy == null)?"<null>":this.dACBuy));
        sb.append(',');
        sb.append("w3");
        sb.append('=');
        sb.append(((this.w3 == null)?"<null>":this.w3));
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
        result = ((result* 31)+((this.gDAMHydroSell == null)? 0 :this.gDAMHydroSell.hashCode()));
        result = ((result* 31)+((this.gDAMHydroBuy == null)? 0 :this.gDAMHydroBuy.hashCode()));
        result = ((result* 31)+((this.intradaySell == null)? 0 :this.intradaySell.hashCode()));
        result = ((result* 31)+((this.dAMBuy == null)? 0 :this.dAMBuy.hashCode()));
        result = ((result* 31)+((this.gTAMHydroBuy == null)? 0 :this.gTAMHydroBuy.hashCode()));
        result = ((result* 31)+((this.gTAMTotalBuy == null)? 0 :this.gTAMTotalBuy.hashCode()));
        result = ((result* 31)+((this.gDAMTotalBuy == null)? 0 :this.gDAMTotalBuy.hashCode()));
        result = ((result* 31)+((this.gTAMTotalSell == null)? 0 :this.gTAMTotalSell.hashCode()));
        result = ((result* 31)+((this.gDAMTotalSell == null)? 0 :this.gDAMTotalSell.hashCode()));
        result = ((result* 31)+((this.rTMBuy == null)? 0 :this.rTMBuy.hashCode()));
        result = ((result* 31)+((this.gTAMNonSolarSell == null)? 0 :this.gTAMNonSolarSell.hashCode()));
        result = ((result* 31)+((this.rTMSell == null)? 0 :this.rTMSell.hashCode()));
        result = ((result* 31)+((this.w3 == null)? 0 :this.w3 .hashCode()));
        result = ((result* 31)+((this.gDAMNonSolarSell == null)? 0 :this.gDAMNonSolarSell.hashCode()));
        result = ((result* 31)+((this.gTAMNonSolarBuy == null)? 0 :this.gTAMNonSolarBuy.hashCode()));
        result = ((result* 31)+((this.gTAMSolarSell == null)? 0 :this.gTAMSolarSell.hashCode()));
        result = ((result* 31)+((this.tAMBuy == null)? 0 :this.tAMBuy.hashCode()));
        result = ((result* 31)+((this.gDAMSolarBuy == null)? 0 :this.gDAMSolarBuy.hashCode()));
        result = ((result* 31)+((this.tAMSell == null)? 0 :this.tAMSell.hashCode()));
        result = ((result* 31)+((this.gTAMSolarBuy == null)? 0 :this.gTAMSolarBuy.hashCode()));
        result = ((result* 31)+((this.gDAMNonSolarBuy == null)? 0 :this.gDAMNonSolarBuy.hashCode()));
        result = ((result* 31)+((this.dACBuy == null)? 0 :this.dACBuy.hashCode()));
        result = ((result* 31)+((this.gTAMHydroSell == null)? 0 :this.gTAMHydroSell.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dAMSell == null)? 0 :this.dAMSell.hashCode()));
        result = ((result* 31)+((this.intradayBuy == null)? 0 :this.intradayBuy.hashCode()));
        result = ((result* 31)+((this.gDAMSolarSell == null)? 0 :this.gDAMSolarSell.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Entity1) == false) {
            return false;
        }
        Entity1 rhs = ((Entity1) other);
        return ((((((((((((((((((((((((((((this.gDAMHydroSell == rhs.gDAMHydroSell)||((this.gDAMHydroSell!= null)&&this.gDAMHydroSell.equals(rhs.gDAMHydroSell)))&&((this.gDAMHydroBuy == rhs.gDAMHydroBuy)||((this.gDAMHydroBuy!= null)&&this.gDAMHydroBuy.equals(rhs.gDAMHydroBuy))))&&((this.intradaySell == rhs.intradaySell)||((this.intradaySell!= null)&&this.intradaySell.equals(rhs.intradaySell))))&&((this.dAMBuy == rhs.dAMBuy)||((this.dAMBuy!= null)&&this.dAMBuy.equals(rhs.dAMBuy))))&&((this.gTAMHydroBuy == rhs.gTAMHydroBuy)||((this.gTAMHydroBuy!= null)&&this.gTAMHydroBuy.equals(rhs.gTAMHydroBuy))))&&((this.gTAMTotalBuy == rhs.gTAMTotalBuy)||((this.gTAMTotalBuy!= null)&&this.gTAMTotalBuy.equals(rhs.gTAMTotalBuy))))&&((this.gDAMTotalBuy == rhs.gDAMTotalBuy)||((this.gDAMTotalBuy!= null)&&this.gDAMTotalBuy.equals(rhs.gDAMTotalBuy))))&&((this.gTAMTotalSell == rhs.gTAMTotalSell)||((this.gTAMTotalSell!= null)&&this.gTAMTotalSell.equals(rhs.gTAMTotalSell))))&&((this.gDAMTotalSell == rhs.gDAMTotalSell)||((this.gDAMTotalSell!= null)&&this.gDAMTotalSell.equals(rhs.gDAMTotalSell))))&&((this.rTMBuy == rhs.rTMBuy)||((this.rTMBuy!= null)&&this.rTMBuy.equals(rhs.rTMBuy))))&&((this.gTAMNonSolarSell == rhs.gTAMNonSolarSell)||((this.gTAMNonSolarSell!= null)&&this.gTAMNonSolarSell.equals(rhs.gTAMNonSolarSell))))&&((this.rTMSell == rhs.rTMSell)||((this.rTMSell!= null)&&this.rTMSell.equals(rhs.rTMSell))))&&((this.w3 == rhs.w3)||((this.w3 != null)&&this.w3 .equals(rhs.w3))))&&((this.gDAMNonSolarSell == rhs.gDAMNonSolarSell)||((this.gDAMNonSolarSell!= null)&&this.gDAMNonSolarSell.equals(rhs.gDAMNonSolarSell))))&&((this.gTAMNonSolarBuy == rhs.gTAMNonSolarBuy)||((this.gTAMNonSolarBuy!= null)&&this.gTAMNonSolarBuy.equals(rhs.gTAMNonSolarBuy))))&&((this.gTAMSolarSell == rhs.gTAMSolarSell)||((this.gTAMSolarSell!= null)&&this.gTAMSolarSell.equals(rhs.gTAMSolarSell))))&&((this.tAMBuy == rhs.tAMBuy)||((this.tAMBuy!= null)&&this.tAMBuy.equals(rhs.tAMBuy))))&&((this.gDAMSolarBuy == rhs.gDAMSolarBuy)||((this.gDAMSolarBuy!= null)&&this.gDAMSolarBuy.equals(rhs.gDAMSolarBuy))))&&((this.tAMSell == rhs.tAMSell)||((this.tAMSell!= null)&&this.tAMSell.equals(rhs.tAMSell))))&&((this.gTAMSolarBuy == rhs.gTAMSolarBuy)||((this.gTAMSolarBuy!= null)&&this.gTAMSolarBuy.equals(rhs.gTAMSolarBuy))))&&((this.gDAMNonSolarBuy == rhs.gDAMNonSolarBuy)||((this.gDAMNonSolarBuy!= null)&&this.gDAMNonSolarBuy.equals(rhs.gDAMNonSolarBuy))))&&((this.dACBuy == rhs.dACBuy)||((this.dACBuy!= null)&&this.dACBuy.equals(rhs.dACBuy))))&&((this.gTAMHydroSell == rhs.gTAMHydroSell)||((this.gTAMHydroSell!= null)&&this.gTAMHydroSell.equals(rhs.gTAMHydroSell))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dAMSell == rhs.dAMSell)||((this.dAMSell!= null)&&this.dAMSell.equals(rhs.dAMSell))))&&((this.intradayBuy == rhs.intradayBuy)||((this.intradayBuy!= null)&&this.intradayBuy.equals(rhs.intradayBuy))))&&((this.gDAMSolarSell == rhs.gDAMSolarSell)||((this.gDAMSolarSell!= null)&&this.gDAMSolarSell.equals(rhs.gDAMSolarSell))));
    }

}
