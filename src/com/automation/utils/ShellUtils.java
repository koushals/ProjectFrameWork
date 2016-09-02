package com.automation.utils;

import java.io.IOException;

public class ShellUtils {

	Process p;
	
	public static String uninstallApp(String appPa) throws IOException {
		String a = "adb shell am start -a android.intent.action.DELETE -d package:"+appPa;
		Runtime.getRuntime().exec(a);
		return a;
		
	}

}
