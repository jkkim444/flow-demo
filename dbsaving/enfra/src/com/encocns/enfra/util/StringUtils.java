package com.encocns.enfra.util;

public class StringUtils {

   /**
     * lpad 함수
     *  @param str   대상문자열, len 길이, addStr 대체문자
     *  @return      문자열
     **/
    public static String lpad(String str, int len, String addStr) {
        String result = str;
        int templen   = len - result.length();

       for (int i = 0; i < templen; i++){
              result = addStr + result;
        }
        
        return result;
    }

    /**
      *  isEmpty input 값이 null인지 검사
      *  @param   String input
      *  @return   true / false ;
      **/
    public static boolean isEmpty(String input)
    {
      if (input == null) {
        return true;
      }
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) > ' ') {
          return false;
        }
      }
      return true;
    }
	
}
