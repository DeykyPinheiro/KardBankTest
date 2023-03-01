package com.kardbank.api.dto.phoneValidation;

public record Phonevalidation(String phone, boolean valid, Format format, Country country, String location, String type,
                              String carrier) {
}
