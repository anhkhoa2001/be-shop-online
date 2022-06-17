package com.spring.core.response;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EResponse {

    public static final int SUCCESS = 200;
    public static final int FAILED = 404;
    public static final int ERROR_INPUT = 400;
    public static final int ERROR_EX = 405;

    public static final int COUNT_PRODUCT_LOAD = 9;
    public static final int DOLA = 22;
    public static final int CMID_PHONE = 1;
    public static final int CMID_TABLET = 2;
    public static final int CMID_LAPTOP = 3;


    public static final int ID_PHONE_IPHONE = 1;
    public static final int ID_PHONE_SAMSUNG = 2;
    public static final int ID_PHONE_XIAOMI = 3;
    public static final int ID_PHONE_OPPO = 4;
    public static final int ID_PHONE_NOKIA = 5;
    public static final int ID_PHONE_VIVO = 6;

    public static final String OPTION_SORT_PRICE_TOP = "top";
    public static final String OPTION_SORT_PRICE_BOT = "bot";
    public static final String OPTION_SORT_NAME_AZ = "az";
    public static final String OPTION_SORT_NAME_ZA = "za";

}
