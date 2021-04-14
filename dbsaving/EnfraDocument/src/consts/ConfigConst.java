package consts;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public interface ConfigConst {

	public static final String ENCODING="UTF-8";
	
	public static String getConfigPath() {
		String localDir = System.getProperty("user.dir");
		String configPath = localDir+"\\properties";
		return configPath;
		
	}
	
	public static String getDocConfigPath() {
		String configPath = getConfigPath()+"\\doc\\"; 
		return configPath;
	}
	
	public static Properties dbProp() {
		
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(getConfigPath()+"\\dbconnect.properties");
			properties.load( new InputStreamReader(fis, Charset.forName(ConfigConst.ENCODING)) );	
		}
		catch(Exception e) {}
		
		return properties;
	}
	
	public static Properties commonProp() {
		
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(getConfigPath()+"\\common.properties");
			properties.load( new InputStreamReader(fis, Charset.forName(ConfigConst.ENCODING)) );	
		}
		catch(Exception e) {}
		
		
		return properties;
		
	}
	
}
