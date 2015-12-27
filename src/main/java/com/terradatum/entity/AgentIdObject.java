package com.terradatum.entity;

import org.eclipse.persistence.annotations.Struct;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by rbellamy on 12/21/15.
 */
@Embeddable
@Struct(name = "MLS_AGENT_ID_OBJ", fields = {"AGENT_ID", "MLS_SID", "MLS_MEMBERSHIP_STATUS_CODE"})
public class AgentIdObject implements Serializable {
    @Column(name = "AGENT_ID")
    private String agentId;
    @Column(name = "MLS_SID")
    private String mlsSid;
    @Column(name = "MLS_MEMBERSHIP_STATUS_CODE")
    private String mlsMembershipStatusCode;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getMlsSid() {
        return mlsSid;
    }

    public void setMlsSid(String mlsSid) {
        this.mlsSid = mlsSid;
    }

    public String getMlsMembershipStatusCode() {
        return mlsMembershipStatusCode;
    }

    public void setMlsMembershipStatusCode(String mlsMembershipStatusCode) {
        this.mlsMembershipStatusCode = mlsMembershipStatusCode;
    }
}
