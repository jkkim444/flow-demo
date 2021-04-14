package com.encocns.enfra.core.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.encocns.enfra.core.bean.CommonCode;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;

@Component
public class ServiceComponent {

	@Autowired
	FileComponent fileComponent;
	
	@Autowired
	private CommonCode commonCode;

	public SessionVO getSessionVO()
	{
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession hs = request.getSession();
		return (SessionVO)hs.getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);
	}

	public FileComponent getFileComponent() {
		return fileComponent;
	}

	public CommonCode getCommonCode()
	{
		return commonCode;
	}

    public String getClientIpAddr() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String ip = "";
        
        try {
            ip = request.getHeader("X-Forwarded-For");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                
                if("0:0:0:0:0:0:0:1".equals(ip)) {
                    ip = "0.0.0.0";
                }
            }
        } catch (Exception e) {
            ip = "0.0.0.0";
        }
        
        return ip;
    }
}
