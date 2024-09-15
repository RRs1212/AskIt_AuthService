package com.AskIt.AuthService.Dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateionDetail<T> {
    private T details;

    public void set(T value) {
        this.details = value;
    }

    public T get() {
        return details;
    }
}
