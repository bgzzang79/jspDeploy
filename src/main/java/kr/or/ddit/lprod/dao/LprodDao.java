package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LprodDao implements LprodDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 전체 상품 조회
	*/
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.selectAllLprod");
		session.close();
		
		return lprodList;
	}
	@Override
	public List<LprodVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.getLprodPageList",map);
		session.close();
		
		return lprodList;
	}
}