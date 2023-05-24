package com.armdoctor.util;

import org.apache.commons.lang3.RandomStringUtils;

public class TokenGenerate {

    public static String generateVerifyCode() {
        return RandomStringUtils.random(6, true, true);
    }
}
