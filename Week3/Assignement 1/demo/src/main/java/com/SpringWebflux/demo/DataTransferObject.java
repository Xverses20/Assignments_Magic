package com.SpringWebflux.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTransferObject {
    private String id;
    private String name;
    private int marks;
    private int mobile;
}
