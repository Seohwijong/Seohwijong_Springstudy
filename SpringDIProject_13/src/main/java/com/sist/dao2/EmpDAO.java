package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper2.*;
import com.sist.vo.*;
@Repository
public class EmpDAO {
	@Autowired
	private EmpDeptMapper mapper;
//	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
//			+ "FROM emp,dept "
//			+ "WHERE emp.deptno=dept.deptno "
//			+ "ORDER BY sal DESC")
	public List<EmpVO> empdeptListData()
	{
		return mapper.empdeptListData();
	}
//	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
//			+ "FROM emp,dept "
//			+ "WHERE emp.deptno=dept.deptno "
//			+ "AND empno=#{empno}")
	public EmpVO empdeptDetailData(int empno)
	{
		return mapper.empdeptDetailData(empno);
	}
}
