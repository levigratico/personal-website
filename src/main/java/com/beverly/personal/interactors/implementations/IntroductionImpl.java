package com.beverly.personal.interactors.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.common.ConstString;
import com.beverly.personal.common.Operations;
import com.beverly.personal.interactors.interfaces.Manipulate;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.IntroductionModel;
import com.beverly.personal.model.Paragraph;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.Skills;
import com.beverly.personal.model.TableWithId;
import com.beverly.personal.model.Title;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.QueryBuilder;
import com.beverly.personal.util.SQLBuilder;

public class IntroductionImpl implements Retrieve, Manipulate {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		SQLBuilder builder = new SQLBuilder();
		ResultSet result = sqlOpt.getStatement().executeQuery(builder.selectAll().from("introduction_tbl").build());
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
	public Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public boolean updateById(DBConnect sqlOpt, List<InsertObject> data, TableWithId tblid)
			throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		SQLBuilder builder = updateBuilder(data, tblid);
		PreparedStatement preparedStatement = sqlOpt.getPrepareStatement(builder.buildUpdate());
		boolean isUpdate = QueryBuilder.setPreparedQuery(preparedStatement, builder.getValue()).execute();
		sqlOpt.closeConnection();
		return isUpdate;
	}

	private SQLBuilder updateBuilder(List<InsertObject> data, TableWithId tblid) {
		QueryObject opt = new QueryObject();
		opt.setColumn("id");
		opt.setDatum(tblid.getId());
		opt.setOpt(Operations.EQ);
		SQLBuilder builder = new SQLBuilder().update(tblid.getTable()).prepareUpdateData(data).where(opt);
		return builder;
	}

	
	
}
