package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MsgFileVO {

	private Integer fno, mno;
	private String savename, originname;
	private Date regdate;
}
