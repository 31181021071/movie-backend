package com.tanya.dto.usermanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchUserResultDto {

	private String name;
    private String email;
    private boolean isEnable;
    private int id;
    private String createDt;
}
