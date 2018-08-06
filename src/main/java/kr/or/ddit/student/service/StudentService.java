package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {
	
	
	@Override
	public List<StudentVo> selectAllStudent() {
		StudentDaoInf studentDao  = new StudentDao();
		return studentDao.selectAllStudent();
	}

	@Override
	public List<StudentVo> getStudent(int id) {
		StudentDaoInf studentDao  = new StudentDao();
		return studentDao.getStudent(id);
	}

	@Override
	public StudentVo getStudentVo(StudentVo studentVo) {
		StudentDaoInf studentDao  = new StudentDao();
		return studentDao.getStudentVo(studentVo);		
	}

	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
//	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		StudentDaoInf studentDao  = new StudentDao();
		
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		int studentCnt = studentDao.selectAllStudent().size();
		
//		resultMap.put("totCnt", studentCnt);
		
		
		//페이지 네비게이션 html 생성
//		int pageSize = map.get("pagesize");
//		
//		int cnt = totCnt / pageSize;	//몫
//		int mod = totCnt % pageSize;	//나머지
//		
//		if(mod > 0){
//			cnt++;
//		}
		
//		StringBuffer pageNaviStr = new StringBuffer();
//		
//		for (int i = 1; i < cnt; i++) {
//			pageNaviStr.append("<li><a href=\"#\">"+i+"</a></li>");
//		}
//		resultMap.put("pageNavi",pageNaviStr.toString());
		
//		return resultMap;
		
		return studentDao.getStudentPageList(map);
	}

	@Override
	public StudentVo getStudent2(int id) {
		StudentDaoInf studentDao  = new StudentDao();
		return studentDao.getStudent2(id);
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.studentUpdate(studentVo);
		
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC09
	* 변경이력 :
	* @param page
	* @param pagesize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성(미완성)
	*/
//	private String makePageNavi(int page, int pagesize, int totCnt){
//		
//		return null;		
//	}

}
