package com.armdoctor.dto.requestdto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class HospitalDTO {


    private static final String NAME_NULL_MSG = "Hospital name cannot be null or empty";
    private static final String NAME_REGEX = "^[\\p{L}\\p{M}’\\s-\\p{N}]+$";
    private static final String NAME_REGEX_MSG = "Name must contain A-Z, a-z, 0-9";
    private static final int NAME_SIZE_MIN = 1;
    private static final int NAME_SIZE_MAX = 45;
    private static final String NAME_SIZE_MSG = "Name should be between " + NAME_SIZE_MIN + " and " + NAME_SIZE_MAX;
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$";
    private static final String EMAIL_MSG = "Invalid Email format";
    private static final String ADDRESS_NULL_MSG = "Address cannot be null or empty";
    private static final String ADDRESS_REGEX = "^[\\w\\s\\p{P}]+$";
    private static final int ADDRESS_SIZE_MIN = 1;
    private static final int ADDRESS_SIZE_MAX = 45;
    private static final String ADDRESS_SIZE_MSG = "Address should be between " + ADDRESS_SIZE_MIN + " and " + ADDRESS_SIZE_MAX;


    private Integer id;
    @NotEmpty(message = NAME_NULL_MSG)

    @Pattern(regexp = NAME_REGEX, message = NAME_REGEX_MSG)
    @Length(min = NAME_SIZE_MIN, max = NAME_SIZE_MAX, message = NAME_SIZE_MSG)
    private String name;

    @Pattern(regexp = EMAIL_REGEX, message = EMAIL_MSG)
    private String email;
    @NotEmpty(message = ADDRESS_SIZE_MSG)
    @Length(min = ADDRESS_SIZE_MIN, max = ADDRESS_SIZE_MAX, message = ADDRESS_NULL_MSG)
    private String address;
}
