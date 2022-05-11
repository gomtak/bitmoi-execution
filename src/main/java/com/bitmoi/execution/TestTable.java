package com.bitmoi.execution;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Table("TestTable")
public class TestTable {
    @Id
    @Column("id")
    private long id;
    @Column("name")
    private String name;

}
