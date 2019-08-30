package spring.biz.board.dao;

import java.util.List;

import spring.biz.board.vo.BoardVO;

public interface BoardDAO {
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(int seq);
	BoardVO getBoard(int seq);
	List<BoardVO> getBoardList();
}
