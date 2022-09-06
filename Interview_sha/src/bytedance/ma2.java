package bytedance;

/**
 * @author ShaLuwei
 * @create 2022-09-02 16:09
 */


/*

"dog cat" --> 0
"dog DOG cat" --> 1
"apple dog cat" --> 0
"pineapple apple dog cat" --> 0
"apple apple dog cat" --> 1
"apple dog apple dog cat" --> 0
"dog dog DOG dog dog dog" --> 1
"dog dog dog dog cat cat" --> 2
"cat cat dog dog cat cat" --> 3
 */

public class ma2 {

    public static void main(String[] args) {
        String s1 = "dog cat";
        String s2 = "dog DOG cat";
        String s3 = "apple dog cat";
        String s4 = "pineapple apple dog cat";
        String s5 = "apple apple dog cat";
        String s6 = "apple dog apple dog cat";
        String s7 = "dog dog DOG dog dog dog";
        String s8 = "dog dog dog dog cat cat";
        String s9 = "cat cat dog dog cat cat";

        System.out.println(getNum(s1));
        System.out.println(getNum(s2));
        System.out.println(getNum(s3));
        System.out.println(getNum(s4));
        System.out.println(getNum(s5));
        System.out.println(getNum(s6));
        System.out.println(getNum(s7));
        System.out.println(getNum(s8));
        System.out.println(getNum(s9));
    }

    public static int getNum(String s){

        String[] ss = s.split("\\s+");
        int n = ss.length;
        String pre = ss[0];
        int res = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {

            if(pre.equalsIgnoreCase(ss[i])){
                count++;
            }else{

                if(count>1){
                    res++;
                }
                pre = ss[i];
                count = 1;
            }

        }

        if(count>1){
            res++;
        }

        return res;


    }

}
