package ssg.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{


	@Autowired
	SqlSession session;
	// SqlSessionTemplate -> mybatis

	String ns = "Member."; // member.xml 에 mapper namespace 맞춰준?
	
	@Override
	public int idcheck(String id) {
		int count = session.selectOne(ns + "idcheck", id); // member.xml 참고해서 작성 
		return count;
	}

	@Override
	public int addmember(MemberDto dto) {
		return session.insert(ns+"addmember", dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return session.selectOne(ns + "login", dto);
	}
	
	
	
	
}
