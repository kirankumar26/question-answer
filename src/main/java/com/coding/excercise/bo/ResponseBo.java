package com.coding.excercise.bo;

public class ResponseBo {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
	return "ResponseBo [message=" + message + "]";
  }  
}
