package com.example.accountbook.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class AccountDetailDto {

    private Long id;

    private String email;

    private String roles;

    private Long payMoney;

    private String memo;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
