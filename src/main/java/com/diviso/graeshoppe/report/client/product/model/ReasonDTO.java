package com.diviso.graeshoppe.report.client.product.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ReasonDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-31T16:45:03.566+05:30[Asia/Kolkata]")

public class ReasonDTO   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("iDPcode")
  private String iDPcode = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  public ReasonDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReasonDTO iDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
    return this;
  }

  /**
   * Get iDPcode
   * @return iDPcode
  **/
  @ApiModelProperty(value = "")


  public String getIDPcode() {
    return iDPcode;
  }

  public void setIDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
  }

  public ReasonDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ReasonDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReasonDTO reasonDTO = (ReasonDTO) o;
    return Objects.equals(this.description, reasonDTO.description) &&
        Objects.equals(this.iDPcode, reasonDTO.iDPcode) &&
        Objects.equals(this.id, reasonDTO.id) &&
        Objects.equals(this.name, reasonDTO.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, iDPcode, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReasonDTO {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iDPcode: ").append(toIndentedString(iDPcode)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

