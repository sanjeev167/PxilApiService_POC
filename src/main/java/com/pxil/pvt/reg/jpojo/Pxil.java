
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
    "no_days",
    "DAM",//1
    "RTM",//2
    "GDAM",//3
    "HPDAM",//4
    "Intraday_Conventional",//5
    "Intraday_Solar",//6
    "Intraday_Non_Solar",//7
    "Intraday_Hydro",//8
    "DAC_Conventional",//9
    "DAC_Solar",//10
    "DAC_Non_Solar",//11
    "DAC_Hydro",//12
    "TAM",//13
    "GTAM_Solar",//14
    "GTAM_Non_Solar",//15
    "GTAM_Hydro",//16
    "ACP_RTM",//17
    "ACP_DAM",//18
    "ACP_GDAM",//19
    "ACP_HPDAM" //20
})
@Generated("jsonschema2pojo")
public class Pxil {

    @JsonProperty("no_days")
    private Integer noDays;
    @JsonProperty("DAM")
    private List<Dam> dam = new ArrayList<Dam>();
    @JsonProperty("RTM")
    private List<Rtm> rtm = new ArrayList<Rtm>();
    @JsonProperty("GDAM")
    private List<Gdam> gdam = new ArrayList<Gdam>();
    @JsonProperty("HPDAM")
    private List<Hpdam> hpdam = new ArrayList<Hpdam>();
    @JsonProperty("Intraday_Conventional")
    private List<IntradayConventional> intradayConventional = new ArrayList<IntradayConventional>();
    @JsonProperty("Intraday_Solar")
    private List<IntradaySolar> intradaySolar = new ArrayList<IntradaySolar>();
    @JsonProperty("Intraday_Non_Solar")
    private List<IntradayNonSolar> intradayNonSolar = new ArrayList<IntradayNonSolar>();
    @JsonProperty("Intraday_Hydro")
    private List<IntradayHydro> intradayHydro = new ArrayList<IntradayHydro>();
    @JsonProperty("DAC_Conventional")
    private List<DACConventional> dACConventional = new ArrayList<DACConventional>();
    @JsonProperty("DAC_Solar")
    private List<DACSolar> dACSolar = new ArrayList<DACSolar>();
    @JsonProperty("DAC_Non_Solar")
    private List<DACNonSolar> dACNonSolar = new ArrayList<DACNonSolar>();
    @JsonProperty("DAC_Hydro")
    private List<DACHydro> dACHydro = new ArrayList<DACHydro>();
    @JsonProperty("TAM")
    private List<Tam> tam = new ArrayList<Tam>();
    @JsonProperty("GTAM_Solar")
    private List<GTAMSolar> gTAMSolar = new ArrayList<GTAMSolar>();
    @JsonProperty("GTAM_Non_Solar")
    private List<GTAMNonSolar> gTAMNonSolar = new ArrayList<GTAMNonSolar>();
    @JsonProperty("GTAM_Hydro")
    private List<GTAMHydro> gTAMHydro = new ArrayList<GTAMHydro>();
    @JsonProperty("ACP_RTM")
    private List<AcpRtm> acpRtm = new ArrayList<AcpRtm>();
    @JsonProperty("ACP_DAM")
    private List<AcpDam> acpDam = new ArrayList<AcpDam>();
    @JsonProperty("ACP_GDAM")
    private List<AcpGdam> acpGdam = new ArrayList<AcpGdam>();
    @JsonProperty("ACP_HPDAM")
    private List<AcpHpdam> acpHpdam = new ArrayList<AcpHpdam>(); 
    
   // @JsonProperty("Entity_wise_exchange_data")
    @JsonIgnore
    private List<EntityWiseExchangeDatum> entityWiseExchangeData = new ArrayList<EntityWiseExchangeDatum>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("no_days")
    public Integer getNoDays() {
        return noDays;
    }

    @JsonProperty("no_days")
    public void setNoDays(Integer noDays) {
        this.noDays = noDays;
    }

    public Pxil withNoDays(Integer noDays) {
        this.noDays = noDays;
        return this;
    }

    @JsonProperty("DAM")
    public List<Dam> getDam() {
        return dam;
    }

    @JsonProperty("DAM")
    public void setDam(List<Dam> dam) {
        this.dam = dam;
    }

    public Pxil withDam(List<Dam> dam) {
        this.dam = dam;
        return this;
    }

    @JsonProperty("RTM")
    public List<Rtm> getRtm() {
        return rtm;
    }

