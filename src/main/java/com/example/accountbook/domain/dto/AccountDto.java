package com.example.accountbook.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDto {

    private Long id;

    private Long payMoney;

    private String memo;
}
