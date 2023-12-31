package com.sist.main;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	@Autowired
	private FoodService service;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		Scanner scan=new Scanner(System.in);
		MainClass mc=(MainClass)app.getBean("mainClass"); // component에서 id 지정 안하면 클래스명이 default => 클래스명의 첫글자만 소문자가 된다
		
		List<CategoryVO> list=mc.service.cateListData();
		for(CategoryVO vo:list)
		{
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		System.out.println("=============================================");
		System.out.print("카테고리 번호 선택 :");
		int cno=scan.nextInt();
		List<FoodVO> fList=mc.service.foodCategoryListData(cno);
		for(FoodVO vo:fList)
		{
			System.out.println(vo.getFno()+"."+vo.getName());
		}
		System.out.println("=============================================");
		System.out.print("맛집 번호 선택 :");
		int fno=scan.nextInt();
		FoodVO vo=mc.service.foodDetailData(fno);
		System.out.println("맛집명 :"+vo.getName()+"("+vo.getScore()+")");
		System.out.println("주소 :"+vo.getAddress());
		System.out.println("전화 :"+vo.getPhone());
		System.out.println("음식 종류 :"+vo.getType());
		System.out.println("가격대 :"+vo.getPrice());
		System.out.println("주차 :"+vo.getParking());
		System.out.println("영업시간 :"+vo.getTime());
		System.out.println("메뉴 :"+vo.getMenu());
		
	}
}