    @JsonProperty("RTM")
    public void setRtm(List<Rtm> rtm) {
        this.rtm = rtm;
    }

    public Pxil withRtm(List<Rtm> rtm) {
        this.rtm = rtm;
        return this;
    }

    @JsonProperty("GDAM")
    public List<Gdam> getGdam() {
        return gdam;
    }

    @JsonProperty("GDAM")
    public void setGdam(List<Gdam> gdam) {
        this.gdam = gdam;
    }

    public Pxil withGdam(List<Gdam> gdam) {
        this.gdam = gdam;
        return this;
    }

    @JsonProperty("HPDAM")
    public List<Hpdam> getHpdam() {
        return hpdam;
    }

    @JsonProperty("HPDAM")
    public void setHpdam(List<Hpdam> hpdam) {
        this.hpdam = hpdam;
    }

    public Pxil withHpdam(List<Hpdam> hpdam) {
        this.hpdam = hpdam;
        return this;
    }

    @JsonProperty("Intraday_Conventional")
    public List<IntradayConventional> getIntradayConventional() {
        return intradayConventional;
    }

    @JsonProperty("Intraday_Conventional")
    public void setIntradayConventional(List<IntradayConventional> intradayConventional) {
        this.intradayConventional = intradayConventional;
    }

    public Pxil withIntradayConventional(List<IntradayConventional> intradayConventional) {
        this.intradayConventional = intradayConventional;
        return this;
    }

    @JsonProperty("Intraday_Solar")
    public List<IntradaySolar> getIntradaySolar() {
        return intradaySolar;
    }

    @JsonProperty("Intraday_Solar")
    public void setIntradaySolar(List<IntradaySolar> intradaySolar) {
        this.intradaySolar = intradaySolar;
    }

    public Pxil withIntradaySolar(List<IntradaySolar> intradaySolar) {
        this.intradaySolar = intradaySolar;
        return this;
    }

    @JsonProperty("Intraday_Non_Solar")
    public List<IntradayNonSolar> getIntradayNonSolar() {
        return intradayNonSolar;
    }

    @JsonProperty("Intraday_Non_Solar")
    public void setIntradayNonSolar(List<IntradayNonSolar> intradayNonSolar) {
        this.intradayNonSolar = intradayNonSolar;
    }

    public Pxil withIntradayNonSolar(List<IntradayNonSolar> intradayNonSolar) {
        this.intradayNonSolar = intradayNonSolar;
        return this;
    }

    @JsonProperty("Intraday_Hydro")
    public List<IntradayHydro> getIntradayHydro() {
        return intradayHydro;
    }

    @JsonProperty("Intraday_Hydro")
    public void setIntradayHydro(List<IntradayHydro> intradayHydro) {
        this.intradayHydro = intradayHydro;
    }

    public Pxil withIntradayHydro(List<IntradayHydro> intradayHydro) {
        this.intradayHydro = intradayHydro;
        return this;
    }

    @JsonProperty("DAC_Conventional")
    public List<DACConventional> getDACConventional() {
        return dACConventional;
    }

    @JsonProperty("DAC_Conventional")
    public void setDACConventional(List<DACConventional> dACConventional) {
        this.dACConventional = dACConventional;
    }

    public Pxil withDACConventional(List<DACConventional> dACConventional) {
        this.dACConventional = dACConventional;
        return this;
    }

    @JsonProperty("DAC_Solar")
    public List<DACSolar> getDACSolar() {
        return dACSolar;
    }

    @JsonProperty("DAC_Solar")
    public void setDACSolar(List<DACSolar> dACSolar) {
        this.dACSolar = dACSolar;
    }

    public Pxil withDACSolar(List<DACSolar> dACSolar) {
        this.dACSolar = dACSolar;
        return this;
    }

    @JsonProperty("DAC_Non_Solar")
    public List<DACNonSolar> getDACNonSolar() {
        return dACNonSolar;
    }

    @JsonProperty("DAC_Non_Solar")
    public void setDACNonSolar(List<DACNonSolar> dACNonSolar) {
        this.dACNonSolar = dACNonSolar;
    }

    public Pxil withDACNonSolar(List<DACNonSolar> dACNonSolar) {
        this.dACNonSolar = dACNonSolar;
        return this;
    }

    @JsonProperty("DAC_Hydro")
    public List<DACHydro> getDACHydro() {
        return dACHydro;
    }

    @JsonProperty("DAC_Hydro")
    public void setDACHydro(List<DACHydro> dACHydro) {
        this.dACHydro = dACHydro;
    }

