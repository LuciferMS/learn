package algorithm;

/**
 * @program: learn
 * @description: 字符串匹配kmp算法
 * @author: Elliot
 * @create: 2019-07-14 21:33
 **/
public class KMP {
    public static int[] getNext(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len == 1) {
            return new int[]{-1};
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < len) {
            if (chars[pos - 1] == chars[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static int kmp(String s, String m) {
        char[] ts = s.toCharArray();
        char[] ms = m.toCharArray();
        int ti = 0;
        int mi = 0;
        int[] next = getNext(m);
        while (ti < ts.length && mi < ms.length) {
            if (ts[ti] == ms[mi]) {
                mi++;
                ti++;
            } else if (next[mi] == -1) {
                ti++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? ti - mi : -1;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        int[] next = getNext(match);
        for (int num : next) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(kmp(str, match));

    }
}
