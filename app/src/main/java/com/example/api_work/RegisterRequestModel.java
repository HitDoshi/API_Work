package com.example.api_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequestModel {

    @SerializedName("Name")
    @Expose
    public String Name;
    @SerializedName("MobileNo")
    @Expose
    public String MobileNo;
    public String Email;
    public String Password;
    public String Address;
    public String UserType;
    public String CompanyName;
    public String WhatsappNo;
    public String Country;
    public String Isactive;
    public String CreatedDate;

    public RegisterRequestModel(String name, String mobileNo, String email ,String password ,
                                String address, String userType, String companyName, String whatsappNo,
                                String country, String isactive, String createdDate) {
        this.Name = name;
        this.MobileNo = mobileNo;
        this.Email = email;
        this.Password = password;
        this.Address = address;
        this.UserType = userType;
        this.CompanyName = companyName;
        this.WhatsappNo = whatsappNo;
        this.Country = country;
        this.Isactive = isactive;
        this.CreatedDate = createdDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getWhatsappNo() {
        return WhatsappNo;
    }

    public void setWhatsappNo(String whatsappNo) {
        WhatsappNo = whatsappNo;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getIsactive() {
        return Isactive;
    }

    public void setIsactive(String isactive) {
        Isactive = isactive;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }
}
