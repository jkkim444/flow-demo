package com.encocns.enfra.core.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.encocns.enfra.db.dao.CFW_M_SVC_DAO;
import com.encocns.enfra.db.dvo.CFW_M_SVC_DVO;
import com.encocns.enfra.exception.EnfraCoreException;
import com.encocns.enfra.transaction.TransactionVO;

public class ServiceBeanManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBeanManager.class);

	private ArrayList<CFW_M_SVC_DVO> svcList;

	private TransactionVO transactionVO;

	@Autowired
	private CFW_M_SVC_DAO daoCFW_M_SVC;

	//default constructor
	public ServiceBeanManager()	{}

	private CFW_M_SVC_DVO getServiceInfo( String serviceId, String methodId ) throws EnfraCoreException
	{
		CFW_M_SVC_DVO svcDvo = null;

		CFW_M_SVC_DVO param = new CFW_M_SVC_DVO();
		param.setSvc_id(serviceId);
		param.setMth_id(methodId);

		svcDvo = daoCFW_M_SVC.selSvc( param );

		if( svcDvo==null )
		{
			throw new EnfraCoreException("CE0007", new String[]{serviceId, methodId});
		}

		return svcDvo;
	}

	public int getSerivceCount()
	{
		return svcList.size();
	}


	public boolean isTransactionService( TransactionVO transactionVO ) throws EnfraCoreException
	{

		CFW_M_SVC_DVO serviceDvo = this.getServiceInfo(transactionVO.getService(), transactionVO.getMethod());

		if(LOGGER.isDebugEnabled()) {
	    	LOGGER.debug("/************* serviceDvo VO Info *****************/");
	    	LOGGER.debug(serviceDvo.getSvc_id());
	    	LOGGER.debug(serviceDvo.getMth_id());
	    	LOGGER.debug(serviceDvo.getIsvo_path_cntn());
	    	LOGGER.debug(serviceDvo.getOsvo_path_cntn());
	    	LOGGER.debug(serviceDvo.getSvc_path_cntn());
	    	LOGGER.debug(transactionVO.getServiceObj().getClass().getName());
		}
		
		// Service Bean Class Check
    	String className = "";
    	if(transactionVO.getServiceObj().getClass().getName().indexOf("$") > 0) {
    		className = transactionVO.getServiceObj().getClass().getName().substring(0, transactionVO.getServiceObj().getClass().getName().indexOf("$"));
    	} else {
    		className = transactionVO.getServiceObj().getClass().getName();
    	}

		if( !serviceDvo.getSvc_path_cntn().equals(className) )
		{
			throw new EnfraCoreException("CE0001", new String[]{serviceDvo.getSvc_path_cntn(),transactionVO.getServiceObj().getClass().getName()});
		}

		int methodFlag = 0;
		//Service Method Check
		for( Method method : transactionVO.getServiceObj().getClass().getDeclaredMethods() )
		{
			if( transactionVO.getMethod().equals(method.getName()) ) methodFlag = 1;
		}

		if( methodFlag==0 )
		{
			throw new EnfraCoreException("CE0003", new String[]{transactionVO.getService(), transactionVO.getMethod()});

		}

		//Service ISVO Class Check
		if( !serviceDvo.getIsvo_path_cntn().equals(transactionVO.getIsvoCls().getName()) )
		{
			throw new EnfraCoreException("CE0002", new String[]{"ISVO",serviceDvo.getIsvo_path_cntn(),transactionVO.getIsvoCls().getName()});
		}

		//Service OSVO Class Check
		if( !serviceDvo.getOsvo_path_cntn().equals(transactionVO.getOsvoCls().getName()) )
		{
			throw new EnfraCoreException("CE0002", new String[]{"OSVO",serviceDvo.getOsvo_path_cntn(),transactionVO.getOsvoCls().getName()});
		}

		return true;
	}

	public TransactionVO getTransactionVO() {
		return transactionVO;
	}

	public void setTransactionVO(TransactionVO transactionVO) {
		this.transactionVO = transactionVO;
	}
 
}
