package com.encocns.enfra.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.db.config.EnfraSqlMapClient;
import com.encocns.enfra.db.dvo.CFW_LOG_DVO;
import com.encocns.enfra.db.dvo.CFW_M_SVC_DVO;

@Repository
public class CFW_M_SVC_DAO {

	@Autowired
	private EnfraSqlMapClient session;

    /**
     * @서비스관리 세션조회
     */
    public SessionVO selSessionInfo( String empNo ){
    	SessionVO dvo = session.selectOne( "cfw_m_svc.selSessionInfo", empNo );
    	return dvo;
    }

	/**
	 * @서비스관리 서비스전체
	 */
	public List<CFW_M_SVC_DVO> selSvcList( String lct_biz_cd ){
		List<CFW_M_SVC_DVO> svcList = session.selectList( "cfw_m_svc.selSvcList", lct_biz_cd );
		return svcList;
	}

	/**
	 * @서비스관리 서비스조회
	 */
	public CFW_M_SVC_DVO selSvc( CFW_M_SVC_DVO param ){
		CFW_M_SVC_DVO dvo = session.selectOne( "cfw_m_svc.selSvc", param );
		return dvo;
	}

	/**
	 * @서비스거래이력 서비스거래내역 일련번호 조회
	 */
	public int selLogSeq(){
		//CFW_LOG_DVO dvo = session.selectOne( "cfw_m_svc.selLogSeq" );
		int seq = session.selectOne( "cfw_m_svc.selLogSeq" );

		/*
		if(dvo != null) {
			return dvo.getLog_seqno();
		} else {
			return 0;
		}
		*/
		
		return seq;
	}

	/**
	 * @서비스거래이력 서비스거래이력등록
	 */
	public int insLog(CFW_LOG_DVO param) {
		int cnt = session.insert("cfw_m_svc.insLog", param);
		return cnt;
	}

}