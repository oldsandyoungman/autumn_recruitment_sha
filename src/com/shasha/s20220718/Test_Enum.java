package com.shasha.s20220718;

/**
 * @author ShaLuwei
 * @create 2022-07-18 13:52
 */
public class Test_Enum {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Season spring = Season.SPRING;

        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }

        Season1 winnter = Season1.valueOf("WINTER");
        System.out.println(winnter);

        System.out.println(Season1.WINTER.toString());

        Season1 s1 = Season1.AUTUMN;

        switch (s1){
            case AUTUMN:
                break;
            case SPRING:
                break;
            case WINTER:
                break;
            case SUMMER:
                break;
        }

        System.out.println(s1.ordinal());



    }

}

class Season{

    private final String name;
    private final String des;

    public static final Season SPRING = new Season("春", "111");
    public static final Season SUMMER = new Season("夏", "222");
    public static final Season AUTUMN = new Season("秋", "333");
    public static final Season WINTER = new Season("冬", "444");

    private Season(String name, String des){
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}

interface Test_sha{
    void show();
}

enum Season1 implements Test_sha {

    SPRING("春", "111"){
        @Override
        public void show() {
            System.out.println("11.....11");
        }
    },
    SUMMER("夏", "222") {
        @Override
        public void show() {
            System.out.println("22.....22");
        }
    },
    AUTUMN("秋", "333") {
        @Override
        public void show() {
            System.out.println("44.....33");
        }
    },
    WINTER("冬", "444") {
        @Override
        public void show() {
            System.out.println("44.....44");
        }
    };

    private final String name;
    private final String des;

    private Season1(String name, String des){
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }


}