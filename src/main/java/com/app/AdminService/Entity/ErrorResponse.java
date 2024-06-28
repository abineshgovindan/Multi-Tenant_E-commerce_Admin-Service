package com.app.AdminService.Entity;


import java.util.Map;
import java.util.Set;

public record ErrorResponse(
        Map<String, String> errors
) {

}