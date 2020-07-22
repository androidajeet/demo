package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class UserDTO {


	  @Id
	  @GeneratedValue private Long id;
	 

    @NotEmpty(message = "Please provide a First name")
    private String fName;
    private String mName;
    @NotEmpty(message = "Please provide a Last name")
    private String lName;

    public UserDTO() {
    }

    public UserDTO(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }




    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName ;
    }

    public String getlName() {
        return lName;
    }
}
