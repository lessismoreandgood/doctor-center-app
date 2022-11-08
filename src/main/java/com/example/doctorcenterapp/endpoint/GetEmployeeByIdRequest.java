package com.example.doctorcenterapp.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "employeeId"
})
@XmlRootElement(name = "getDoctorByIdRequest")
public class GetEmployeeByIdRequest {

    protected String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String value) {
        this.employeeId = value;
    }
}
