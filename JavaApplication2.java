/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    static int Prec(char x)  
        {  
        if (x == '+' || x == '-')  
        return 1;  
        if (x == '*' || x == '/' || x == '%')  
        return 2;  
        return 0;  
        }  
     public String convertExpression(String inputExpression, String direction) {
        // Your conversion logic
         if ("Infix to Postfix".equals(direction)) {
            // Implement infix to postfix conversion logic
            return convertToPostfix(inputExpression);
        } 
            // Implement postfix to infix conversion logic
            return convertToInfix(inputExpression);
        
    }
    private static String convertToPostfix(String inputExpression)
    {
        // TODO code application logic here
        //String[] input = inputExpression.split(" ");
        String output = "";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<inputExpression.length();i++){
            char c=inputExpression.charAt(i);
            if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    output+=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
                output+=c;
            }
            else{
                while(!st.isEmpty() && Prec(c)<=Prec(st.peek())){
                    output+=st.peek();st.pop();
                }
                st.push(c);
            }
        }
        return output;
    }
    public static String convertToInfix(String inputExpression){
        Stack<String> s=new Stack<>();
        for(int i=0;i<inputExpression.length();i++){
            char c=inputExpression.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
                s.push(c+"");
            }
            else{
                String op1=s.peek();s.pop();
                s.push("("+s.peek()+c+op1+")");
                s.pop();
            }
        }
       return s.peek();
    }
}
