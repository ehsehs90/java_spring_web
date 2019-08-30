package spring.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.board.dao.BoardDAO;
import spring.biz.board.vo.BoardVO;

@Component("boardservice")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardspring")
	BoardDAO dao = null;
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return dao.getBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

}
