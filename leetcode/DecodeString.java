/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
import java.util.*;

public class DecodeString {
    
    public String decodeString(String s) {
        StringBuilder b = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) stack.push(i);
            else if(c == ']') {
                int start = stack.pop(), k = Character.getNumericValue(s.charAt(start));
                while(k-- > 0) b.append(s.substring(start+2, i));
            }
            else if(stack.empty()) b.append(c);
        }
        
        return b.toString();
    }
}
/*
recursive ?
divide string into 
	normal + encoded + ...


*/
/*
parsing
loop 
    if '[' insert index into stack
    if ']' pop start from stack repeat k times of substring
    if stack is empty add cur char
*/