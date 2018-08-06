package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceTest {
	private LprodServiceInf lprodService;
	

	@Before
	public void setup(){
		lprodService  = new LprodService();
	}
	
	@Test
	public void selectAllLprodtest() {
		/***Given***/

		/***When***/
		List<LprodVo> lprodList = lprodService.selectAllLprod();
		
		for (LprodVo vo : lprodList) {
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(13, lprodList.size());
	}
	
	@Test
	public void getLprodPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("lpage", 1);
		map.put("lpagesize", 10);

		/***When***/
		List<LprodVo> pageList = lprodService.getStudentPageList(map);
		
		/***Then***/
		assertEquals(10, pageList.size());
	}
}
