/**
 * Created by: dagrawal on Dec 31, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.util;

/**
 * @author dagrawal
 *
 */
public class StringUtil {
	public static boolean isNullOrEmpty(String string){
		boolean ret = false;
		if(string != null){
			if(string.length()<1){
				ret = true;
			}
		}else{
			ret = true;
		}
		return ret;
	}
}
