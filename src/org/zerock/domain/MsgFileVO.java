package org.zerock.domain;

import java.util.Date;

import lombok.Data;
@Data
public class MsgFileVO {
	
	private Integer fno,mno;
	String savename, originname;
	Date regdate;
	
}
