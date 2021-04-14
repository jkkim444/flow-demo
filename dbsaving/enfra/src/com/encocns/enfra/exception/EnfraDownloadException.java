package com.encocns.enfra.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="download error!")
public class EnfraDownloadException extends RuntimeException {

    private static final long serialVersionUID = 6633997105239790412L;
    
    private String err_cd;
	private String param;
	private String[] params;
	private String err_cntn;

	public EnfraDownloadException(){}

	public EnfraDownloadException( String err_cd )
	{
		this.err_cd = err_cd;
		this.err_cntn = EnfraMessage.getMessage(err_cd);
	}


	public EnfraDownloadException( String err_cd, String param )
	{
		this.err_cd = err_cd;
		this.param = param;
		this.err_cntn = EnfraMessage.getMessage(err_cd, new String[]{param});

	}

	public EnfraDownloadException( String err_cd, String[] params )
	{
		this.err_cd = err_cd;
		this.params = params;
		this.err_cntn = EnfraMessage.getMessage(err_cd, params);
	}

	@Override
	public String getMessage() {
		return this.getErr_cntn();
	}

	public String getErr_cd() {
		return err_cd;
	}

	public void setErr_cd(String err_cd) {
		this.err_cd = err_cd;
	}

	@SuppressWarnings("unused")
    private String getParam() {
		return param;
	}

	@SuppressWarnings("unused")
    private void setParam(String param) {
		this.param = param;
	}

	@SuppressWarnings("unused")
    private String[] getParams() {
		return params;
	}

	@SuppressWarnings("unused")
    private void setParams(String[] params) {
		this.params = params;
	}

	private String getErr_cntn() {
		return err_cntn;
	}

	@SuppressWarnings("unused")
    private void setErr_cntn(String err_cntn) {
		this.err_cntn = err_cntn;
	}

}
