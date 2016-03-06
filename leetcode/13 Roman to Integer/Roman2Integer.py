# 13. Roman to Integer
# Difficulty: Easy
# Given a roman numeral, convert it to an integer.

# Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public int romanToInt(String s) {
        // I(1), V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
        Boolean isReverse = true;
        
        if (s.length() == 0) {
            return 0;
        }
        
        if (s.length() == 1) {
            return getChar2Num(s.charAt(0));
        }
        
        // int maxIndex = 0; //
        // int last = getChar2Num(s.charAt(0));
        
        // for (int i = 1; i < s.length(); i++) {
        //     int cur = getChar2Num(s.charAt(i));
        //     if (last > cur) {
        //         maxIndex = i - 1;
        //         break;
        //     } else {
        //         last = cur;
        //         maxIndex = i;
        //     }
        // }
        
        // int value = last;
        // // left decrease
        // for (int j = 0; j < maxIndex; j++) {
        //     value -= getChar2Num(s.charAt(j));
        // }
        
        // // right increase
        // for (int j = maxIndex + 1; j < s.length(); j++) {
        //     value += getChar2Num(s.charAt(j));
        // }
        
        int i = 0;
        int value = 0;
        int last = 0;
        while (true) {
            int cur = getChar2Num(s.charAt(i));
            if (cur > last) {
                value -= last;
            } else if (cur <= last) {
                value += last;
            } 
            
            if (i + 1 >= s.length()) {
                value += cur;
                break;
            } 
            last = cur;
            i++;
        }
        
        
        return value;
    }
    
    // private Map<char, Integer> getChar2Num() {
    //     // I(1), V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
    //     Map<char, Integer> mapC2N  = new HashMap<chart, Integer>();
        
    //     mapC2N.put('I', 1);
    //     mapC2N.put('V', 5);
    //     mapC2N.put('X', 10);
    //     mapC2N.put('L', 50);
    //     mapC2N.put('C', 100);
    //     mapC2N.put('D', 500);
    //     mapC2N.put('M', 1000);
        
    //     return mapC2N;
    // }
    
    private int getChar2Num(char c) {
        // I(1), V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
        int num = 0;
        
        switch(c) {
            case 'I':
                num = 1; 
                break;
            case 'V': 
                num = 5; 
                break;
            case 'X': 
                num = 10; 
                break;
            case 'L': 
                num = 50; 
                break;
            case 'C': 
                num = 100; 
                break;
            case 'D': 
                num = 500;
                break;
            case 'M': 
                num = 1000;
                break;
            default:
                break;
        }
        
        return num;
    }
    
}