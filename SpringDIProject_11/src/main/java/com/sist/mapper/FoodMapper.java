package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;

public interface FoodMapper {
	@Select("SELECT fno,name FROM food_house WHERE cno=#{cno} ORDER BY fno ASC")
	public List<FoodVO> foodCategoryListData(int cno);
	@Select("SELECT fno,name,phone,address,parking,time,NVL(menu,'없음') as menu,price,score,type "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}