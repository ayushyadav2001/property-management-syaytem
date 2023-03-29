package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is Mandatory !")
    @NotEmpty(message = "Email can not be empty")
    @Size(min = 1 ,max = 50 ,message = "Owner Email should be between 1 to 50 Characters in length")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password is mandatory !")
    @Size(min = 6,max = 20,message = "Password Should be Between 6 to 20 Characters ")
    @NotEmpty(message = "Password can not be Empty !")
    private String password;
}
