package me.nubi.leetcode;

public class KMP {
    private String pat;
    private int dfa [][] ;
    private int M;
    public KMP(String pattern) {
        this.pat = pattern;
        M = pat.length();
        int R = 256;
        dfa = new int[R][M];

        dfa[pat.charAt(0)][0] = 1;
        int X=0, j=0;
        System.out.println("j: "+j+ "\tpat.charAt(j): "+ pat.charAt(j) +
                "\tdfa['A'][j]: "+ dfa['A'][j] + "\tdfa['B'][j]: " + dfa['B'][j] + "\tX[j]: " + X +"");
        for (X=0, j=1; j<M; j++) {
            for (int c=0; c< R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            System.out.println("j: "+j+ "\tpat.charAt(j): "+ pat.charAt(j) +
                    "\tdfa['A'][j]: "+ dfa['A'][j] + "\tdfa['B'][j]: " + dfa['B'][j] + "\tX[j]: " + X +"");
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j;
        for (i=0, j=0; i<txt.length() && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M;
        return i;
    }

    public static void main(String args[]) {
        String pat = "ABAABAAABAAAB";
        KMP kmp = new KMP(pat);
        String txt = "AAABBBABAABABAABAAABAAABBBBAAABABAB";
        int pos = kmp.search(txt);
        System.out.println( "pos: " + pos);
        System.out.println("text:    " + txt);
        System.out.print("pattern: ");
        for (int i=0; i<pos; i++)
            System.out.print(' ');
        System.out.println(pat);
    }
}
