package com.beverly.personal.interactors.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.beverly.personal.common.ConstString;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.IntroductionModel;
import com.beverly.personal.model.Paragraph;
import com.beverly.personal.model.Skills;
import com.beverly.personal.model.Title;
import com.beverly.personal.util.DBConnect;

public class IntroductionImpl implements Retrieve {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		ResultSet result = sqlOpt.getStatement().executeQuery("SELECT * FROM introduction_tbl");
		IntroductionModel model = new IntroductionModel();
		while(result.next()) {
			 String type = result.getString("type");
			 int id = result.getInt("id");
			 String content = result.getString("content");
			 if(ConstString.TYPE_TITLE.getString().equals(type)) {
				 Title title = new Title();
				 title.setContent(content);
				 title.setId(id);
				 model.setTitle(title);
			 } else if(ConstString.TYPE_PAR.getString().equals(type)) {
				 Paragraph paragraph = new Paragraph();
				 paragraph.setContent(content);
				 paragraph.setId(id);
				 paragraph.setRank(result.getInt("rank"));
				 model.setParagraph(paragraph);
			 } else if(ConstString.TYPE_SKILLS.getString().equals(type)) {
				Skills skills = new Skills();
				skills.setContent(content);
				skills.setId(id);
				model.setSkills(skills);
			 }
		}
		sqlOpt.closeConnection();
		return model;
	}

	@Override
	public Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public Object findByWhere(DBConnect sqlOpt, Map<String, Object> where)
			throws ClassNotFoundException, SQLException {
		return null;
	}

	

	
	
}
