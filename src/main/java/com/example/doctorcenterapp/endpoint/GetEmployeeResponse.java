package com.example.doctorcenterapp.endpoint;

import com.example.doctorcenterapp.model.dto.DoctorDto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "doctorInfo"
})
@XmlRootElement(name = "getEmployeeResponse")
public class GetEmployeeResponse {

    @XmlElement(required = true)
    protected DoctorInfo doctorInfo;

    public DoctorInfo getEmployeeInfo() {
        return doctorInfo;
    }

    public void setEmployeeInfo(DoctorInfo value) {
        this.doctorInfo = value;
    }

}
