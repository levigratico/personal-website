package com.beverly.personal.common;

import java.util.ArrayList;
import java.util.List;

public class CommonListModel<T> {
	List<T> listOfModel = new ArrayList<>();

	public List<T> getListOfModel() {
		return listOfModel;
	}

	public void setListOfModel(List<T> listOfModel) {
		this.listOfModel = listOfModel;
	}
	
	public T getListOfModel(int index) {
		return listOfModel.get(index);
	}

	public void setListOfModel(T listOfModel) {
		this.listOfModel.add(listOfModel);
	}
	
}
