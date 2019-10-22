package cn.kgc.util;

/**
 * @author mr
 * @Date 2019/10/17 18:08
 */
public class TranslationUtil {
    public static String sexTranslation(String sex) {
        if (sex.equals ("man")) {
            return "男";
        } else {
            return "女";
        }
    }

    public static String hobbyTranslation(String hobby) {
        if (hobby.equals ("sport")) {
            return "运动";
        }
        if (hobby.equals ("game")) {
            return "游戏";
        } else {
            return "睡觉";
        }
    }
}
