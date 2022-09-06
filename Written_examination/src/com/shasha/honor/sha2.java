package com.shasha.honor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ShaLuwei
 * @create 2022-08-20 19:41
 */
public class sha2 {

    /*
5
my/2019-01-01T09:00:01
my/2019-01-01T09:00:01
abc/2018-12-24T08:00:00/test/you
1/2018-12-24T08:00:00/test/Test1
123/2018-12-24T08:00:09/test/me

     */

    public static void main(String[] args) throws ParseException {

        String regex = "[0-9]{4}[-][0-9]{2}[-][0-9]{2}[T][0-9]{2}[:][0-9]{2}[:][0-9]{2}";
        Pattern p = Pattern.compile(regex);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        ArrayList<State> l = new ArrayList<>();
        HashMap<String, Long> memo = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        for(int i=0; i<n; i++){
            String cur = sc.nextLine();

            Matcher m = p.matcher(cur);
            if(m.find()){
                int index = m.start();
                String old_time = cur.substring(index, index+19);
                String time = old_time.replace('T', ' ');
                Date d = sdf.parse(time);
                long tmp = d.getTime();

                if(!memo.containsKey(cur)){
                    memo.put(cur, tmp);
                    l.add(new State(tmp, cur));
                }
            }
        }


        Collections.sort(l, (o1, o2) -> {

            if(o1.time==o2.time){
                if(o1.s.length()==o2.s.length()){
                    return o1.s.compareTo(o2.s);
                }
                return Integer.compare(o1.s.length(),o2.s.length());
            }
            return Long.compare(o1.time, o2.time);

        });

        for(int i=0; i<l.size(); i++){
            System.out.println(l.get(i).s);
        }

    }

}


class State{

    long time;
    String s;

    public State(long time, String s){
        this.time = time;
        this.s = s;
    }

}