package ssg.com.a.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	@Autowired
	SqlSessionTemplate session; // mybatis
	
	String ns = "Bbs."; // Bbs.xml 의 mapper namespace 

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		return session.selectList(ns + "bbslist", param);
	}

	@Override
	public int getallbbs(BbsParam param) {
		return session.selectOne(ns + "getallbbs", param);
	}
	
	
}
