/**
 * 
 */
package com.sp.domain;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author ShipJH
 * 공통적으로 들어갈 VO 변수
 */

@Data
public class Common {
	/** 등록자 */
	private String regUser;
	
	/** 등록일 */
	private LocalDateTime regDate;
	
	/** 수정자 */
	private String updUser;
	
	/** 수정일 */
	private LocalDateTime updDate;
}
