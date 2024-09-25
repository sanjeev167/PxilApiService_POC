
package com.pxil.pvt.reg.jpojo;


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
    "date",
    "entity1",
    "entity2",
    "entityN"
})
@Generated("jsonschema2pojo")
public class EntityWiseExchangeDatum {

    @JsonProperty("date")
    private String date;
    @JsonProperty("entity1")
    private Entity1 entity1;
    @JsonProperty("entity2")
    private Entity2 entity2;
    @JsonProperty("entityN")
    private EntityN entityN;
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

    public EntityWiseExchangeDatum withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("entity1")
    public Entity1 getEntity1() {
        return entity1;
    }

    @JsonProperty("entity1")
    public void setEntity1(Entity1 entity1) {
        this.entity1 = entity1;
    }

    public EntityWiseExchangeDatum withEntity1(Entity1 entity1) {
        this.entity1 = entity1;
        return this;
    }

    @JsonProperty("entity2")
    public Entity2 getEntity2() {
        return entity2;
    }

    @JsonProperty("entity2")
    public void setEntity2(Entity2 entity2) {
        this.entity2 = entity2;
    }

    public EntityWiseExchangeDatum withEntity2(Entity2 entity2) {
        this.entity2 = entity2;
        return this;
    }

    @JsonProperty("entityN")
    public EntityN getEntityN() {
        return entityN;
    }

    @JsonProperty("entityN")
    public void setEntityN(EntityN entityN) {
        this.entityN = entityN;
    }

    public EntityWiseExchangeDatum withEntityN(EntityN entityN) {
        this.entityN = entityN;
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

    public EntityWiseExchangeDatum withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EntityWiseExchangeDatum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("entity1");
        sb.append('=');
        sb.append(((this.entity1 == null)?"<null>":this.entity1));
        sb.append(',');
        sb.append("entity2");
        sb.append('=');
        sb.append(((this.entity2 == null)?"<null>":this.entity2));
        sb.append(',');
        sb.append("entityN");
        sb.append('=');
        sb.append(((this.entityN == null)?"<null>":this.entityN));
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
        result = ((result* 31)+((this.entity1 == null)? 0 :this.entity1 .hashCode()));
        result = ((result* 31)+((this.entity2 == null)? 0 :this.entity2 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.entityN == null)? 0 :this.entityN.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EntityWiseExchangeDatum) == false) {
            return false;
        }
        EntityWiseExchangeDatum rhs = ((EntityWiseExchangeDatum) other);
        return ((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.entity1 == rhs.entity1)||((this.entity1 != null)&&this.entity1 .equals(rhs.entity1))))&&((this.entity2 == rhs.entity2)||((this.entity2 != null)&&this.entity2 .equals(rhs.entity2))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.entityN == rhs.entityN)||((this.entityN!= null)&&this.entityN.equals(rhs.entityN))));
    }

}
