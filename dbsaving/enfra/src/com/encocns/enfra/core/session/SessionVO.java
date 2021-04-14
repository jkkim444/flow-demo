package com.encocns.enfra.core.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class SessionVO implements Serializable {

	private static final long serialVersionUID = 981286446798934822L;

	private String usr_id;
	private String usr_nm;
	private String auth_grp_cd;
	private String brn_cd;
	private String brn_nm;
	private String position;
	private String login_date;
	private String login_time;
	private String scrn_id;
	private String menu_nm;
	private String service_trans_time;
	private String session_id;

	//KPMG
	private String compCd;            /* 회사코드 */
	private String compNm;            /* 회사명 */
	private String compSubnm;         /* 회사명약어 */
	private String parentdeptCd;      /* 상위부서코드 */
	private String parentdeptNm;      /* 상위부서명 */
	private String deptCd;            /* 부서코드 */
	private String deptNm;            /* 부서명 */
	private String deptEnm;           /* IBS 부서명(영문) */
	private String vatDeptCd;         /* IBS 원천세 부서코드 */
	private String vatDeptNm;         /* IBS 원천세 부서명(한글) */
	private String vatDeptEnm;        /* IBS 원천세 부서명(영문) */
	private int empno;                /* 내부KEY */
	private String sno;               /* 사원번호 */
	private String iid;               /* USERID */
	private String empKnm;            /* 한글성명 */
	private String empEnm;            /* 영문성명 */
	private String giDt;              /* 그룹입사일자 */
	private String iDt;               /* 입사일자 */
	private String rDt;               /* 퇴사일자 */
	private String workSt;            /* 재직구분 */
	private String posCd;             /* 직위코드 */
	private String posKnm;            /* 직위명(한글) */
	private String posEnm;            /* 직위명(영문) */
	private String posSubnm;          /* 직위명(약어) */
	private String dutyCd0;           /* 직책코드 */
	private String dutyNm0;           /* 직책명 */
	private String dutyCd1;           /* 직책코드1 */
	private String dutyNm1;           /* 직책명1 */
	private String dutyCd2;           /* 직책코드2 */
	private String dutyNm2;           /* 직책명2 */
	private String dutyCd3;           /* 직책코드3 */
	private String dutyNm3;           /* 직책명3 */
	private String dutyCd4;           /* 직책코드4 */
	private String dutyNm4;           /* 직책명4 */
	private String dutyCd5;           /* 직책코드5 */
	private String dutyNm5;           /* 직책명5 */
	private String empgroupCd;        /* 직군코드 */
	private String empgroupNm;        /* 직군명 */
	private String empRrn;            /* 주민번호 */
	private String secGb;             /* 성별 */
	private String birthDt;           /* 생년월일 */
	private String telNo;             /* 집전화번호 */
	private String extNo;             /* 내선번호 */
	private String mobileNo;          /* 휴대폰번호 */
	private String officeLocation;    /* 근무위치 */
	private String addr;              /* 집주소 */
	private String email;             /* 이메일주소 */
	private String emptypeCd;         /* 직종코드 */
	private String emptypeNm;         /* 직종명 */
	private String empsubgroupCd;     /* 하위직종코드 */
	private String empsubgroupNm;     /* 하위직종명 */
	private String actionreason;      /* */
	private String actionreasonNm;    /* */
	private String activitytypeCd;    /* */
	private String activitytypeNm;    /* */
	private int managerEmpno;         /* */
	private String positionCd;        /* 직급코드 */
	private String positionNm;        /* 직급명 */
	private String personnelareaCd;   /* */
	private String personnelareaNm;   /* */
	private String profitDeptCd;      /* */
	private String zipNo;             /* 우편번호 */
	private String profitDeptNm;

    private ArrayList<HashMap<String,Object>> epList;
    private ArrayList<HashMap<String,Object>> assignmentList;
    private ArrayList<HashMap<String,Object>> idlDeptList;


	@SuppressWarnings("rawtypes")
	private Vector role;
	private boolean sso;

	public String getUserId() {
		return usr_id;
	}

	public void setUserId(String usr_id) {
		this.usr_id = usr_id;
	}

	public String getUserName() {
		return usr_nm;
	}

	public void setUserName(String usr_nm) {
		this.usr_nm = usr_nm;
	}

	public String getAuthGrpCd() {
		return auth_grp_cd;
	}

	public void setAuthGrpCd(String auth_grp_cd) {
		this.auth_grp_cd = auth_grp_cd;
	}

	public String getBranchCode() {
		return brn_cd;
	}

	public void setBranchCode(String brn_cd) {
		this.brn_cd = brn_cd;
	}

	public String getBranchName() {
		return brn_nm;
	}

	public void setBranchName(String brn_nm) {
		this.brn_nm = brn_nm;
	}

	public String getLoginDate() {
		return login_date;
	}

	public void setLoginDate(String login_date) {
		this.login_date = login_date;
	}

	public String getLoginTime() {
		return login_time;
	}

	public void setLoginTime(String login_time) {
		this.login_time = login_time;
	}

	public String getScrn_id() {
		return scrn_id;
	}

	public void setScrn_id(String scrn_id) {
		this.scrn_id = scrn_id;
	}

	public String getMenuName() {
		return menu_nm;
	}

	public void setMenuName(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getServiceTransTime() {
		return this.service_trans_time;
	}

	public void setServiceTransTime(String service_trans_time) {
		this.service_trans_time = service_trans_time;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean getSso() {
		return sso;
	}

	public void setSso(boolean sso) {
		this.sso = sso;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	@SuppressWarnings("rawtypes")
	public Vector getRole() {
		return role;
	}

	@SuppressWarnings("rawtypes")
	public void setRole(Vector role) {
		this.role = role;
	}

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_nm() {
        return usr_nm;
    }

    public void setUsr_nm(String usr_nm) {
        this.usr_nm = usr_nm;
    }

    public String getAuth_grp_cd() {
        return auth_grp_cd;
    }

    public void setAuth_grp_cd(String auth_grp_cd) {
        this.auth_grp_cd = auth_grp_cd;
    }

    public String getBrn_cd() {
        return brn_cd;
    }

    public void setBrn_cd(String brn_cd) {
        this.brn_cd = brn_cd;
    }

    public String getBrn_nm() {
        return brn_nm;
    }

    public void setBrn_nm(String brn_nm) {
        this.brn_nm = brn_nm;
    }

    public String getLogin_date() {
        return login_date;
    }

    public void setLogin_date(String login_date) {
        this.login_date = login_date;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getMenu_nm() {
        return menu_nm;
    }

    public void setMenu_nm(String menu_nm) {
        this.menu_nm = menu_nm;
    }

    public String getService_trans_time() {
        return service_trans_time;
    }

    public void setService_trans_time(String service_trans_time) {
        this.service_trans_time = service_trans_time;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getEmpKnm() {
        return empKnm;
    }

    public void setEmpKnm(String empKnm) {
        this.empKnm = empKnm;
    }

    public String getEmpEnm() {
        return empEnm;
    }

    public void setEmpEnm(String empEnm) {
        this.empEnm = empEnm;
    }

    public String getProfitDeptCd() {
        return profitDeptCd;
    }

    public void setProfitDeptCd(String profitDeptCd) {
        this.profitDeptCd = profitDeptCd;
    }

    public String getProfitDeptNm() {
        return profitDeptNm;
    }

    public void setProfitDeptNm(String profitDeptNm) {
        this.profitDeptNm = profitDeptNm;
    }

    public String getCompCd() {
        return compCd;
    }

    public void setCompCd(String compCd) {
        this.compCd = compCd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public ArrayList<HashMap<String, Object>> getEpList() {
        return epList;
    }

    public void setEpList(ArrayList<HashMap<String, Object>> epList) {
        this.epList = epList;
    }

    public String getCompNm() {
        return compNm;
    }

    public void setCompNm(String compNm) {
        this.compNm = compNm;
    }

    public String getCompSubnm() {
        return compSubnm;
    }

    public void setCompSubnm(String compSubnm) {
        this.compSubnm = compSubnm;
    }

    public String getParentdeptCd() {
        return parentdeptCd;
    }

    public void setParentdeptCd(String parentdeptCd) {
        this.parentdeptCd = parentdeptCd;
    }

    public String getParentdeptNm() {
        return parentdeptNm;
    }

    public void setParentdeptNm(String parentdeptNm) {
        this.parentdeptNm = parentdeptNm;
    }

    public String getDeptEnm() {
        return deptEnm;
    }

    public void setDeptEnm(String deptEnm) {
        this.deptEnm = deptEnm;
    }

    public String getVatDeptCd() {
        return vatDeptCd;
    }

    public void setVatDeptCd(String vatDeptCd) {
        this.vatDeptCd = vatDeptCd;
    }

    public String getVatDeptNm() {
        return vatDeptNm;
    }

    public void setVatDeptNm(String vatDeptNm) {
        this.vatDeptNm = vatDeptNm;
    }

    public String getVatDeptEnm() {
        return vatDeptEnm;
    }

    public void setVatDeptEnm(String vatDeptEnm) {
        this.vatDeptEnm = vatDeptEnm;
    }

    public String getGiDt() {
        return giDt;
    }

    public void setGiDt(String giDt) {
        this.giDt = giDt;
    }

    public String getiDt() {
        return iDt;
    }

    public void setiDt(String iDt) {
        this.iDt = iDt;
    }

    public String getrDt() {
        return rDt;
    }

    public void setrDt(String rDt) {
        this.rDt = rDt;
    }

    public String getWorkSt() {
        return workSt;
    }

    public void setWorkSt(String workSt) {
        this.workSt = workSt;
    }

    public String getPosCd() {
        return posCd;
    }

    public void setPosCd(String posCd) {
        this.posCd = posCd;
    }

    public String getPosKnm() {
        return posKnm;
    }

    public void setPosKnm(String posKnm) {
        this.posKnm = posKnm;
    }

    public String getPosEnm() {
        return posEnm;
    }

    public void setPosEnm(String posEnm) {
        this.posEnm = posEnm;
    }

    public String getPosSubnm() {
        return posSubnm;
    }

    public void setPosSubnm(String posSubnm) {
        this.posSubnm = posSubnm;
    }

    public String getDutyCd0() {
        return dutyCd0;
    }

    public void setDutyCd0(String dutyCd0) {
        this.dutyCd0 = dutyCd0;
    }

    public String getDutyNm0() {
        return dutyNm0;
    }

    public void setDutyNm0(String dutyNm0) {
        this.dutyNm0 = dutyNm0;
    }

    public String getDutyCd1() {
        return dutyCd1;
    }

    public void setDutyCd1(String dutyCd1) {
        this.dutyCd1 = dutyCd1;
    }

    public String getDutyNm1() {
        return dutyNm1;
    }

    public void setDutyNm1(String dutyNm1) {
        this.dutyNm1 = dutyNm1;
    }

    public String getDutyCd2() {
        return dutyCd2;
    }

    public void setDutyCd2(String dutyCd2) {
        this.dutyCd2 = dutyCd2;
    }

    public String getDutyNm2() {
        return dutyNm2;
    }

    public void setDutyNm2(String dutyNm2) {
        this.dutyNm2 = dutyNm2;
    }

    public String getDutyCd3() {
        return dutyCd3;
    }

    public void setDutyCd3(String dutyCd3) {
        this.dutyCd3 = dutyCd3;
    }

    public String getDutyNm3() {
        return dutyNm3;
    }

    public void setDutyNm3(String dutyNm3) {
        this.dutyNm3 = dutyNm3;
    }

    public String getDutyCd4() {
        return dutyCd4;
    }

    public void setDutyCd4(String dutyCd4) {
        this.dutyCd4 = dutyCd4;
    }

    public String getDutyNm4() {
        return dutyNm4;
    }

    public void setDutyNm4(String dutyNm4) {
        this.dutyNm4 = dutyNm4;
    }

    public String getDutyCd5() {
        return dutyCd5;
    }

    public void setDutyCd5(String dutyCd5) {
        this.dutyCd5 = dutyCd5;
    }

    public String getDutyNm5() {
        return dutyNm5;
    }

    public void setDutyNm5(String dutyNm5) {
        this.dutyNm5 = dutyNm5;
    }

    public String getEmpgroupCd() {
        return empgroupCd;
    }

    public void setEmpgroupCd(String empgroupCd) {
        this.empgroupCd = empgroupCd;
    }

    public String getEmpgroupNm() {
        return empgroupNm;
    }

    public void setEmpgroupNm(String empgroupNm) {
        this.empgroupNm = empgroupNm;
    }

    public String getEmpRrn() {
        return empRrn;
    }

    public void setEmpRrn(String empRrn) {
        this.empRrn = empRrn;
    }

    public String getSecGb() {
        return secGb;
    }

    public void setSecGb(String secGb) {
        this.secGb = secGb;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getExtNo() {
        return extNo;
    }

    public void setExtNo(String extNo) {
        this.extNo = extNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmptypeCd() {
        return emptypeCd;
    }

    public void setEmptypeCd(String emptypeCd) {
        this.emptypeCd = emptypeCd;
    }

    public String getEmptypeNm() {
        return emptypeNm;
    }

    public void setEmptypeNm(String emptypeNm) {
        this.emptypeNm = emptypeNm;
    }

    public String getEmpsubgroupCd() {
        return empsubgroupCd;
    }

    public void setEmpsubgroupCd(String empsubgroupCd) {
        this.empsubgroupCd = empsubgroupCd;
    }

    public String getEmpsubgroupNm() {
        return empsubgroupNm;
    }

    public void setEmpsubgroupNm(String empsubgroupNm) {
        this.empsubgroupNm = empsubgroupNm;
    }

    public String getActionreason() {
        return actionreason;
    }

    public void setActionreason(String actionreason) {
        this.actionreason = actionreason;
    }

    public String getActionreasonNm() {
        return actionreasonNm;
    }

    public void setActionreasonNm(String actionreasonNm) {
        this.actionreasonNm = actionreasonNm;
    }

    public String getActivitytypeCd() {
        return activitytypeCd;
    }

    public void setActivitytypeCd(String activitytypeCd) {
        this.activitytypeCd = activitytypeCd;
    }

    public String getActivitytypeNm() {
        return activitytypeNm;
    }

    public void setActivitytypeNm(String activitytypeNm) {
        this.activitytypeNm = activitytypeNm;
    }

    public int getManagerEmpno() {
        return managerEmpno;
    }

    public void setManagerEmpno(int managerEmpno) {
        this.managerEmpno = managerEmpno;
    }

    public String getPositionCd() {
        return positionCd;
    }

    public void setPositionCd(String positionCd) {
        this.positionCd = positionCd;
    }

    public String getPositionNm() {
        return positionNm;
    }

    public void setPositionNm(String positionNm) {
        this.positionNm = positionNm;
    }

    public String getPersonnelareaCd() {
        return personnelareaCd;
    }

    public void setPersonnelareaCd(String personnelareaCd) {
        this.personnelareaCd = personnelareaCd;
    }

    public String getPersonnelareaNm() {
        return personnelareaNm;
    }

    public void setPersonnelareaNm(String personnelareaNm) {
        this.personnelareaNm = personnelareaNm;
    }

    public String getZipNo() {
        return zipNo;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    public ArrayList<HashMap<String, Object>> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(ArrayList<HashMap<String, Object>> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public ArrayList<HashMap<String, Object>> getIdlDeptList() {
        return idlDeptList;
    }

    public void setIdlDeptList(ArrayList<HashMap<String, Object>> idlDeptList) {
        this.idlDeptList = idlDeptList;
    }

}
