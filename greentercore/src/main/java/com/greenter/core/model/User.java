/**
 * Grenter App
 * Aplicación para MYPEs empleando sus comprobantes electrónicos
 *
 * OpenAPI spec version: 1.0.0
 * Contact: giansalex@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.greenter.core.model;

import com.google.gson.annotations.SerializedName;

public class User {
  
  @SerializedName("email")
  private String email = null;
  @SerializedName("password")
  private String password = null;

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
