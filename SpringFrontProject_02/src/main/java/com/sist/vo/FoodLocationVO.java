package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodLocationVO {
	private int fno;
	private String name,phone,type,parking,price,time,menu,poster,address;
	private double score;
}