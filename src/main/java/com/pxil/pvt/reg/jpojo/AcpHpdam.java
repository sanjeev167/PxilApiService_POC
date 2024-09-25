
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
    "A1",
    "A2",
    "E1",
    "E2",
    "N1",
    "N2",
    "N3",
    "S1",
    "S2",
    "S3",
    "W1",
    "W2",
    "W3",
    //Include NR.SR,WR separately as they have been included while handling composite area
    "NR",
    "SR",
    "WR"
})
@Generated("jsonschema2pojo")
public class AcpHpdam {

    @JsonProperty("date")
    private String date;
    @JsonProperty("A1")
    private List<Double> a1 = new ArrayList<Double>(Collections.nCopies (96, 0.0));   
    @JsonProperty("A2")
    private List<Double> a2 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("E1")
    private List<Double> e1 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("E2")
    private List<Double> e2 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("N1")
    private List<Double> n1 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("N2")
    private List<Double> n2 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("N3")
    private List<Double> n3 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("S1")
    private List<Double> s1 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("S2")
    private List<Double> s2 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("S3")
    private List<Double> s3 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("W1")
    private List<Double> w1 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("W2")
    private List<Double> w2 = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("W3")
    private List<Double> w3 = new ArrayList<Double>(Collections.nCopies (96, 0.0));    
    
  //Include NR.SR,WR separately as they have been included while handling composite area
    @JsonProperty("NR")
    private List<Double> NR = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("SR")
    private List<Double> SR = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    @JsonProperty("WR")
    private List<Double> WR = new ArrayList<Double>(Collections.nCopies (96, 0.0));
    
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

    public AcpHpdam withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("A1")
    public List<Double> getA1() {
        return a1;
    }

    @JsonProperty("A1")
    public void setA1(List<Double> a1) {
        this.a1 = a1;
    }

    public AcpHpdam withA1(List<Double> a1) {
        this.a1 = a1;
        return this;
    }

    @JsonProperty("A2")
    public List<Double> getA2() {
        return a2;
    }

    @JsonProperty("A2")
    public void setA2(List<Double> a2) {
        this.a2 = a2;
    }

    public AcpHpdam withA2(List<Double> a2) {
        this.a2 = a2;
        return this;
    }

    @JsonProperty("E1")
    public List<Double> getE1() {
        return e1;
    }

    @JsonProperty("E1")
    public void setE1(List<Double> e1) {
        this.e1 = e1;
    }

    public AcpHpdam withE1(List<Double> e1) {
        this.e1 = e1;
        return this;
    }

    @JsonProperty("E2")
    public List<Double> getE2() {
        return e2;
    }

    @JsonProperty("E2")
    public void setE2(List<Double> e2) {
        this.e2 = e2;
    }

    public AcpHpdam withE2(List<Double> e2) {
        this.e2 = e2;
        return this;
    }

    @JsonProperty("N1")
    public List<Double> getN1() {
        return n1;
    }

    @JsonProperty("N1")
    public void setN1(List<Double> n1) {
        this.n1 = n1;
    }

    public AcpHpdam withN1(List<Double> n1) {
        this.n1 = n1;
        return this;
    }

    @JsonProperty("N2")
    public List<Double> getN2() {
        return n2;
    }

    @JsonProperty("N2")
    public void setN2(List<Double> n2) {
        this.n2 = n2;
    }

    public AcpHpdam withN2(List<Double> n2) {
        this.n2 = n2;
        return this;
    }

    @JsonProperty("N3")
    public List<Double> getN3() {
        return n3;
    }

    @JsonProperty("N3")
    public void setN3(List<Double> n3) {
        this.n3 = n3;
    }

    public AcpHpdam withN3(List<Double> n3) {
        this.n3 = n3;
        return this;
    }

    @JsonProperty("S1")
    public List<Double> getS1() {
        return s1;
    }

    @JsonProperty("S1")
    public void setS1(List<Double> s1) {
        this.s1 = s1;
    }

    public AcpHpdam withS1(List<Double> s1) {
        this.s1 = s1;
        return this;
    }

    @JsonProperty("S2")
    public List<Double> getS2() {
        return s2;
    }

    @JsonProperty("S2")
    public void setS2(List<Double> s2) {
        this.s2 = s2;
    }

    public AcpHpdam withS2(List<Double> s2) {
        this.s2 = s2;
        return this;
    }

    @JsonProperty("S3")
    public List<Double> getS3() {
        return s3;
    }

    @JsonProperty("S3")
    public void setS3(List<Double> s3) {
        this.s3 = s3;
    }

    public AcpHpdam withS3(List<Double> s3) {
        this.s3 = s3;
        return this;
    }

    @JsonProperty("W1")
    public List<Double> getW1() {
        return w1;
    }

    @JsonProperty("W1")
    public void setW1(List<Double> w1) {
        this.w1 = w1;
    }

    public AcpHpdam withW1(List<Double> w1) {
        this.w1 = w1;
        return this;
    }

    @JsonProperty("W2")
    public List<Double> getW2() {
        return w2;
    }

    @JsonProperty("W2")
    public void setW2(List<Double> w2) {
        this.w2 = w2;
    }

    public AcpHpdam withW2(List<Double> w2) {
        this.w2 = w2;
        return this;
    }

    @JsonProperty("W3")
    public List<Double> getW3() {
        return w3;
    }

    @JsonProperty("W3")
    public void setW3(List<Double> w3) {
        this.w3 = w3;
    }