    public Pxil withDACHydro(List<DACHydro> dACHydro) {
        this.dACHydro = dACHydro;
        return this;
    }

    @JsonProperty("TAM")
    public List<Tam> getTam() {
        return tam;
    }

    @JsonProperty("TAM")
    public void setTam(List<Tam> tam) {
        this.tam = tam;
    }

    public Pxil withTam(List<Tam> tam) {
        this.tam = tam;
        return this;
    }

    @JsonProperty("GTAM_Solar")
    public List<GTAMSolar> getGTAMSolar() {
        return gTAMSolar;
    }

    @JsonProperty("GTAM_Solar")
    public void setGTAMSolar(List<GTAMSolar> gTAMSolar) {
        this.gTAMSolar = gTAMSolar;
    }

    public Pxil withGTAMSolar(List<GTAMSolar> gTAMSolar) {
        this.gTAMSolar = gTAMSolar;
        return this;
    }

    @JsonProperty("GTAM_Non_Solar")
    public List<GTAMNonSolar> getGTAMNonSolar() {
        return gTAMNonSolar;
    }

    @JsonProperty("GTAM_Non_Solar")
    public void setGTAMNonSolar(List<GTAMNonSolar> gTAMNonSolar) {
        this.gTAMNonSolar = gTAMNonSolar;
    }

    public Pxil withGTAMNonSolar(List<GTAMNonSolar> gTAMNonSolar) {
        this.gTAMNonSolar = gTAMNonSolar;
        return this;
    }

    @JsonProperty("GTAM_Hydro")
    public List<GTAMHydro> getGTAMHydro() {
        return gTAMHydro;
    }

    @JsonProperty("GTAM_Hydro")
    public void setGTAMHydro(List<GTAMHydro> gTAMHydro) {
        this.gTAMHydro = gTAMHydro;
    }

    public Pxil withGTAMHydro(List<GTAMHydro> gTAMHydro) {
        this.gTAMHydro = gTAMHydro;
        return this;
    }

    @JsonProperty("ACP_RTM")
    public List<AcpRtm> getAcpRtm() {
        return acpRtm;
    }

    @JsonProperty("ACP_RTM")
    public void setAcpRtm(List<AcpRtm> acpRtm) {
        this.acpRtm = acpRtm;
    }

    public Pxil withAcpRtm(List<AcpRtm> acpRtm) {
        this.acpRtm = acpRtm;
        return this;
    }

    @JsonProperty("ACP_DAM")
    public List<AcpDam> getAcpDam() {
        return acpDam;
    }

    @JsonProperty("ACP_DAM")
    public void setAcpDam(List<AcpDam> acpDam) {
        this.acpDam = acpDam;
    }

    public Pxil withAcpDam(List<AcpDam> acpDam) {
        this.acpDam = acpDam;
        return this;
    }

    @JsonProperty("ACP_GDAM")
    public List<AcpGdam> getAcpGdam() {
        return acpGdam;
    }

    @JsonProperty("ACP_GDAM")
    public void setAcpGdam(List<AcpGdam> acpGdam) {
        this.acpGdam = acpGdam;
    }

    public Pxil withAcpGdam(List<AcpGdam> acpGdam) {
        this.acpGdam = acpGdam;
        return this;
    }

    @JsonProperty("ACP_HPDAM")
    public List<AcpHpdam> getAcpHpdam() {
        return acpHpdam;
    }

    @JsonProperty("ACP_HPDAM")
    public void setAcpHpdam(List<AcpHpdam> acpHpdam) {
        this.acpHpdam = acpHpdam;
    }

    public Pxil withAcpHpdam(List<AcpHpdam> acpHpdam) {
        this.acpHpdam = acpHpdam;
        return this;
    }
    
    @JsonIgnore
    @JsonProperty("Entity_wise_exchange_data")
    public List<EntityWiseExchangeDatum> getEntityWiseExchangeData() {
        return entityWiseExchangeData;
    }
    @JsonIgnore
    @JsonProperty("Entity_wise_exchange_data")
    public void setEntityWiseExchangeData(List<EntityWiseExchangeDatum> entityWiseExchangeData) {
        this.entityWiseExchangeData = entityWiseExchangeData;
    }

