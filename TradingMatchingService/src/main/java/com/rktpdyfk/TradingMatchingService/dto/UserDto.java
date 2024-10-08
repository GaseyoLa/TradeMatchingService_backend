package com.rktpdyfk.TradingMatchingService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

//회원가입
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   @NotNull
   @Size(min = 2, max = 50)
   private String username;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 8, max = 100)
   private String password;

   @NotNull
   @Size(min = 2, max = 50)
   private String nickname;

   @NotNull
   @Size(min = 3, max = 50)
   private String email;

   @Size(min = 2, max = 50)
   private String discordId;

   @Size(min = 2, max = 50)
   private String worldsId;

   private Set<AuthorityDto> authorityDtoSet;

   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              .username(user.getUsername())
              .nickname(user.getNickname())
              .email(user.getEmail())
              .discordId(user.getDiscordId())
              .worldsId(user.getWorldsId())
              .authorityDtoSet(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                      .collect(Collectors.toSet()))
              .build();
   }

   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   public static class UserPostResponseDto {
      private String username;
      private Long star;

      public UserPostResponseDto(User user){
         this.username = user.getUsername();
         this.star = user.getStar();
      }
   }

}