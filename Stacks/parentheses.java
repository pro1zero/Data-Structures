package Stacks;

import java.util.*;

public class parentheses {
    public static boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        List<Character> stack = new ArrayList<>();
        String opening = "({[";

        // ()
        for(int i = 0; i < s.length(); i++){
            char currentBracket = s.charAt(i);
            if(opening.contains(currentBracket + "")){
                stack.add(currentBracket);
            }else{
                if(stack.size() == 0) return false;
                else{
                    char temp = stack.get(stack.size() - 1); // (
                    if(temp == map.get(currentBracket)){
                        stack.remove(stack.size() - 1);
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}()(){}{}[]"));
    }
}