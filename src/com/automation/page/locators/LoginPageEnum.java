package com.automation.page.locators;

public enum LoginPageEnum {
	
	LOGIN_NAME ("LOG IN"),
	EMAIL_ID ("com.clearchannel.iheartradio.controller:id/email"),
	PASSWORD_ID ("com.clearchannel.iheartradio.controller:id/password"),
	SUBMITBUTTON_ID ("com.clearchannel.iheartradio.controller:id/email_login"),
	SKIP_NAME ("Skip"),
	OK_NAME ("OK"),
	

	

	;
	
    private final String value;

    private LoginPageEnum(String value) {
            this.value = value;
    }
    
    public String getValue() {
		return value;
	}
    
    public String toString()
    {
    	return getValue();
    }
	
}
