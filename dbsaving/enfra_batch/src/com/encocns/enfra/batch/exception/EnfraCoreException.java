package com.encocns.enfra.batch.exception;

public class EnfraCoreException extends RuntimeException {

    private static final long serialVersionUID = 7523829508004226143L;
    
    private String err_cd;
	private String param;
	private String[] params;
	private String err_cntn;

	public EnfraCoreException(){}

	public EnfraCoreException( String err_cd )
	{
		this.err_cd = err_cd;
		this.err_cntn = EnfraMessage.getMessage(err_cd);
	}


	public EnfraCoreException( String err_cd, String param )
	{
		this.err_cd = err_cd;
		this.param = param;
		this.err_cntn = EnfraMessage.getMessage(err_cd, new String[]{param});

	}

	public EnfraCoreException( String err_cd, String[] params )
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

	private String getParam() {
		return param;
	}

	private void setParam(String param) {
		this.param = param;
	}

	private String[] getParams() {
		return params;
	}

	private void setParams(String[] params) {
		this.params = params;
	}

	private String getErr_cntn() {
		return err_cntn;
	}

	private void setErr_cntn(String err_cntn) {
		this.err_cntn = err_cntn;
	}

}
