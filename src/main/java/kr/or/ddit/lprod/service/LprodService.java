package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodService implements LprodServiceInf {

	@Override
	public List<LprodVo> selectAllLprod() {
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.selectAllLprod();
	}

	@Override
	public List<LprodVo> getStudentPageList(Map<String, Integer> map) {
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.getStudentPageList(map);
	}

}
