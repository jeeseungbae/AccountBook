package com.example.accountbook.domain.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String email;
    private String password;
}
