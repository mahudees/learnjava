
package org.test;

import static java.lang.String.format;

import java.util.Arrays;

/***
 * This class will print all nested members of a given type
 *
 */
public class MemberDetailsPrinter {

	public static void of(Class<?> clz) {
		getClasses(clz, 0);
	}

	private static void getClasses(Class<?> clz, int depth) {
		Class<?>[] payload=clz.getDeclaredClasses();
		System.out.println(format("%s%s", padder(depth, type(clz)), clz.getSimpleName()));
		
		if (payload.length > 0) {
			int _depth=depth+1;
			Arrays.asList(clz.getDeclaredClasses())
			      .forEach(item-> getClasses(item,_depth));
		} 
	}

	private static String type(Class<?> clz) {		
		if(clz.isAnnotation())     return "A";
		else if(clz.isInterface()) return "I";
		else if(clz.isEnum())      return "E";
		else                       return "C";
	}
	
	private static String padder(int depth,String type) {
		String padString="";
		if(depth==0)      { padString=""; }
		else if(depth==1) { padString=repeat("\t",depth).concat("|---"); }
		else              { padString=repeat("\t|",depth).concat("---"); }
		
		return padString + "[" + type + "]-"; 
	}

	private static String repeat(String str, int count){
		String result="";
		for (int i=0; i<count;i++) { result+=str;}
		return result;
	}
}