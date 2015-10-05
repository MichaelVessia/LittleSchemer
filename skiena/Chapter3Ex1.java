public class Chapter3Ex1 {
    
    public static void main(String[] args){

        String test1 = "((())())()";
        String test2 = ")()(";
        String test3 = "())";
        String test4 = "(((";

        System.out.println(properlyNested(test1));
        System.out.println(properlyNested(test2));
        System.out.println(properlyNested(test3));
        System.out.println(properlyNested(test4));

    }

    /* Determine whether parenthesis in a string are properly balanced and nested.
     * Return true if so, and false otherwise.
     * Example: ((())())() is properly nested, but )()( and ()) are not.
     * Extra: Identify the position of the first offending parenthesis.
     */

    public static boolean properlyNested(String s){

        int open = 0;
        int closed = 0;
        if(s.length() <= 1){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                open++;
            }
            else if(c == ')'){
                closed++;
            }

            if(closed > open){
                return false;
            }
        }

        return closed == open;
    }
}
