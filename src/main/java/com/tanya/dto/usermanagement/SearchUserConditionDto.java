package com.tanya.dto.usermanagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserConditionDto {

	public String name;
	
	public String email;
	
	int page;
	
	int size;
}
