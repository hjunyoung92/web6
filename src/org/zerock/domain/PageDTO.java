package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private boolean prev, next;
	private int current, start, end, total;
	
	public PageDTO(int current, int total) {
		super();
		this.current = current;
		this.total = total;
		
		int tempEnd = (int)(Math.ceil(current/10.0) * 10);
		start = tempEnd - 9;
		
		prev = start != 1;
		
		if( (tempEnd * 10) > total ) {
			end = (int)(Math.ceil(total/10.0));
		}else {
			end = tempEnd;
		}
		
		next = (tempEnd * 10) < total;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new PageDTO(3,101));
	}
	
}