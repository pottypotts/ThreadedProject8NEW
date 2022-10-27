package com.example.proj8;

import java.io.Serializable;

public class Customer implements Serializable {
    //variables
    private int AgentId;
    private String CustAddress;
    private String CustBusPhone;
    private String CustCity;
    private String CustCountry;
    private String CustEmail;
    private String CustFirstName;
    private String CustHomePhone;
    private String CustLastName;
    private int CustomerId;
    private String CustPostal;
    private String CustProv;

    //Constructor
    public Customer(int agentId, String custAddress,
                    String custBusPhone, String custCity,
                    String custCountry, String custEmail,
                    String custFirstName, String custHomePhone,
                    String custLastName, int customerId, String custPostal,
                    String custProv) {
        AgentId = agentId;
        CustAddress = custAddress;
        CustBusPhone = custBusPhone;
        CustCity = custCity;
        CustCountry = custCountry;
        CustEmail = custEmail;
        CustFirstName = custFirstName;
        CustHomePhone = custHomePhone;
        CustLastName = custLastName;
        CustomerId = customerId;
        CustPostal = custPostal;
        CustProv = custProv;
    }

    //Getters & Setters
    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        CustAddress = custAddress;
    }

    public String getCustBusPhone() {
        return CustBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        CustBusPhone = custBusPhone;
    }

    public String getCustCity() {
        return CustCity;
    }

    public void setCustCity(String custCity) {
        CustCity = custCity;
    }

    public String getCustCountry() {
        return CustCountry;
    }

    public void setCustCountry(String custCountry) {
        CustCountry = custCountry;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }

    public String getCustFirstName() {
        return CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        CustFirstName = custFirstName;
    }

    public String getCustHomePhone() {
        return CustHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        CustHomePhone = custHomePhone;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public void setCustLastName(String custLastName) {
        CustLastName = custLastName;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustPostal() {
        return CustPostal;
    }

    public void setCustPostal(String custPostal) {
        CustPostal = custPostal;
    }

    public String getCustProv() {
        return CustProv;
    }

    public void setCustProv(String custProv) {
        CustProv = custProv;
    }

    @Override
    public String toString() {

        return CustomerId + "\t\t" + CustFirstName + CustLastName;
    }


}
