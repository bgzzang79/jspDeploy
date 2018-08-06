package kr.or.ddit.cookie.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CookieUtilTest {
	private String cookie;
	
	@Before
	public void setup(){
		cookie = "userId=brown; name=kang";
	}
	
	/**
	* Method : cookieSplitTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 쿠키 전체 값에 대한 분리 작업 확인
	*/
	@Test
	public void cookieSplitTest(){
		/***Given***/
		String[] cookies = cookie.split("; ");

		/***When***/

		/***Then***/
		assertEquals(2, cookies.length);
		assertEquals("userId=brown", cookies[0]);
		assertEquals("name=kang", cookies[1]);
	}
	
	/**
	* Method : cookieNameValueSplitTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 쿠기의 이름과 값을 분리 테스트
	*/
	@Test
	public void cookieNameValueSplitTest(){
		/***Given***/
		String cookie = "userId=brown";
		
		/***When***/
		String[] cookieArr = cookie.split("=");
		/***Then***/
		assertEquals("userId", cookieArr[0]);
		assertEquals("brown", cookieArr[1]);
	}
	
	@Test
	public void getCookietest() {
//		userId=brown
		
		/***Given***/
		
		CookieUtil cookieUtil = new CookieUtil();

		/***When***/
		String cookieValue = cookieUtil.getCookie(cookie,"userId");
//		String cookieValue2 = cookieUtil.getCookie(cookie,"name");
		/***Then***/
		assertEquals("brown", cookieValue);
//		assertEquals("kang", cookieValue);

	}

}
