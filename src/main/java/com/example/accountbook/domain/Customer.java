package com.example.accountbook.domain;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;

    @NotBlank
    @Email(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$"
            ,message = "올바른 이메일을 입력해주세요.")
    private String email;

    @NotBlank
    @Size(min = 8,message = "최소 8글자 이상 입력해주세요")
    private String password;

}
