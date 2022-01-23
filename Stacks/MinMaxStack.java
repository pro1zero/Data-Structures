package Stacks;

import java.util.*;
public class MinMaxStack{
        static List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
        static List<Integer> stack = new ArrayList<>();
    
        public static int peek() {
            return stack.get(stack.size() - 1);
        }
    
        public static int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }
    
        public static void push(int number) {
            Map<String, Integer> currentMinMax = new HashMap<String, Integer>();
            currentMinMax.put("min", number);
            currentMinMax.put("max", number);
    
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = new HashMap<String, Integer>(minMaxStack.get(minMaxStack.size() - 1));
                currentMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                currentMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(currentMinMax);
            stack.add(number);
        }
    
        public static int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }
    
        public static int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }

        public static void main(String[] args) {
            MinMaxStack.push(4);
            System.out.println(MinMaxStack.getMax());
            System.out.println(MinMaxStack.getMin());
            MinMaxStack.push(1);
            System.out.println(MinMaxStack.getMax());
            System.out.println(MinMaxStack.getMin());
        }
}
