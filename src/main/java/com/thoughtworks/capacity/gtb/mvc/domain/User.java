package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "\\w{3,10}", message = "用户名不合法")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 5, max = 12, message = "密码不合法")
    private String password;
    @Email(message = "邮箱地址不合法")
    private String email;
}
