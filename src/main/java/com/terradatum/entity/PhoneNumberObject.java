package com.terradatum.entity;

import org.eclipse.persistence.annotations.Struct;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by rbellamy on 12/21/15.
 */
@Embeddable
@Struct(name = "MLS_PHONE_OBJ", fields = {"PHONE_TYPE", "PHONE_NUMBER", "SHORT_DESCRIPTION"})
public class PhoneNumberObject implements Serializable {
    @Column(name = "PHONE_TYPE")
    private String phoneType;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
