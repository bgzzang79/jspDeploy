package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	/**
	 * Method : selectAllStudent
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회
	 */
	@Override
	public List<StudentVo> selectAllStudent() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudent");
		session.close();
		
		return studentList;
	}
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC09
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 학생 정보 조회
	*/
	@Override
	public List<StudentVo> getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudent",id);
		session.close();
		
		return studentList;
	}
	/**
	* Method : getStudentVo
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC09
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생 정보 조회
	*/
	@Override
	public StudentVo getStudentVo(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo stdVo = session.selectOne("student.getStudentVo",studentVo);
		session.close();
		
		return stdVo;
	}
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList",map);
		
		session.close();
		
		return studentList;
	}

	@Override
	public StudentVo getStudent2(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudent",id);
		session.close();
		
		return studentVo;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("student.studentUpdate",studentVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}
}