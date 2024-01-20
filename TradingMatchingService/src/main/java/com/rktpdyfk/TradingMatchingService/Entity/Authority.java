package com.rktpdyfk.TradingMatchingService.Entity;

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
@Setter
@Builder
public class Authority {

   @Id
   @Column(name = "authority_name", length = 50)
   private String authorityName;
}
