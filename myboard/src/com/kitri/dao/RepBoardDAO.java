package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;

public class RepBoardDAO {
	public void insert(RepBoard repBoard) throws AddException{
		String insertSQL = 
	"insert into repboard("
	+"BOARD_SEQ, PARENT_SEQ, BOARD_SUBJECT, BOARD_WRITER,BOARD_CONTENTS,  BOARD_DATE,BOARD_PASSWORD,BOARD_VIEWCOUNT)"
	+" values(BOARD_SEQ.NEXTVAL, ?,      ?,            ?,             ?,systimestamp,             ?,           0)";
		System.out.println(insertSQL);
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			//1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2)DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "test";
			String password = "test";
			con = DriverManager.getConnection(url, user, password);
			System.out.println(repBoard);
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, repBoard.getParent_seq());
			pstmt.setString(2, repBoard.getBoard_subject());
			pstmt.setString(3, repBoard.getBoard_writer());
			pstmt.setString(4, repBoard.getBoard_contents());
			pstmt.setString(5, repBoard.getBoard_password());			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<RepBoard> selectByRows(int startRow, int endRow){
		List<RepBoard> list = new ArrayList<>();
		
		String selectByRowsSQL = "SELECT board_seq\r\n" + 
				"FROM (SELECT rownum r, repboard.*\r\n" + 
				"      FROM repboard\r\n" + 
				"      START WITH parent_seq=0\r\n" + 
				"      CONNECT BY PRIOR board_seq=parent_seq)\r\n" + 
				"WHERE r BETWEEN ? AND ?";
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			//1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2)DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "test";
			String password = "test";
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(selectByRowsSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.executeQuery();
		return list;
	}
	public static void main(String[] args) {
		RepBoardDAO dao = new RepBoardDAO();
		RepBoard repBoard = new RepBoard();
		repBoard.setBoard_subject("테스트제목");
		repBoard.setBoard_writer("test");
		repBoard.setBoard_contents("테스트내용");
		repBoard.setBoard_password("testp");
		//repBoard.setParent_seq(1); //답글쓰기용 테스트
		try {
			dao.insert(repBoard); //글쓰기용 테스트
		} catch (AddException e) {
			e.printStackTrace();
		}		
	}
	 
}
