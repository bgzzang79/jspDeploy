package kr.or.ddit.student.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	private StudentServiceInf studentService;
	@Before
	public void setup(){
		studentService = new StudentService();
	}
	/**
	 * Method : selectAllStudenttest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보 조회 테스트
	 */
	@Test
	public void selectAllStudenttest() {
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentService.selectAllStudent();
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
		List<StudentVo> studentList = studentService.getStudent((int)(Math.random()*25)+1);
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
		StudentVo studentVo = studentService.getStudentVo(paramVo);

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
//		Map<String, Object> resultMap = studentService.getStudentPageList(map);
//		List<StudentVo> pageList = (List<StudentVo>) resultMap.get("pageList");
		List<StudentVo> pageList = studentService.getStudentPageList(map);

//		int totCnt = (int) resultMap.get("totCnt");
		
		/***Then***/
		assertEquals(10, pageList.size());
//		assertEquals(10, totCnt);
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
		int updateCnt = studentService.studentUpdate(studentVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}