package document;

import java.util.HashMap;

public interface DocumentBuilder {

	public void setParameter( HashMap<String,String> parameter );
	public void build() throws Exception;
	
}
