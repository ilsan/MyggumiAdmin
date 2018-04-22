package com.sp.domain;

import lombok.Data;

/**
 * @author ShipJH
 * 공통코드 VO
 */
@Data
public class CommonCode {

	/**
	* 코드 */
	private String comCd;

	/**
	* 상위코드 */
	private String comCdRef;

	/**
	* 코드명 */
	private String comNm;

	/**
	* 진열순서 */
	private String displayNo;

	/**
	* 사용유무 */
	private String useYn;

}