    public Pxil withEntityWiseExchangeData(List<EntityWiseExchangeDatum> entityWiseExchangeData) {
        this.entityWiseExchangeData = entityWiseExchangeData;
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
        sb.append(Pxil.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("noDays");
        sb.append('=');
        sb.append(((this.noDays == null)?"<null>":this.noDays));
        sb.append(',');
        sb.append("dam");
        sb.append('=');
        sb.append(((this.dam == null)?"<null>":this.dam));
        sb.append(',');
        sb.append("rtm");
        sb.append('=');
        sb.append(((this.rtm == null)?"<null>":this.rtm));
        sb.append(',');
        sb.append("gdam");
        sb.append('=');
        sb.append(((this.gdam == null)?"<null>":this.gdam));
        sb.append(',');
        sb.append("hpdam");
        sb.append('=');
        sb.append(((this.hpdam == null)?"<null>":this.hpdam));
        sb.append(',');
        sb.append("intradayConventional");
        sb.append('=');
        sb.append(((this.intradayConventional == null)?"<null>":this.intradayConventional));
        sb.append(',');
        sb.append("intradaySolar");
        sb.append('=');
        sb.append(((this.intradaySolar == null)?"<null>":this.intradaySolar));
        sb.append(',');
        sb.append("intradayNonSolar");
        sb.append('=');
        sb.append(((this.intradayNonSolar == null)?"<null>":this.intradayNonSolar));
        sb.append(',');
        sb.append("intradayHydro");
        sb.append('=');
        sb.append(((this.intradayHydro == null)?"<null>":this.intradayHydro));
        sb.append(',');
        sb.append("dACConventional");
        sb.append('=');
        sb.append(((this.dACConventional == null)?"<null>":this.dACConventional));
        sb.append(',');
        sb.append("dACSolar");
        sb.append('=');
        sb.append(((this.dACSolar == null)?"<null>":this.dACSolar));
        sb.append(',');
        sb.append("dACNonSolar");
        sb.append('=');
        sb.append(((this.dACNonSolar == null)?"<null>":this.dACNonSolar));
        sb.append(',');
        sb.append("dACHydro");
        sb.append('=');
        sb.append(((this.dACHydro == null)?"<null>":this.dACHydro));
        sb.append(',');
        sb.append("tam");
        sb.append('=');
        sb.append(((this.tam == null)?"<null>":this.tam));
        sb.append(',');
        sb.append("gTAMSolar");
        sb.append('=');
        sb.append(((this.gTAMSolar == null)?"<null>":this.gTAMSolar));
        sb.append(',');
        sb.append("gTAMNonSolar");
        sb.append('=');
        sb.append(((this.gTAMNonSolar == null)?"<null>":this.gTAMNonSolar));
        sb.append(',');
        sb.append("gTAMHydro");
        sb.append('=');
        sb.append(((this.gTAMHydro == null)?"<null>":this.gTAMHydro));
        sb.append(',');
        sb.append("acpRtm");
        sb.append('=');
        sb.append(((this.acpRtm == null)?"<null>":this.acpRtm));
        sb.append(',');
        sb.append("acpDam");
        sb.append('=');
        sb.append(((this.acpDam == null)?"<null>":this.acpDam));
        sb.append(',');
        sb.append("acpGdam");
        sb.append('=');
        sb.append(((this.acpGdam == null)?"<null>":this.acpGdam));
        sb.append(',');
        sb.append("acpHpdam");
        sb.append('=');
        sb.append(((this.acpGdam == null)?"<null>":this.acpGdam));
        sb.append(',');
        sb.append("entityWiseExchangeData");
        sb.append('=');
        sb.append(((this.entityWiseExchangeData == null)?"<null>":this.entityWiseExchangeData));
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
        result = ((result* 31)+((this.intradayConventional == null)? 0 :this.intradayConventional.hashCode()));
        result = ((result* 31)+((this.tam == null)? 0 :this.tam.hashCode()));
        result = ((result* 31)+((this.intradayHydro == null)? 0 :this.intradayHydro.hashCode()));
        result = ((result* 31)+((this.gTAMSolar == null)? 0 :this.gTAMSolar.hashCode()));
        result = ((result* 31)+((this.gTAMHydro == null)? 0 :this.gTAMHydro.hashCode()));
        result = ((result* 31)+((this.entityWiseExchangeData == null)? 0 :this.entityWiseExchangeData.hashCode()));
        result = ((result* 31)+((this.dACHydro == null)? 0 :this.dACHydro.hashCode()));
        result = ((result* 31)+((this.gTAMNonSolar == null)? 0 :this.gTAMNonSolar.hashCode()));
        result = ((result* 31)+((this.hpdam == null)? 0 :this.hpdam.hashCode()));
        result = ((result* 31)+((this.dACConventional == null)? 0 :this.dACConventional.hashCode()));
        result = ((result* 31)+((this.noDays == null)? 0 :this.noDays.hashCode()));
        result = ((result* 31)+((this.rtm == null)? 0 :this.rtm.hashCode()));
        result = ((result* 31)+((this.intradaySolar == null)? 0 :this.intradaySolar.hashCode()));
        result = ((result* 31)+((this.acpDam == null)? 0 :this.acpDam.hashCode()));
        result = ((result* 31)+((this.acpGdam == null)? 0 :this.acpGdam.hashCode()));
        result = ((result* 31)+((this.acpRtm == null)? 0 :this.acpRtm.hashCode()));
        result = ((result* 31)+((this.dam == null)? 0 :this.dam.hashCode()));
        result = ((result* 31)+((this.dACNonSolar == null)? 0 :this.dACNonSolar.hashCode()));
        result = ((result* 31)+((this.gdam == null)? 0 :this.gdam.hashCode()));
        result = ((result* 31)+((this.hpdam == null)? 0 :this.hpdam.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.intradayNonSolar == null)? 0 :this.intradayNonSolar.hashCode()));
        result = ((result* 31)+((this.dACSolar == null)? 0 :this.dACSolar.hashCode()));
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
        return (((((((((((((((((((((((this.intradayConventional == rhs.intradayConventional)||((this.intradayConventional!= null)&&this.intradayConventional.equals(rhs.intradayConventional)))&&((this.tam == rhs.tam)||((this.tam!= null)&&this.tam.equals(rhs.tam))))&&((this.intradayHydro == rhs.intradayHydro)||((this.intradayHydro!= null)&&this.intradayHydro.equals(rhs.intradayHydro))))&&((this.gTAMSolar == rhs.gTAMSolar)||((this.gTAMSolar!= null)&&this.gTAMSolar.equals(rhs.gTAMSolar))))&&((this.gTAMHydro == rhs.gTAMHydro)||((this.gTAMHydro!= null)&&this.gTAMHydro.equals(rhs.gTAMHydro))))&&((this.entityWiseExchangeData == rhs.entityWiseExchangeData)||((this.entityWiseExchangeData!= null)&&this.entityWiseExchangeData.equals(rhs.entityWiseExchangeData))))&&((this.dACHydro == rhs.dACHydro)||((this.dACHydro!= null)&&this.dACHydro.equals(rhs.dACHydro))))&&((this.gTAMNonSolar == rhs.gTAMNonSolar)||((this.gTAMNonSolar!= null)&&this.gTAMNonSolar.equals(rhs.gTAMNonSolar))))&&((this.hpdam == rhs.hpdam)||((this.hpdam!= null)&&this.hpdam.equals(rhs.hpdam))))&&((this.dACConventional == rhs.dACConventional)||((this.dACConventional!= null)&&this.dACConventional.equals(rhs.dACConventional))))&&((this.noDays == rhs.noDays)||((this.noDays!= null)&&this.noDays.equals(rhs.noDays))))&&((this.rtm == rhs.rtm)||((this.rtm!= null)&&this.rtm.equals(rhs.rtm))))&&((this.intradaySolar == rhs.intradaySolar)||((this.intradaySolar!= null)&&this.intradaySolar.equals(rhs.intradaySolar))))&&((this.acpDam == rhs.acpDam)||((this.acpDam!= null)&&this.acpDam.equals(rhs.acpDam))))&&((this.acpGdam == rhs.acpGdam)||((this.acpGdam!= null)&&this.acpGdam.equals(rhs.acpGdam))))&&((this.acpRtm == rhs.acpRtm)||((this.acpRtm!= null)&&this.acpRtm.equals(rhs.acpRtm))))&&((this.dam == rhs.dam)||((this.dam!= null)&&this.dam.equals(rhs.dam))))&&((this.dACNonSolar == rhs.dACNonSolar)||((this.dACNonSolar!= null)&&this.dACNonSolar.equals(rhs.dACNonSolar))))&&((this.gdam == rhs.gdam)||((this.gdam!= null)&&this.gdam.equals(rhs.gdam))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.intradayNonSolar == rhs.intradayNonSolar)||((this.intradayNonSolar!= null)&&this.intradayNonSolar.equals(rhs.intradayNonSolar))))&&((this.dACSolar == rhs.dACSolar)||((this.dACSolar!= null)&&this.dACSolar.equals(rhs.dACSolar))));
    }

}
