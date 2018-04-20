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
	private String regUser;
	private LocalDateTime regDate;
	private String updUser;
	private LocalDateTime updDate;
}
