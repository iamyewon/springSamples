package ssg.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import ssg.com.a.dto.MemberDto;

public interface MemberDao {
	
	int idcheck(String id);
	
	int addmember(MemberDto dto);

	MemberDto login(MemberDto dto);
}
