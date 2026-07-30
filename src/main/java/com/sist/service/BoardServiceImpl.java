package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

import lombok.RequiredArgsConstructor;

/*
 * 	Mapper : 데이터베이스 연결
 * 		=> 메뉴
 * 	Service : 여러개의 SQL문장 조합해서 결과물 => BI(기능 통합)
 * 		=> 주방
 *  Controller : Service에서 제공하는 결과값을 => 브라우저로 전송
 *  	=> 서빙
 *  JSP => 손님
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper mapper; // 스프링에서 주소값 제공 
	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return mapper.boardListData(start);
	}

	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return mapper.boardRowCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

	@Override
	@Transactional
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}

	@Override
	@Transactional // => AOP 적용
	/*	외부(메소드 접근 전) 내부(메소드 안)
	 * 	  | 인터셉트		| AOP => Transaction, Log
	 * 	  | 자동 로그인 / 알림 
	 * 	public void boardReplyInsert(int pno, BoardVO vo) {
	 * 		@Before => session.openSession()
	 * 		try{
	 * 			connection.setAutoCommit(false)
	 * 			BoardVO pvo=mapper.boardParentInfoData(pno);			
	 * 			mapper.boardStepIncrement(pvo.getGroup_id(), pvo.getGroup_step());
	 * 			mapper.boardReplyInsert(vo);
	 * 			mapper.boardDepthIncrement(pno);
	 * 			conn.commit();
	 * 		}catch(Exception e){
	 * 			conn.rollback() => @AfterThrowing
	 * 		}
	 * 		finally {
	 * 			conn.setAutoCommit(true) => @After
	 * 		}
	 * 	}
	 */
	public void boardReplyInsert(int pno, BoardVO vo) {
		// TODO Auto-generated method stub
		BoardVO pvo=mapper.boardParentInfoData(pno);
		
		mapper.boardStepIncrement(pvo.getGroup_id(), pvo.getGroup_step());
		
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		vo.setDepth(0);
		
		mapper.boardReplyInsert(vo);
		
		mapper.boardDepthIncrement(pno);
	}

}
