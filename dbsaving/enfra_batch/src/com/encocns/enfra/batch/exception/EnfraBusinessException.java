package com.encocns.enfra.batch.exception;

public class EnfraBusinessException extends Exception {

    private static final long serialVersionUID = 2776094340591060118L;
    
    private String err_cd;
    @SuppressWarnings("unused")
    private String errCd;
    private String param;
    private String[] params;
    private String err_cntn;
    
    public EnfraBusinessException(){}
    
    public EnfraBusinessException( String err_cd )
    {
        this.err_cd = err_cd;
        
        try
        {
            this.err_cntn = EnfraMessage.getMessage(err_cd);
        }
        catch(Exception e)
        {
            this.err_cntn = err_cd;
        }
    }
    
    public EnfraBusinessException( String err_cd, String param )
    {
        this.err_cd = err_cd;
        this.param = param;
        this.err_cntn = EnfraMessage.getMessage(err_cd, new String[]{param});
        
    }
    
    public EnfraBusinessException( String err_cd, String[] params )
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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getErr_cntn() {
        return err_cntn;
    }

    public void setErr_cntn(String err_cntn) {
        this.err_cntn = err_cntn;
    }

    /**
     * @return the err_cd
     */
    public String getErrCd() {
        return this.err_cd;
    }

}
