package com.ravi.contactsapp.command;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCommand {

	@NotBlank
	private String searchString;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

}
