package com.jaclon.datestructure.queueandstack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author jaclon
 * @date 2020/8/2
 */
public class EvalPRN_150 {

    public int evalRPN(String[] tokens) {
        Stack <Integer> operand = new Stack <>();
        Integer op1;
        Integer op2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "*":
                    op1 = operand.pop();
                    op2 = operand.pop();
                    operand.push(op1*op2);
                    break;
                case "/":
                    op1 = operand.pop();
                    op2 = operand.pop();
                    operand.push(op2/op1);
                    break;
                case "+":
                    op1 = operand.pop();
                    op2 = operand.pop();
                    operand.push(op1+op2);
                    break;
                case "-":
                    op1 = operand.pop();
                    op2 = operand.pop();
                    operand.push(op2-op1);
                    break;
                default:
                    operand.push(Integer.valueOf(tokens[i]));
            }
        }
        return operand.pop();
    }
}
