package com.automation.page.locators;

public enum HomePageEnum {
	
	SUGGESTION_ID ("com.clearchannel.iheartradio.controller:id/in_app_message_image"),
	DISMISS_ID ("com.clearchannel.iheartradio.controller:id/close_button"),
	MY_STATIONS_NAME ("MY STATIONS"),
	
		
	;
	
    private final String value;

    private HomePageEnum(String value) {
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
