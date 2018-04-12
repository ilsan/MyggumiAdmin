/**
 * 
 */
package com.sp.domain;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author ShipJH
 *
 */

@Data
public class Common {
	private String regUser;
	private LocalDateTime regDate;
	private String updUser;
	private LocalDateTime updDate;
}
