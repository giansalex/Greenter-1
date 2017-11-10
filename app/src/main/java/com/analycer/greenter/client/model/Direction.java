/**
 * Grenter App
 * Aplicacion para mypes empleando sus comprobantes electrónicos
 *
 * OpenAPI spec version: 1.0.0
 * Contact: giansalex@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.analycer.greenter.client.model;

import com.google.gson.annotations.SerializedName;

public class Direction {
  
  @SerializedName("ubigueo")
  private String ubigueo = null;
  @SerializedName("direccion")
  private String direccion = null;

  /**
   **/
  
  public String getUbigueo() {
    return ubigueo;
  }
  public void setUbigueo(String ubigueo) {
    this.ubigueo = ubigueo;
  }

  /**
   **/
  
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Direction direction = (Direction) o;
    return (this.ubigueo == null ? direction.ubigueo == null : this.ubigueo.equals(direction.ubigueo)) &&
        (this.direccion == null ? direction.direccion == null : this.direccion.equals(direction.direccion));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.ubigueo == null ? 0: this.ubigueo.hashCode());
    result = 31 * result + (this.direccion == null ? 0: this.direccion.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Direction {\n");
    
    sb.append("  ubigueo: ").append(ubigueo).append("\n");
    sb.append("  direccion: ").append(direccion).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}