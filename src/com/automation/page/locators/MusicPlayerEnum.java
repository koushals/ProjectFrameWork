package com.automation.page.locators;

public enum MusicPlayerEnum {
	
	TIMEPLAYED_ID ("com.clearchannel.iheartradio.controller:id/timeElapsed"),
	DISLIKE_ID ("com.clearchannel.iheartradio.controller:id/button_player_thumbdown"),
	LIKE_ID ("com.clearchannel.iheartradio.controller:id/button_player_thumbup"),
	NEXT_ID ("com.clearchannel.iheartradio.controller:id/button_player_next"),
	LOVE_ID ("com.clearchannel.iheartradio.controller:id/button_player_favorite")
	;
	
    private final String value;

    private MusicPlayerEnum(String value) {
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
