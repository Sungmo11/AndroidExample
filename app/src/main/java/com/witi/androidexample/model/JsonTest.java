package com.witi.androidexample.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonTest {

    private int user;
    private String name;
    private String pw;

    @Builder
    public JsonTest(int user, String name, String pw){
        this.user = user;
        this.name = name;
        this.pw = pw;
    }
}
