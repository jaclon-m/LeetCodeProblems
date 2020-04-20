package com.jaclon.datestructure.arrayandlink;

public class ValidPalindromeTest {

    /*public boolean isPalindrome(String s) {
        if("".equals(s.trim())){
            return true;
        }

        char[] array = s.toUpperCase().toCharArray();

        for(int i = 0 , j = array.length - 1 ; i<j; i++ , j-- ){

            while (i<array.length && !isAlphanumeric(array[i])){
                i++;
            }
            while (j>=0 && (!isAlphanumeric(array[j]))){
                j--;
            }
            if(i >= array.length || j < 0){
                return  false;
            }
            if(!(array[i] == array[j])){
                return false;
            }

        }
        return true;
    }*/

    public boolean isPalindrome(String s) {
        if("".equals(s.trim())){
            return true;
        }

        int i = 0, j = s.length() -  1;
        char[] array = s.toUpperCase().toCharArray();

        while (i<j){
            while (i<array.length && !isAlphanumeric(array[i])){
                i++;
            }
            while (j>=0 && (!isAlphanumeric(array[j]))){
                j--;
            }
            if(i >= array.length || j < 0){
                return  true;
            }
            if(!(array[i] == array[j])){
                return false;
            }
            i++;
            j--;
        }
        return  true;
    }

    private boolean isAlphanumeric(char c){
        /*String s = new String(new char[]{c});
        //^[\u4e00-\u9fa5_a-zA-Z0-9]+$
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();*/
        return Character.isLetterOrDigit(c);
    }

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindromeTest().isPalindrome(str));
    }
}
