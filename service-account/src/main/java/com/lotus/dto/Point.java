package com.lotus.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Tony
 * 2018-06-21 17:36
 **/
@Data
@ToString
public class Point {
    private double lng; //经度
    private double lat;
}
