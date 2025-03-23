package com.IPR.demo.DTO;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactiveDTO {
    String name;
    String articul;
    String vendor;
    float price;
    float count;
}
