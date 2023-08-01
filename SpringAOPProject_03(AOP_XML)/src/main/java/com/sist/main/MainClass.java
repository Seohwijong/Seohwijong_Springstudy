package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
 public static void main(String[] args) {
	ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
	EmpDAO dao=(EmpDAO)app.getBean("dao");
	List<EmpVO> list=dao.empListData();
	dao.empListData();
//	dao.empDetailData(7788);
	dao.empFindData("A");
}
}