package com.fsantosbr.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// This class will help us to decode the parameter String used in the URL for a search
// Why is the String coded?? Because of the blanket spaces. We can't use this: 'bom dia' in the URL, but we do can this one: 'bom%20dia'.
// And our class must be able to undone things (Done/encoded by javaScript)

public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
