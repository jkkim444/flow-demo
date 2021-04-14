package com.encocns.enfra.core.component.vo;

import java.util.Arrays;

public class FileVO {

    private String id;
    private String name;
    private String type;

    private String biz_lcls_cd;
    private String scr_id;
    private String file_cpnt_id;
    private int file_seq;
    private long file_size;
    private String str_file_size;
    private String file_nm;
    private String file_real_nm;
    private String file_path_cntn;
    private String upload_path;
    private byte[] fileByte;
    private String session_id;
    private String year;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBiz_lcls_cd() {
        return biz_lcls_cd;
    }
    public void setBiz_lcls_cd(String biz_lcls_cd) {
        this.biz_lcls_cd = biz_lcls_cd;
    }
    public String getScr_id() {
        return scr_id;
    }
    public void setScr_id(String scr_id) {
        this.scr_id = scr_id;
    }
    public String getFile_cpnt_id() {
        return file_cpnt_id;
    }
    public void setFile_cpnt_id(String file_cpnt_id) {
        this.file_cpnt_id = file_cpnt_id;
    }
    public int getFile_seq() {
        return file_seq;
    }
    public void setFile_seq(int file_seq) {
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
    public byte[] getFileByte() {
        return fileByte;
    }
    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }
    public long getFile_size() {
        return file_size;
    }
    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }
    public String getUpload_path() {
        return upload_path;
    }
    public void setUpload_path(String upload_path) {
        this.upload_path = upload_path;
    }
    public String getSession_id() {
        return session_id;
    }
    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getFile_real_nm() {
        return file_real_nm;
    }
    public void setFile_real_nm(String file_real_nm) {
        this.file_real_nm = file_real_nm;
    }
    
    public String getStr_file_size() {
        return str_file_size;
    }
    public void setStr_file_size(String str_file_size) {
        this.str_file_size = str_file_size;
    }
    @Override
    public String toString() {
        return "FileVO [biz_lcls_cd=" + biz_lcls_cd + ", scr_id=" + scr_id
                + ", file_cpnt_id=" + file_cpnt_id + ", file_seq=" + file_seq
                + ", file_size=" + file_size + ", file_nm=" + file_nm
                + ", file_path_cntn=" + file_path_cntn + ", upload_path="
                + upload_path + ", fileByte=" + Arrays.toString(fileByte)
                + ", session_id=" + session_id + ", year=" + year + "]";
    }

}
