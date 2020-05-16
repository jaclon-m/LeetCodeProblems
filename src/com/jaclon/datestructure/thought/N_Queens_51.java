package com.jaclon.datestructure.thought;

import com.jaclon.datestructure.Solution;

import java.util.LinkedList;
import java.util.List;

/**
 * 八皇后问题
 * @author jaclon
 * @date 2020/5/15
 */
public class N_Queens_51 {

    List <List <String>> queens = new LinkedList <>();

    public List <List <String>> solveNQueens(int n) {
        int[] result = new int[n];
        cal8Queens(result,0,n);
        return queens;
    }

    private void cal8Queens(int[] result,int row,int n){
        if(row == n){
            add(result,n);
            return;
        }
        for (int column = 0; column < n; column++) {
            if(isOk(result,row,column,n)){
                result[row] = column;
                cal8Queens(result,row + 1,n);
            }
        }
    }

    private boolean isOk(int[] result,int row, int column, int n) {
        int left = column - 1;
        int right = column +1;
        for (int i = row - 1; i >=0 ; i--) {
            if (result[i] == column) {
                return  false;
            }
            if(left>= 0){
                if(result[i] == left) return false;
            }
            if(right < n){
                if(result[i] == right) return false;
            }
            left--;
            right++;
        }
        return true;

    }
    private void add(int[] result,int n) {
        List<String> list= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if(result[i] == j){
                    stringBuffer.append("Q");
                }else {
                    stringBuffer.append(".");
                }
            }
            list.add(stringBuffer.toString());
        }
        queens.add(list);
    }

    public static void main(String[] args) {
        N_Queens_51 solution = new N_Queens_51();
        solution.solveNQueens(4);
        System.out.println(solution.queens);
    }
}
