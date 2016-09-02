package com.automation.page.locators;

public enum MySuggestionEnum {

	
	STATIONS_TITLE_ID ("com.clearchannel.iheartradio.controller:id/event_text"),
	STATIONS_CLASS ("android.widget.LinearLayout"),
	
	
	
;
	
    private final String value;

    private MySuggestionEnum(String value) {
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
