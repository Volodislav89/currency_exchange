package com.spring.currency_exchange.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"r030",
"txt",
"rate",
"cc",
"exchangedate"
})
//{
//        "r030":36,"txt":"Австралійський долар","rate":20.5518,"cc":"AUD","exchangedate":"19.11.2020"
//        }
public class NbuCurrency {

@JsonProperty("r030")
private Integer r030;
@JsonProperty("txt")
private String txt;
@JsonProperty("rate")
private Double rate;
@JsonProperty("cc")
private String cc;
@JsonProperty("exchangedate")
private String exchangedate;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("r030")
public Integer getR030() {
return r030;
}

@JsonProperty("r030")
public void setR030(Integer r030) {
this.r030 = r030;
}

@JsonProperty("txt")
public String getTxt() {
return txt;
}

@JsonProperty("txt")
public void setTxt(String txt) {
this.txt = txt;
}

@JsonProperty("rate")
public Double getRate() {
return rate;
}

@JsonProperty("rate")
public void setRate(Double rate) {
this.rate = rate;
}

@JsonProperty("cc")
public String getCc() {
return cc;
}

@JsonProperty("cc")
public void setCc(String cc) {
this.cc = cc;
}

@JsonProperty("exchangedate")
public String getExchangedate() {
return exchangedate;
}

@JsonProperty("exchangedate")
public void setExchangedate(String exchangedate) {
this.exchangedate = exchangedate;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}