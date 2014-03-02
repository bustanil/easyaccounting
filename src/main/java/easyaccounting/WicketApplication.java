package easyaccounting;

import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication()
	{
	}
	
	public Class getHomePage()
	{
		return HomePage.class;
	}

}
