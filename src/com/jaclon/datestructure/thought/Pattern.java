package com.jaclon.datestructure.thought;

/**
 * 回溯算法-正则表达式
 * “*”匹配任意多个（大于等于 0 个）任意字符，?”匹配零个或者一个任意字符
 * 如何用回溯算法，判断一个给定的文本，能否跟给定的正则表达式匹配
 * leetCode 10题
 * @author jaclon
 * @date 2020/5/15
 */
public class Pattern {

    private boolean matched = false;
    private char[] pattern;
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text,int tlen){
        matched = false;
        rmatch(0,0,text,tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        //终止条件
        if(pj == plen){
            if(ti == tlen) matched = true;
            return;
        }
        if(ti == tlen){
            return;
        }
        //递推公式
        if(pattern[pj] == '*'){
            for (int k = ti; k < tlen; k++) {
                rmatch(k,pj+1,text,tlen);
            }
        }else if(pattern[pj] == '?'){
            rmatch(ti,pj+1,text,tlen);
            rmatch(ti+1,pj+1,text,tlen);
        }else if(ti <tlen && pattern[pj] == text[ti]){
            rmatch(ti+1,pj+1,text,tlen);
        }

    }

    /**
     * 老师的写法
     * @param ti
     * @param pj
     * @param text
     * @param tlen
     */
    private void rmatch2(int ti, int pj, char[] text, int tlen) {
        // 如果已经匹配了，就不要继续递归了
        //感觉可以不用这个判断
        if (matched) return;
        if (pj == plen) { // 正则表达式到结尾了
            if (ti == tlen) matched = true; // 文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // *匹配任意个字符
            for (int k = 0; k <= tlen-ti; ++k) {
                rmatch(ti+k, pj+1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
            rmatch(ti, pj+1, text, tlen);
            rmatch(ti+1, pj+1, text, tlen);
        // 纯字符匹配才行 - ti<tlen 和我自己在递归终止判断应该起一样的作用
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti+1, pj+1, text, tlen);
        }
    }
}
