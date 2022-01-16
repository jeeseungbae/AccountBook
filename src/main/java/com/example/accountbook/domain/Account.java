package com.example.accountbook.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    private Long customerId;

    private Long payMoney;

    private String memo;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
