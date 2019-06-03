package org.zerock.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MsgVO {
	
	private Integer mno;
	String sender, whom, msg, gubun;
	Date regdate;

	private List<MsgFileVO> files;
	
	public MsgVO() {
		files = new ArrayList<>();
	}
	
	public void addFile(MsgFileVO vo ) {
		this.files.add(vo);
	}
}
