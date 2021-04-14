package com.encocns.enfra.db.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.enfra.core.component.vo.FileVO;
import com.encocns.enfra.db.config.EnfraSqlMapClient;

@Repository
public class CCO_M_ATCHFILE_DAO {

	@Autowired
	private EnfraSqlMapClient session;

    /**
     * @첨부파일관리 FILE SEQ 조회
     */
    public int selFileSeq( FileVO dvo ){
    	int fileSeq = session.selectOne( "cfw_m_atchfile.selFileSeq", dvo );
    	return fileSeq;
    }

    /**
     * @첨부파일관리 등록
     */
    public int insAtchFile( FileVO dvo ){
    	int cnt = session.insert( "cfw_m_atchfile.insAtchFile", dvo );
    	return cnt;
    }

	/**
	 * @첨부파일관리 삭제
	 */
	public int delAtchFile( FileVO dvo ){
		int cnt = session.delete( "cfw_m_atchfile.delAtchFile", dvo );
		return cnt;
	}

	/**
	 * @첨부파일관리 Comp조회 ( 동부저축은행 화면ID 컬럼 제거)
	 */
//	public ArrayList<FileVO> selAtchFileComp( String scrnId ){
//		ArrayList<FileVO> menuList = (ArrayList)session.selectList( "cfw_m_atchfile.selAtchFileComp", scrnId );
//		return menuList;
//	}

	/**
	 * @첨부파일관리 조회
	 */
	public ArrayList<FileVO> selAtchFileList( FileVO dvo ){
		ArrayList<FileVO> atchFileList = (ArrayList)session.selectList( "cfw_m_atchfile.selAtchFileList", dvo );
		return atchFileList;
	}

    /**
     * @첨부파일관리 파일 조회
     */
    public FileVO selAtchFile( FileVO fileVO ){
        FileVO file = session.selectOne( "cfw_m_atchfile.selAtchFile", fileVO );
        return file;
    }

}