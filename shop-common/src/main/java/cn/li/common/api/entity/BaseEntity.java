package cn.li.common.api.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {

	private Integer id;
	private Timestamp created;
	private Timestamp updated;
	
}
