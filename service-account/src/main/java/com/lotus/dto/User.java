package com.lotus.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

/**
 * @author Tony
 * 2018-06-16 11:15
 **/
@Data
@ToString
public class User {
    @NotBlank
    private String name;

    @Range(min = 0, max = 1)
    private int gender;

//    @Range(min = 1, max = 100)
    @Pattern(regexp = "0|10|50")
    private String age;
}
