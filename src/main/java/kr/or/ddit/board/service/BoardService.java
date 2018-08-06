package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {

	/**
	* Method : getBoardList
	* 최초작성일 : 2018. 7. 5.
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 목록 조회
	*/
	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		//db에서 조회가 되었다고 가정하고 임의의 값을 리턴
		boardList.add(new BoardVo("글1","내용1","brown1","곰1",new Date()));
		boardList.add(new BoardVo("글2","내용2","brown2","곰2",new Date()));
		boardList.add(new BoardVo("글3","내용3","brown3","곰3",new Date()));
		boardList.add(new BoardVo("글4","내용4","brown4","곰4",new Date()));
		boardList.add(new BoardVo("글5","내용5","brown5","곰5",new Date()));
		
		
		return boardList;
	}

}
