package com.example.proj8;

import java.io.Serializable;

public class Agent implements Serializable {
    //Variables
    private int AgentId;
    private String AgtBusPhone;
    private String AgtFirstName;
    private String AgtLastName;
    private String AgtEmail;
    private int AgencyId;
    private String agtPosition;

    //Constructor
    public Agent(int agentId, String agtBusPhone, String agtFirstName,
                 String agtLastName, String agtEmail, int agencyId, String agtPosition) {
        AgentId = agentId;
        AgtBusPhone = agtBusPhone;
        AgtFirstName = agtFirstName;
        AgtLastName = agtLastName;
        AgtEmail = agtEmail;
        AgencyId = agencyId;
        this.agtPosition = agtPosition;
    }

    //Getters & Setters
    public String getAgtBusPhone() {
        return AgtBusPhone;
    }
    public void setAgtBusPhone(String agtBusPhone) {
        AgtBusPhone = agtBusPhone;
    }
    public String getAgtEmail() {
        return AgtEmail;
    }
    public void setAgtEmail(String agtEmail) {
        AgtEmail = agtEmail;
    }

    public int getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(int agencyId) {
        AgencyId = agencyId;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }


    public String getAgtFirstName() {
        return AgtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        AgtFirstName = agtFirstName;
    }

    public String getAgtLastName() {
        return AgtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        AgtLastName = agtLastName;
    }

    @Override
    public String toString() {
        return AgentId + "\t\t" + AgtFirstName + AgtLastName;
    }
}
