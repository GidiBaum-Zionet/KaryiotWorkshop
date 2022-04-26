package com.example.elements.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
  private String token;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  @Setter(AccessLevel.NONE)
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
  }


}
