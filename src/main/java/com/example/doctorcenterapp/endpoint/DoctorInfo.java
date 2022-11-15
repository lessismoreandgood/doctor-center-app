package com.example.doctorcenterapp.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doctorInfo", propOrder = {
        "fullName",
        "gender"
})
public class DoctorInfo {

    @XmlElement(required = true)
    private String fullName;
    @XmlElement(required = true)
    private String gender;
}
