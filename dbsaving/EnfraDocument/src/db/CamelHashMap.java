package db;

import java.util.HashMap;

import org.springframework.jdbc.support.JdbcUtils;

public class CamelHashMap extends HashMap {
	
	private static final long serialVersionUID = -2328003118280664889L;

	@SuppressWarnings("unchcked")
	@Override
	public Object put(Object key, Object value) {
		return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key) , value);
	}
	
	
}
