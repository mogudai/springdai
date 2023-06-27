package leetcode.editor.cn;

public class maxProduct {

    public static void main(String[] args) {
        maxProduct maxProduct = new maxProduct();
        String[] arr={"bbdfadbfbe","fddffccebbfae","fddc","deccaacdbdaf","efdfaacd","bbefcdfafdbda","dcbfbbf","afefddcb","dcceccaffcfedecaff","ddaaaecedff","adfecdbcadcaedefcd","cbe","feaaa","abbdccdcfabbecfcaae","fbaacb","febbeceabfdaffbbbdaf","adfcea","ba","fbaaeaadabccadddbedb","adfcbdfbcae","cc","bbfaccd","aedaadcaccecde","acecbdcdfdfbba","ddfcafadcfdabadedadd","ceeedfaccabbdcbaafbcc","ccffefabbcbdc","dfddeecfdcbfbaed","ffedffbbffbecdfc","aaef","ecfacbc","bbab","ecebbadceeafba","ebfaddddeabafeaca","eddbddaffcdee","ddbece","adeebbbacefffaedfdbaf","cdddaddb","ddfdecfa","bedebfebdbbfaaca","feccdcecdedefefefc","cce","fffcccecabccdfaa","faccbcffa","ffebbdabeefbabcb","fbfcbfedbdefcbbce","bfeeeffdeb","bcfdbcaabcdbbda","cbeaefdadcecc","dcebebcadebdefbefccc","afecfefacfdccfeac","badba","cdfcdaa","bfbfbfffbbcdeedfdbfaf","beeebbdefaacecfedbc","ccccfbbcbcdfcf","adfa","acfafefececafbaeacde","fdf","abaadccdffbcddc","edaebacecabdeddcd","bbeafadb","cadcededfaaccffdd","bbaaafebbcedaddf","eefddbfbece","accfcd","afdafdeddeb","efccedf","bdcdedbbeecadfd","bef","ecbdbd","aceeddce","aefccffbbdffbef","ebacafceea","ccffececfdecbffeffcda","edfcdc","ede","dbd","dedddeeacffaeee","dcbfcdcfceabaccefcfe","dfddbccaeadecebecbda","ffaaddfccf","fdedaeac","cafaeeddefbeccfa","adbfeaecccfdfbdfdd","cbeabceaadaecafcdc","dfdfceceecaadffbbccf","ddaf","cefcd","dcebfababdfccadadbae","cbdbdcaddbecdeb","febcec","deffecc","eaaccccadbfeabfafba","dcdffbccfccdfeaadafe","fcbce","cacbffdefcceeebebec","dfceafdb","caaaeabefba","fecbd","afcbcfedfdeebececde","effccabf","bbbcdaaddebc","bffacadaefcaa","edcafcdeccfffaed","bceafcedaacaacb","ccfbb","fcafdbcacbdeeaaabce","dadfbeaefaabaeec","acefafcfd","ade","cdefcbdfdd","eeeabdfdedebfceebdcad","bbedebdbfcceeffdcf","efcaeebbacbaf","daddabfbbdbebfaffb","cacfa","ecabdda","eefecbddacededbafec","aafac","ebaf","fccabecbffecdbbcbaecf","dfdebebeafcceefdfdd","deebacdacbcefde","bbdfafee","dbbccbcfd","febdfddc","fdedddacafcab","bcbaccddebecaeedddd","eebeceeb","bececbfefbfdeffcaca","edfbf","deaaaedbc","cdafedb","edecffcacceafaeec","fabeae","daefafebce","cdbeffcefafcfeccecec","cdfbdccdfcdadbdbeaafa","cdeabdbcffdcbfaebdfdf","aafffbbdeeccceafbffea","fcbbbdadfedddb","babaeae","faef","cadea","bbefbfaabebcbfefbabce","ebca","ddeaecebdfe","bbaaddceaee","edddacfebbfecbdbfccaf","dcf","aeadcfebdbff","cfdeefbfcefefcdbcebe","baf","dfedbedccaf","ffafeedfeababad","daedccd","cdf","cdfcbcabedefefbfae","ddbeadcbcdeedfebbddfe","cbfcedcbfdbbaccbd","cfececfe","cf","bcdcbabbbcbaefbbcbe","efecbfbecbbfcce","eecfaaaafdea","dedbacccbdd","fcbbdadbeaafdaadfcedd","bea","cfbdebdebeaebbba","acbfafcffdabaeffcdb","fdeedceeedac","deeadebeb","aeebfbaaafcfca","eebaadeecfce","caffbfecaeedde","aaffcbecba","edeb","bebcdaecccedddedfeea","befcdabbfdbfcfddea","fbadafadaa","fcdbaffeacdccdfcececf","aeeaccadfab","ecbabddacdbfe","bae","bceffaaddcebffdccda","bdedb","dffabcaebfebeccaaebbb","dd","dbcabbaaceeecd","dbccfebdadfeedabd","fafddaffbaf","ffefabdacafde","eafdfc","baababfd","faacec","abbbfcccadc","bfabfaeaf","eaaffbfce","caedef","edbcaeeffdfaedcbb"};
        int i = maxProduct.maxProduct(arr);
        System.out.println(i);
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            // 第一个字符
            String indexStr = words[i];
            int count = 0;
            for (int j = i + 1; j < words.length; j++) {
                // 下一个字符
                String nextStr = words[j];
                String[] strings = nextStr.split("");
                for (int k = 0; k < strings.length; k++) {
                    // 第一个字符是否包含下一个字符串中的字符
                    if (indexStr.contains(strings[k])) {
                        count++;
                    }
                }
                if (count == 0) {
                    int i1 = nextStr.length() * indexStr.length();
                    max= Math.max(i1,max);
                }
                count =0;
            }
        }
        return max;
    }
}
