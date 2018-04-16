package com.sp.domain;

import lombok.Data;

@Data
public class User extends Common {

	private String usrLgn;
	private String usrNm;
	private String usrEml;
	private String usrTel;
	private String crtDt;

}
