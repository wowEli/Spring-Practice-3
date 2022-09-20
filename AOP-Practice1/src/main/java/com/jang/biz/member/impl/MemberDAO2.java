package com.jang.biz.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jang.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String sql_signUp ="INSERT INTO MEMBER VALUES (?,?,?,?)";
	final String sql_login ="SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";

	void insertMember(MemberVO vo) {
		jdbcTemplate.update(sql_signUp, vo.getMid(),vo.getMpw(),vo.getName(),vo.getRole());
	}

	MemberVO selectOneMember(MemberVO vo) {
		Object[] args = {vo.getMid(),vo.getMpw()};
		return jdbcTemplate.queryForObject(sql_login, args, new MemberRowMapper());
	}

	class MemberRowMapper implements RowMapper<MemberVO>{

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO data=new MemberVO();
			data.setMid(rs.getNString("MID"));
			data.setMpw(rs.getNString("MPW"));
			data.setName(rs.getNString("NAME"));
			data.setRole(rs.getNString("ROLE"));
			return data;
		}

	}
}
