package com.beverly.personal.interactors.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.Contact;
import com.beverly.personal.model.PersonalSkills;
import com.beverly.personal.model.Primary;
import com.beverly.personal.model.ProfileModel;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.Secondary;
import com.beverly.personal.model.TechnicalSkills;
import com.beverly.personal.model.Tertiary;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.SQLBuilder;

public class ProfileImpl implements Retrieve {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		String query = retrivedBasic();
	 	ResultSet rs = sqlOpt.getStatement().executeQuery(query);
	 	ProfileModel pm = createProfile(rs);
	 	String educSql = retrivedEduc();
	 	ResultSet educRs = sqlOpt.getStatement().executeQuery(educSql);
	 	ProfileModel finalModel = addEduc(educRs, pm);
		sqlOpt.closeConnection();
		return finalModel;
	}

	@Override
	public Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException {
		return null;
	}
	
	private String retrivedBasic() {
		SQLBuilder builder = new SQLBuilder();
		return builder.customQuery("SELECT a.*, b.type FROM profile_content_tbl a INNER JOIN profile_type_tbl b ON a.profile_type_id = b.id").getQuery();
	}
	
	private String retrivedEduc() {
		SQLBuilder builder = new SQLBuilder();
		return builder.selectAll().from("education_tbl").build();
	}
	
	private ProfileModel createProfile(ResultSet rs) throws SQLException {
		ProfileModel profileModel = new ProfileModel();
		while(rs.next()) {
			int temp = rs.getInt("profile_type_id");
			if(temp == 1) {
				Contact contact = new Contact();
				contact.setContent(rs.getString("content"));
				contact.setId(rs.getInt("id"));
				contact.setTitle(rs.getString("title"));
				profileModel.setContacts(contact);
			} else if(temp == 2) {
				TechnicalSkills ts = new TechnicalSkills();
				ts.setContent(rs.getString("content"));
				ts.setId(rs.getInt("id"));
				profileModel.setTskills(ts);
			} else if(temp == 3) {
				PersonalSkills ps = new PersonalSkills();
				ps.setContent(rs.getString("content"));
				ps.setId(rs.getInt("id"));
				profileModel.setSkills(ps);
			}
		}
		return profileModel;
	}
	
	
	private ProfileModel addEduc(ResultSet rs, ProfileModel model) throws SQLException {
		while(rs.next()) {
			String level = rs.getString("level");
			if("tertiary".equalsIgnoreCase(level)) {
				Tertiary tertiary = new Tertiary();
				tertiary.setAddress(rs.getString("address"));
				tertiary.setContent(rs.getString("school"));
				tertiary.setLevel(level);
				tertiary.setId(rs.getInt("id"));
				tertiary.setDegree(rs.getString("degree"));
				model.setEducation(tertiary);
			} else if("secondary".equalsIgnoreCase(level)) {
				Secondary secondary = new Secondary();
				secondary.setAddress(rs.getString("address"));
				secondary.setContent(rs.getString("school"));
				secondary.setLevel(level);
				secondary.setId(rs.getInt("id"));
				model.setEducation(secondary);
			} else if("primary".equalsIgnoreCase(level)) {
				Primary primary = new Primary();
				primary.setAddress(rs.getString("address"));
				primary.setContent(rs.getString("school"));
				primary.setLevel(level);
				primary.setId(rs.getInt("id"));
				model.setEducation(primary);
			}
		}
		
		return model;
	}

}
