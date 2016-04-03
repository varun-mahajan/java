package org.bytegeeks.learn.spring.api;

public class PhoneNumber {

    public static enum Type {
        MOBILE, WORK, HOME
    }

    private static final String COUNTRY_CODE_PREFIX = "+";

    private String countryCode;
    private int areaCode = 0;
    private long number;

    private Type type = Type.MOBILE;

    public PhoneNumber() {
    }

    public PhoneNumber(int countryCode, int areaCode, long number) {
        this.countryCode = COUNTRY_CODE_PREFIX + countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = COUNTRY_CODE_PREFIX + countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return countryCode + "-" + areaCode + "-" + number;
    }

}
