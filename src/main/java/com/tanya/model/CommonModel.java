package com.tanya.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonModel {

    @Column(name = "create_dt")
    private LocalDateTime createDt;
    
    @Column(name = "create_by")
    private String createBy;
    
    @Column(name = "update_dt")
    private LocalDateTime updateDt;
    
    @Column(name = "update_by")
    private String updateBy;
}
