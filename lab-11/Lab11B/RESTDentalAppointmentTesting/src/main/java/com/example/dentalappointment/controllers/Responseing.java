package com.example.dentalappointment.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public class Responseing {

    @Data
    @AllArgsConstructor
    static class All<T> {
        List<T> data;
    }

    @Data
    @AllArgsConstructor
    static class Unique<T> {
        T data;
    }

}
