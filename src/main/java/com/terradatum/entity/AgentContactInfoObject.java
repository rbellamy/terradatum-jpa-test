package com.terradatum.entity;

import org.eclipse.persistence.annotations.NamedStoredFunctionQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;
import org.eclipse.persistence.annotations.Struct;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ParameterMode;
import java.io.Serializable;

/**
 * Created by rbellamy on 12/20/15.
 */
@Embeddable
@Struct(name = "METRICS.AGENT_CONTACT_INFO_OBJ", fields = {
        "AGENT_OBJ",
        "OFFICE_NAME",
        "OFFICE_ADDRESS",
        "OFFICE_CITY",
        "OFFICE_STATE",
        "OFFICE_ZIPCODE",
        "PHONE_TBL",
        "AGENT_EMAIL",
        "AGENT_ADDRESS",
        "AGENT_CIT",
        "AGENT_STATE",
        "AGENT_ZIPCODE"
})
@NamedStoredFunctionQuery(
        name = "GET_AGENT_CONTACT_INFO",
        functionName = "RECRUITING_PKG.GET_AGENT_CONTACT_INFO",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, queryParameter = "mlsAgentIdTbl", jdbcType = 2002, jdbcTypeName = "STRUCT")
        },
        returnParameter = @StoredProcedureParameter(queryParameter = "RETURN", jdbcType = 2002, jdbcTypeName = "STRUCT")
)
public class AgentContactInfoObject implements Serializable {
    @Embedded
    @Column(name = "AGENT_OBJ")
    private AgentIdObject agentId;
    @Column(name = "OFFICE_NAME")
    private String officeName;
    @Column(name = "OFFICE_ADDRESS")
    private String officeAddress;
    @Column(name = "OFFICE_CITY")
    private String officeCity;
    @Column(name = "OFFICE_STATE")
    private String officeState;
    @Column(name = "OFFICE_ZIPCODE")
    private String officeZipCode;
    /*@ElementCollection
    @Column(name = "PHONE_TBL")
    private Collection<PhoneNumberObject> phones = new ArrayList<>();*/
    @Column(name = "AGENT_EMAIL")
    private String agentEmail;
    @Column(name = "AGENT_ADDRESS")
    private String agentAddress;
    @Column(name = "AGENT_CITY")
    private String agentCity;
    @Column(name = "AGENT_STATE")
    private String agentState;
    @Column(name = "AGENT_ZIPCODE")
    private String agentZipCode;

    public AgentIdObject getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentIdObject agentId) {
        this.agentId = agentId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeState() {
        return officeState;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }

    public String getOfficeZipCode() {
        return officeZipCode;
    }

    public void setOfficeZipCode(String officeZipCode) {
        this.officeZipCode = officeZipCode;
    }

    /*public Collection<PhoneNumberObject> getPhones() {
        return phones;
    }

    public void setPhones(Collection<PhoneNumberObject> phones) {
        this.phones = phones;
    }*/

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState;
    }

    public String getAgentZipCode() {
        return agentZipCode;
    }

    public void setAgentZipCode(String agentZipCode) {
        this.agentZipCode = agentZipCode;
    }
}
