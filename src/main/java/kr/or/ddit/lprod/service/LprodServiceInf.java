package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodServiceInf {
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 전체 상품조회
	*/
	List<LprodVo> selectAllLprod();
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC09
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회 
	*/
	List<LprodVo> getStudentPageList(Map<String, Integer> map);
}
