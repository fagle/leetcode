package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fagle on 17-3-31.
 * 5. Longest Palindromic Substring
 */
public class Problem005 {
    public class Solution {

        boolean isPalindrome(String s) {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1))
                    return false;
            }
            return true;
        }

        public String longestPalindrome(String s) {
            String maxstr = s.substring(0, 1);
            for (int i=0; i<s.length(); i++) {
               for (int j=i+1; j<s.length(); j++) {
                   if (j - i + 1 <= maxstr.length())
                       continue;
                   String tmp = s.substring(i, j+1);
                   if (isPalindrome(tmp))
                       maxstr = tmp;
               }
            }
            return maxstr;
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
        s = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
        Assert.assertEquals("qgjjgq", solution.longestPalindrome(s));
        s = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        Assert.assertEquals("hpyyph", solution.longestPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.printf("spend time: %dms.\n", end - start);
    }
}
