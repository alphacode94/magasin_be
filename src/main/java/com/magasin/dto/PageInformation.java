package com.magasin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PageInformation {
   private long totalElements;
   private Integer totalPages;
   private Integer size;

   public long getTotalElements() {
      return this.totalElements;
   }

   public Integer getTotalPages() {
      return this.totalPages;
   }

   public Integer getSize() {
      return this.size;
   }

   public void setTotalElements(final long totalElements) {
      this.totalElements = totalElements;
   }

   public void setTotalPages(final Integer totalPages) {
      this.totalPages = totalPages;
   }

   public void setSize(final Integer size) {
      this.size = size;
   }

   public String toString() {
      return "PageInformation(totalElements=" + this.getTotalElements() + ", totalPages=" + this.getTotalPages() + ", size=" + this.getSize() +")";
   }
}
