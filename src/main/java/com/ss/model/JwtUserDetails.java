package com.ss.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDetails {

    private String userId;
    private String userName;
    private String roles;
}
