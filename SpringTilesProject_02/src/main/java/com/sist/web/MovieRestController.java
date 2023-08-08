package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 *  searchMainDailyBoxOfficeList.do
 *  searchMainRealTicket.do
 *  searchMainDailySeatTicket.do
 */
@RestController
public class MovieRestController {
	private String[] urls= {"","https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOfficeList.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do"};
	@GetMapping(value="movie/movie_rank_vue.do",produces="text/plain;charset=UTF-8")
	/*
	 *    1. HTML
	 *    2. XML
	 *    3. JSON
	 *    
	 *    VO ====> {} ====> JSONObject
	 *    List ===> [{},{},{}...] ====> JSONArray
	 *    Rest => React / Redux / Vue / AngularJS
	 */
	public String movie_rank(int no)
	{
		return "";
	}
}