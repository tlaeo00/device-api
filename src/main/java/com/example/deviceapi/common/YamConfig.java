package com.example.deviceapi.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ConfigurationProperties(prefix="env")
@Component
@Validated
public class YamConfig {

    @NotBlank
    private String user;
    @NotBlank
    private String name;
    @Pattern(regexp = "[0-9]", message = "숫자만 가능합니다.")
    private String num;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
