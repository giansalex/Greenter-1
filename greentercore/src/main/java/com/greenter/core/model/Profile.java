package com.greenter.core.model;

import com.google.gson.annotations.SerializedName;

public class Profile {
  
  @SerializedName("ruc")
  private String ruc = null;
  @SerializedName("razon_social")
  private String razonSocial = null;
  @SerializedName("direccion")
  private String direccion = null;
  @SerializedName("user_sol")
  private String userSol = null;
  @SerializedName("clave_sol")
  private String claveSol = null;

  public String getRuc() {
    return ruc;
  }
  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getRazonSocial() {
    return razonSocial;
  }
  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getUserSol() {
    return userSol;
  }
  public void setUserSol(String userSol) {
    this.userSol = userSol;
  }

  public String getClaveSol() {
    return claveSol;
  }
  public void setClaveSol(String claveSol) {
    this.claveSol = claveSol;
  }
}
