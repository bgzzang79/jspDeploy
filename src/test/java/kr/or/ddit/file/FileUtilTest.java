package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileUtilTest {
	private String contentDisposition;
	
	@Before
	public void setup(){
		contentDisposition = "form-data; name=\"uploadFile\"; filename=\"rabbit.jpg\"";
	}
	
	/**
	* Method : fileSplitTest
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : file의 값을 분리 작업 확인
	*/
	@Test
	public void fileSplitTest() {
		/***Given***/
		String[] ctArr = contentDisposition.split("; ");

		/***When***/

		/***Then***/
		assertEquals("form-data", ctArr[0]);
		assertEquals("name=\"uploadFile\"", ctArr[1]);
		assertEquals("filename=\"rabbit.jpg\"", ctArr[2]);
	}

	@Test
	public void fileNameSplitTest(){
		/***Given***/

		/***When***/
		
		
		/***Then***/
		assertEquals("rabbit.jpg", new FileUtil().getFileName(contentDisposition));
	}
}
