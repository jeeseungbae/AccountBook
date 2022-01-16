package com.example.accountbook.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    private Long customerId;

    @Range(min=0, max = 99_999_999)
    private Long payMoney;

    private String memo;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
