package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentServiceInf;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	//@Before --> @Test --> @After
	
	//테스트 메서드안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup 메서드에 위임
	// 모든 테스트 메서드에서 StudentDao 객체를 참조할 수 있게 클래스 변수로 생성할 필요가 있고
	// 클래스 변수를 setup메서드에서 초기화하는 로직이 필요
	// Test메서드에서 StudentDao() 구현 삭제
	private StudentDaoInf studentDao;
	
	@Before
	public void setup(){
		studentDao = new StudentDao();
	}
	
	/**
	* Method : selectAllStudenttest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	@Test
	public void selectAllStudenttest() {
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentDao.selectAllStudent();
		
		for (StudentVo vo : studentList) {
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	@Test
	public void getStudenttest(){
		/***Given***/
		/***When***/
		List<StudentVo> studentList = studentDao.getStudent((int)(Math.random()*25)+1);
		for (StudentVo vo : studentList) {
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(1, studentList.size());
	}
	
	@Test
	public void getStudentVotest(){
		/***Given***/
		StudentVo paramVo = new StudentVo();
		int id = 1;
		paramVo.setId(id);
		/***When***/
		StudentVo studentVo = studentDao.getStudentVo(paramVo);
		
		/***Then***/
		assertEquals(id, studentVo.getId());
	}
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 학생 페이지 리스트 조회 테스트
	*/
	@Test
	public void getStudentPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 2);
		map.put("pagesize", 10);
		
		/***When***/
		List<StudentVo> pageList = studentDao.getStudentPageList(map);
		
		/***Then***/
		assertEquals(10, pageList.size());
	}
	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("rabbit.jpg");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		studentVo.setPicname("7411c9e0-de93-4fcc-abc1-c74c2571af8b");

		/***When***/
		int updateCnt = studentDao.studentUpdate(studentVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}