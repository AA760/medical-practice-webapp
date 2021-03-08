package com.group36.healthchecker.model;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "patient")

@DynamicUpdate 
public class Patient2
{

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patient_Id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Date dob;
    @Column(nullable = false)
    private Date dor;
    @Column(nullable = false)
    private int addressId;
    @Column(nullable = false)
    private long phone;
    @Column(nullable = false)
    private int user_Id;
    
    

    public int getPatientId() 
    {
        return patient_Id;
    }

    public void setPatientId(int patient_Id) 
    {
        this.patient_Id = patient_Id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String first_name) 
    {
        this.firstName = first_name;
    }
    
    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String last_name) 
    {
        this.lastName = last_name;
    }

    public Date getDob() 
    {
        return dob;
    }

    public void setDob(Date dob) 
    {
        this.dob = dob;
    }
    
    public Date getDor() 
    {
        return dor;
    }

    public void setDor(Date dor) 
    {
        this.dor = dor;
    }

    public int getAddressId() 
    {
        return addressId;
    }

    public void setAddressId(int address_Id) 
    {
        this.addressId = address_Id;
    }

    public long getPhone() 
    {
        return phone;
    }

    public void setPhone(long phone) 
    {
        this.phone = phone;
    }
    
    public int getUserId() 
    {
        return user_Id;
    }

    public void setUserId(int user_Id) 
    {
        this.user_Id = user_Id;
    }

    
    
}