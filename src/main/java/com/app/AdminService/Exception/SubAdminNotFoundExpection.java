package com.app.AdminService.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = true)
public class SubAdminNotFoundExpection extends RuntimeException {
    private final String msg;
}
