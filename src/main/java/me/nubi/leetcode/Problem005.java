package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fagle on 17-3-31.
 * 5. Longest Palindromic Substring
 */
public class Problem005 {
    public class Solution {

        public String longestPalindrome(String s) {
            int max=0, i1=0, j1=0;
            for (int k=0; k < s.length(); k++) {
                for (int i=k-1,j=k+1; i>=0 && j<s.length(); i--,j++) {
                     if (s.charAt(i) == s.charAt(j)) {
                         int len = j-i+1;
                         if (len > max) {
                             max = len;
                             i1 = i;
                             j1 = j;
                         }
                     } else {
                         break;
                     }
                }
                for (int i=k,j=k+1; i>=0 && j<s.length(); i--,j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        int len = j-i+1;
                        if (len > max) {
                            max = len;
                            i1 = i;
                            j1 = j;
                        }
                    } else {
                        break;
                    }
                }
            }
            return s.substring(i1, j1 + 1);
        }
    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        String s = "babad";
        Solution solution = new Solution();
        Assert.assertEquals("bab", solution.longestPalindrome(s));
        s = "cbbd";
        Assert.assertEquals("bb", solution.longestPalindrome(s));
        s = "a";
        Assert.assertEquals("a", solution.longestPalindrome(s));
        s = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdm" +
                "gxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljie" +
                "smuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbw" +
                "ridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgc" +
                "magshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscy" +
                "muildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbc" +
                "eqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxu" +
                "vbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyn" +
                "gsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
        Assert.assertEquals("qgjjgq", solution.longestPalindrome(s));
        s = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkur" +
                "xqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqm" +
                "vuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyq" +
                "harjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgooby" +
                "sfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlpl" +
                "nnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimui" +
                "zqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmh" +
                "mmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        Assert.assertEquals("hpyyph", solution.longestPalindrome(s));
        s = "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgie" +
                "dhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpug" +
                "mdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhn" +
                "vnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpf" +
                "iudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomd" +
                "rrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmx" +
                "htbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdl" +
                "eusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcu" +
                "bwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
Thread.currentThread().getContextClassLoader();
        Assert.assertEquals("lbabl", solution.longestPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.printf("spend time: %dms.\n", end - start);
    }
}