    public AcpHpdam withW3(List<Double> w3) {
        this.w3 = w3;
        return this;
    }
    
    
    /**
	 * @return the nR
	 */
    @JsonProperty("NR")
	public List<Double> getNR() {
		return NR;
	}

	/**
	 * @param nR the nR to set
	 */
    @JsonProperty("NR")
	public void setNR(List<Double> nR) {
		NR = nR;
	}

	/**
	 * @return the sR
	 */
    @JsonProperty("SR")
	public List<Double> getSR() {
		return SR;
	}

	/**
	 * @param sR the sR to set
	 */
    @JsonProperty("SR")
	public void setSR(List<Double> sR) {
		SR = sR;
	}

	/**
	 * @return the wR
	 */
    @JsonProperty("WR")
	public List<Double> getWR() {
		return WR;
	}

	/**
	 * @param wR the wR to set
	 */
    @JsonProperty("WR")
	public void setWR(List<Double> wR) {
		WR = wR;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AcpHpdam withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AcpHpdam.class.getName()).append('@').append(Double.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("a1");
        sb.append('=');
        sb.append(((this.a1 == null)?"<null>":this.a1));
        sb.append(',');
        sb.append("a2");
        sb.append('=');
        sb.append(((this.a2 == null)?"<null>":this.a2));
        sb.append(',');
        sb.append("e1");
        sb.append('=');
        sb.append(((this.e1 == null)?"<null>":this.e1));
        sb.append(',');
        sb.append("e2");
        sb.append('=');
        sb.append(((this.e2 == null)?"<null>":this.e2));
        sb.append(',');
        sb.append("n1");
        sb.append('=');
        sb.append(((this.n1 == null)?"<null>":this.n1));
        sb.append(',');
        sb.append("n2");
        sb.append('=');
        sb.append(((this.n2 == null)?"<null>":this.n2));
        sb.append(',');
        sb.append("n3");
        sb.append('=');
        sb.append(((this.n3 == null)?"<null>":this.n3));
        sb.append(',');
        sb.append("s1");
        sb.append('=');
        sb.append(((this.s1 == null)?"<null>":this.s1));
        sb.append(',');
        sb.append("s2");
        sb.append('=');
        sb.append(((this.s2 == null)?"<null>":this.s2));
        sb.append(',');
        sb.append("s3");
        sb.append('=');
        sb.append(((this.s3 == null)?"<null>":this.s3));
        sb.append(',');
        sb.append("w1");
        sb.append('=');
        sb.append(((this.w1 == null)?"<null>":this.w1));
        sb.append(',');
        sb.append("w2");
        sb.append('=');
        sb.append(((this.w2 == null)?"<null>":this.w2));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.s3 == null)? 0 :this.s3 .hashCode()));
        result = ((result* 31)+((this.n1 == null)? 0 :this.n1 .hashCode()));
        result = ((result* 31)+((this.n2 == null)? 0 :this.n2 .hashCode()));
        result = ((result* 31)+((this.n3 == null)? 0 :this.n3 .hashCode()));
        result = ((result* 31)+((this.e1 == null)? 0 :this.e1 .hashCode()));
        result = ((result* 31)+((this.e2 == null)? 0 :this.e2 .hashCode()));
        result = ((result* 31)+((this.a1 == null)? 0 :this.a1 .hashCode()));
        result = ((result* 31)+((this.a2 == null)? 0 :this.a2 .hashCode()));
        result = ((result* 31)+((this.w1 == null)? 0 :this.w1 .hashCode()));
        result = ((result* 31)+((this.w2 == null)? 0 :this.w2 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.w3 == null)? 0 :this.w3 .hashCode()));
        result = ((result* 31)+((this.s1 == null)? 0 :this.s1 .hashCode()));
        result = ((result* 31)+((this.s2 == null)? 0 :this.s2 .hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AcpHpdam) == false) {
            return false;
        }
        AcpHpdam rhs = ((AcpHpdam) other);
        return ((((((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.s3 == rhs.s3)||((this.s3 != null)&&this.s3 .equals(rhs.s3))))&&((this.n1 == rhs.n1)||((this.n1 != null)&&this.n1 .equals(rhs.n1))))&&((this.n2 == rhs.n2)||((this.n2 != null)&&this.n2 .equals(rhs.n2))))&&((this.n3 == rhs.n3)||((this.n3 != null)&&this.n3 .equals(rhs.n3))))&&((this.e1 == rhs.e1)||((this.e1 != null)&&this.e1 .equals(rhs.e1))))&&((this.e2 == rhs.e2)||((this.e2 != null)&&this.e2 .equals(rhs.e2))))&&((this.a1 == rhs.a1)||((this.a1 != null)&&this.a1 .equals(rhs.a1))))&&((this.a2 == rhs.a2)||((this.a2 != null)&&this.a2 .equals(rhs.a2))))&&((this.w1 == rhs.w1)||((this.w1 != null)&&this.w1 .equals(rhs.w1))))&&((this.w2 == rhs.w2)||((this.w2 != null)&&this.w2 .equals(rhs.w2))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.w3 == rhs.w3)||((this.w3 != null)&&this.w3 .equals(rhs.w3))))&&((this.s1 == rhs.s1)||((this.s1 != null)&&this.s1 .equals(rhs.s1))))&&((this.s2 == rhs.s2)||((this.s2 != null)&&this.s2 .equals(rhs.s2))));
    }

}
