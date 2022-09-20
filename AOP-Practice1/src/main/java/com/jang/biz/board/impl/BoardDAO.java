//package com.jang.biz.board.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Repository;
//
//import com.jang.biz.board.BoardVO;
//
//public class BoardDAO {
//	Connection conn;
//	PreparedStatement pstmt;
//	
//	final String sql_insert ="INSERT INTO BOARD (TITLE,WRITER,CONTENT) VALUES (?,?,?)";
//	final String sql_update ="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
//	final String sql_delete = "DELETE FROM BOARD WHERE BID=?";
//	final String sql_selectOne ="SELECT * FROM BOARD WHERE BID =?";
//	final String sql_selectAll = "SELECT * FROM BOARD";
//	
//	void insertBoard(BoardVO vo) {
//		conn = com.jang.biz.common.JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement(sql_insert);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
//			int num = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
//		}
//	}
//	
//	void updateBoard(BoardVO vo) {
//		conn = com.jang.biz.common.JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement(sql_update);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getContent());
//			pstmt.setInt(3, vo.getBid());
//			int num = pstmt.executeUpdate();
//			
//		}catch (SQLException e){
//			e.printStackTrace();
//		}finally {
//			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
//		}
//	}
//	
//	void deleteBoard(BoardVO vo) {
//		conn = com.jang.biz.common.JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement(sql_delete);
//			pstmt.setInt(1, vo.getBid());
//			pstmt.executeUpdate();
//			
//		}catch (SQLException e){
//			e.printStackTrace();
//		}finally {
//			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
//		}
//	}
//	
//	BoardVO selectOneBoard(BoardVO vo) {
//		conn = com.jang.biz.common.JDBCUtil.connect();
//		try {
//			pstmt = conn.prepareStatement(sql_selectOne);
//			pstmt.setInt(1, vo.getBid());
//			ResultSet rs = pstmt.executeQuery();
//			BoardVO vo1 = new BoardVO();
//			if(rs.next()) {
//				vo1.setBid(rs.getInt("BID"));
//				vo1.setTitle(rs.getString("TITLE"));
//				vo1.setWriter(rs.getString("WRITER"));
//				vo1.setContent(rs.getString("CONTENT"));
//				vo1.setCnt(rs.getInt("CNT"));
//				vo1.setRegdate(rs.getString("REGDATE"));
//				return vo1;
//			}			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("로그 : 사용자의 정보 반환 실패");
//			e.printStackTrace();
//			return null;
//		}finally {
//			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
//		}
//		return null;
//	}
//	
//	public ArrayList<BoardVO> selectAllBoard(BoardVO vo) {
//		conn = com.jang.biz.common.JDBCUtil.connect();
//		
//		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
//		
//		System.out.println("로그: selectAll 진입");
//		
//		try {
//			pstmt = conn.prepareStatement(sql_selectAll);
//			ResultSet rs = pstmt.executeQuery();
//			System.out.println("로그: selectAll 사용");
//			while(rs.next()) {
//				System.out.println("로그: while문 진입");
//				BoardVO vo1 = new BoardVO();
//				vo1.setBid(rs.getInt("BID"));
//				vo1.setTitle(rs.getString("TITLE"));
//				vo1.setWriter(rs.getString("WRITER"));
//				vo1.setContent(rs.getString("CONTENT"));
//				vo1.setCnt(rs.getInt("CNT"));
//				vo1.setRegdate(rs.getString("REGDATE"));
//				datas.add(vo1);
//			}
//			
//			return datas;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
//		}
//		
//		System.out.println("로그: null은 아니겠지");
//		return null;
//	}
//}
