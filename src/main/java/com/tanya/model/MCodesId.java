package com.tanya.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MCodesId implements Serializable {

	private String codeType;
    private String codeTypeName;
    private String code;
    private String codeName;
    private boolean isShow;
}
