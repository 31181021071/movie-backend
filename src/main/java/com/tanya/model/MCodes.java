package com.tanya.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_codes")
@Getter
@Setter
@IdClass(MCodesId.class)
public class MCodes extends CommonModel {

	@Id
    @Column(name = "code_type")
    private String codeType;

    @Id
    @Column(name = "code_type_name")
    private String codeTypeName;

    @Id
    @Column(name = "code")
    private String code;

    @Id
    @Column(name = "code_name")
    private String codeName;

    @Column(name = "is_show")
    private Boolean isShow;
}
