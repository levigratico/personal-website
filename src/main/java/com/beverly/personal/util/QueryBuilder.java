package com.beverly.personal.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.beverly.personal.model.UserQueryPreparation;

public class QueryBuilder {
	
	public static UserQueryPreparation build(String sqlQuery, Map<String, Object> where, String separator) {
		UserQueryPreparation userQueryPreparation = new UserQueryPreparation();
		int counter = 1;
		for(Iterator<Entry<String, Object>> map = where.entrySet().iterator(); map.hasNext();) {
			Map.Entry<String, Object> tempMap = map.next();
			sqlQuery += String.format("%s = ?", tempMap.getKey());
			if(counter != where.size()) {
				sqlQuery += separator + " ";
			}
			userQueryPreparation.setData(tempMap.getValue());
			counter++;
		}
		userQueryPreparation.setQuery(sqlQuery);
		return userQueryPreparation;
	}
	
	public static PreparedStatement setPreparedQuery(PreparedStatement sqlQuery, List<Object> data) throws SQLException {
		int counter = 1;
		for(Iterator<Object> datum = data.iterator(); datum.hasNext();) {
			Object tempDatum = datum.next();
			if(tempDatum instanceof Integer) {
				sqlQuery.setInt(counter, (int)tempDatum);
			} else if(tempDatum instanceof String) {
				sqlQuery.setString(counter, (String)tempDatum);
			}
			counter++;
		}
		return sqlQuery;
	}
	
	
}
