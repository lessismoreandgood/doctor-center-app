package com.example.doctorcenterapp.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "doctorId"
})
@XmlRootElement(name = "getDoctorByIdRequest")
public class GetDoctorByIdRequest {

    protected String doctorId;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String value) {
        this.doctorId = value;
    }
}
