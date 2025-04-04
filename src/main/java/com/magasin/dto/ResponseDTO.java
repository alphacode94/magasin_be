package com.magasin.dto;

import java.util.Map;

public class ResponseDTO<T> {
   private String responseMessage;
   private T responseObj;
   private PageInformation pageInformation;

   public ResponseDTO(String responseMessage, T responseObj) {
      this.responseMessage = responseMessage;

      try {
         if (responseObj instanceof Map) {
            this.pageInformation = (PageInformation)((Map)responseObj).keySet().toArray()[0];
            this.responseObj = (T) ((Map)responseObj).get(this.pageInformation);
            if (this.responseObj == null) {
               this.responseObj = (T) new String[0];
            }
         } else {
            this.responseObj = responseObj;
         }
      } catch (Exception var4) {
         this.responseObj = responseObj;
      }

   }

   public String getResponseMessage() {
      return this.responseMessage;
   }

   public T getResponseObj() {
      return this.responseObj;
   }

   public PageInformation getPageInformation() {
      return this.pageInformation;
   }

   public void setResponseMessage(final String responseMessage) {
      this.responseMessage = responseMessage;
   }

   public void setResponseObj(final T responseObj) {
      this.responseObj = responseObj;
   }

   public void setPageInformation(final PageInformation pageInformation) {
      this.pageInformation = pageInformation;
   }

   public ResponseDTO() {
   }

   public ResponseDTO(final String responseMessage, final T responseObj, final PageInformation pageInformation) {
      this.responseMessage = responseMessage;
      this.responseObj = responseObj;
      this.pageInformation = pageInformation;
   }

   public String toString() {
      return "ResponseDTO(responseMessage=" + this.getResponseMessage() + ", responseObj=" + this.getResponseObj() + ", pageInformation=" + this.getPageInformation() + ")";
   }
}
