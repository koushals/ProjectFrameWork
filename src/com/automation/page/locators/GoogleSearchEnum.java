package com.automation.page.locators;

public enum GoogleSearchEnum {

	
	SEARCH_BAR_XPATH ("//*[@id='lst-ib']"),
	SEARCH_ICON_XPATH ("//*[@id='tsbb']"),
	ALLOW_ID ("com.android.chrome:id/button_primary"),
	LINK_XPATH ("//cite[@class='_Rm']"),
		
	;
	
    private final String value;

    private GoogleSearchEnum(String value) {
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
