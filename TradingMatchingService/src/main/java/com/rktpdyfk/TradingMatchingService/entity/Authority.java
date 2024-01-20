package com.rktpdyfk.TradingMatchingService.entity;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authority")
@Getter
@Builder
public class Authority {

   @Id
   @Column(name = "authority_name", length = 50)
   private String authorityName;
}
