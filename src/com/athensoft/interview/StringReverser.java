package com.athensoft.interview;

/**
 * reversing index
 * @author Athens
 *
 */
public class StringReverser {

	public static void main(String[] args) {

		String srcStr = "athens";
		StringBuffer destStrBuffer = new StringBuffer();
		for(int i=srcStr.length()-1; i>=0; i--) {
			destStrBuffer.append(srcStr.charAt(i));
		}
		System.out.println(destStrBuffer.toString());

	}

}
