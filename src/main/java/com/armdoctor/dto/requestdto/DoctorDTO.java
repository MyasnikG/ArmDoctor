package com.armdoctor.dto.requestdto;

import com.armdoctor.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
public class DoctorDTO {

    //Regex for Name
    private static final String NAME_NULL_MSG = "Name cannot be null or empty";
    private static final int NAME_SIZE_MIN = 2;
    private static final int NAME_SIZE_MAX = 45;
    private static final String NAME_SIZE_MSG = "Name size must be between " + NAME_SIZE_MIN + " and " + NAME_SIZE_MAX;
    private static final String NAME_REGEX = "^[[A-ZÀ-ÿ][-,a-z. ']+[ ]*]+$";
    private static final String NAME_REGEX_MSG = "Name must contain A-Z,a-z,0-9";


    //Regex for Surname
    private static final String SURNAME_NULL_MSG = "Surname cannot be null or empty";
    private static final String SURNAME_REGEX = "[A-Za-z]+([ '-][a-zA-Z]+)*";
    private static final String SURNAME_REGEX_MSG = "Surname must contain A-Z,a-z";
    private static final int SURNAME_SIZE_MAX = 50;
    private static final int SURNAME_SIZE_MIN = 2;
    private static final String SURNAME_SIZE_MSG = "Surname size must be between " + SURNAME_SIZE_MIN + " and " + SURNAME_SIZE_MAX;


    //Regex for Email
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$";
    private static final String EMAIL_MSG = "Invalid email format";


    //Regex for Password
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)[A-Za-z\\\\d@$!%*?&]{8,}$";
    private static final String PASSWORD_REGEX_MSG = "Invalid password";


    private Integer id;
    @NotEmpty(message = NAME_NULL_MSG)
    @Pattern(regexp = NAME_REGEX, message = NAME_REGEX_MSG)
    @Length(min = NAME_SIZE_MIN, max = NAME_SIZE_MAX, message = NAME_SIZE_MSG)
    private String name;

    @NotEmpty(message = SURNAME_NULL_MSG)
    @Pattern(regexp = SURNAME_REGEX, message = SURNAME_REGEX)
    @Length(min = NAME_SIZE_MIN, max = NAME_SIZE_MAX, message = NAME_SIZE_MSG)
    private String surname;

    @NotNull(message = "Year cannot be null or empty")
    @Min(value = 1930, message = "Year must be equal or grater than 1930")
    @Max(value = 2020, message = "Year must be equal or less than 2020")
    @Digits(integer = 4, message = "Year must contain only numeric values!", fraction = 0)
    private Integer year;

    @NotEmpty(message = "Email cannot be null or empty")
    @Pattern(regexp = EMAIL_REGEX, message = EMAIL_MSG)
    private String email;

    @NotEmpty(message = "Password cannot be null or empty")

    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_MSG)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String profession;
    private String workTime;
    private String bookTime;
    private List<String> hospitals;
}
