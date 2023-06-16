package com.armdoctor.util;

import com.armdoctor.dto.requestdto.DoctorDTO;
import com.armdoctor.exceptions.DoctorValidationException;


public class DoctorValidation {


    public static void validateFields(DoctorDTO doctorDTO) {
        if (doctorDTO.getName() == null || doctorDTO.getName().isBlank()) {
            throw new DoctorValidationException("User's name cannot be null or empty");
        }

        if (doctorDTO.getSurname() == null || doctorDTO.getSurname().isBlank()) {
            throw new DoctorValidationException("User's surname cannot be null or empty");
        }

        if (doctorDTO.getYear() == null || doctorDTO.getYear() < 1910 || doctorDTO.getYear() > 2020) {
            throw new DoctorValidationException("User's age must be between 1910 - 2020");
        }
    }


    public static void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new DoctorValidationException("Password cannot be null or empty");
        }
        if (password.length() < 6) {
            throw new DoctorValidationException("Password is short");
        }

        int countOfUppercase = 0;
        int countOfDigit = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                countOfDigit++;
            } else if (Character.isUpperCase(c)) {
                countOfUppercase++;
            }
        }

        if (countOfUppercase < 1) {
            throw new DoctorValidationException("Password must contain at least 1 uppercase letter");
        }

        if (countOfDigit < 2) {
            throw new DoctorValidationException("Password must contain at least 2 digits");
        }
    }


}
