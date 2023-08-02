package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
 // 목록
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit,group_tab "
			+ "FROM springReplyBoard ORDER BY group_id DESC,group_step ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springReplyBoard")
	public int boardTotalPage();
 // 추가
	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsertData(BoardVO vo);
 // 상세보기
	@Update("UPDATE springReplyBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
 // 답변 ======= 트랜잭션 (스프링 : AOP)
 @Select("SELECT group_id,group_step,group_tab "
 		+ "FROM springReplyBoard "
 		+ "WHERE no=#{no}")
   public BoardVO boardParentInfoData(int no);
 
 @Update("UPDATE springReplyBoard SET "
 		+ "group_step=group_step+1 "
 		+ "WHERE group_id=#{group_id} AND group_step>#{group_step}")
 public void boardGroupStepIncrement(BoardVO vo);
 
 @Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+ "#{group_id},#{group_step},#{group_tab},#{root})")
  public void boardReplyInsert(BoardVO vo);
 
  @Update("UPDATE springReplyBoard SET "
  		+ "depth=depth+1 "
  		+ "WHERE no=#{no}")
  public void boardDepthIncrement(int no);
 // 수정
 // 삭제 ======= 트랜잭션 (스프링 : AOP)
 // 다중검색 (동적 쿼리)
}