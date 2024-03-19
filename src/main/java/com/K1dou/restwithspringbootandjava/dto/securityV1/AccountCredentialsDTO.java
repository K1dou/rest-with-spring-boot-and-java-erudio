package com.K1dou.restwithspringbootandjava.dto.securityV1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class AccountCredentialsDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4784173114008223905L;

    private String username;
    private String password;

    public AccountCredentialsDTO() {
    }

    public AccountCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCredentialsDTO that = (AccountCredentialsDTO) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
