package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.sist.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> boardListData(int start);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	
	// 상세보기
	public BoardVO boardDetailData(int no);
	// 답변하기
	public void boardReplyInsert(int pno, BoardVO vo);
	
	// 수정하기
	public void boardUpdateData(int no, BoardVO vo);

}
