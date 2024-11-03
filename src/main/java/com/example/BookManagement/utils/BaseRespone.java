package com.example.BookManagement.utils;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseRespone<T> {

    @Builder.Default
    String code = "200";
    @Builder.Default
    boolean status = false;
    @Builder.Default
    String errMsg = "";

    T Data;
}
