package com.example.PraticeMicroService.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseResponse<T> {

    String msg = "";
    Boolean status = false;
    T Data = null;
}
