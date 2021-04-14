package com.encocns.enfra.db.dvo;

public class CFW_M_ATCHFILE_DVO {

    private String biz_lcls_cd;     //업무대분류코드
    private String menu_id;        //메뉴ID
    private long file_seq;         //파일순서
    private String file_nm;        //파일명
    private String file_path_cntn; //파일경로내용
    private long file_len;         //파일길이
    private String rmk_cntn;       //비고내용
    private String reg_id;         //등록ID
    private String chg_id;         //변경ID
    
    public String getBiz_lcls_cd() {
        return biz_lcls_cd;
    }
    public void setBiz_lcls_cd(String biz_lcls_cd) {
        this.biz_lcls_cd = biz_lcls_cd;
    }
    public String getMenu_id() {
        return menu_id;
    }
    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }
    public long getFile_seq() {
        return file_seq;
    }
    public void setFile_seq(long file_seq) {
        this.file_seq = file_seq;
    }
    public String getFile_nm() {
        return file_nm;
    }
    public void setFile_nm(String file_nm) {
        this.file_nm = file_nm;
    }
    public String getFile_path_cntn() {
        return file_path_cntn;
    }
    public void setFile_path_cntn(String file_path_cntn) {
        this.file_path_cntn = file_path_cntn;
    }
    public long getFile_len() {
        return file_len;
    }
    public void setFile_len(long file_len) {
        this.file_len = file_len;
    }
    public String getRmk_cntn() {
        return rmk_cntn;
    }
    public void setRmk_cntn(String rmk_cntn) {
        this.rmk_cntn = rmk_cntn;
    }
    public String getReg_id() {
        return reg_id;
    }
    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }
    public String getChg_id() {
        return chg_id;
    }
    public void setChg_id(String chg_id) {
        this.chg_id = chg_id;
    }
}
