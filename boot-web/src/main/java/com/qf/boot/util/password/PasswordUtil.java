package com.qf.boot.util.password;

/**
 * creator：杜夫人
 * date: 2020/5/28
 */
public class PasswordUtil {
    private final static String SALT = "suan_ge";// 其实这个盐值是存到user表中的，每个人的颜值是不一样

    public static String encodePassword(String password) {
        String salt = "{{" + SALT + "}}";// 盐值准备好
        MD5Code md5Code = new MD5Code();
        String md5ofStr = md5Code.getMD5ofStr(salt + password);
        for (int i = 0; i < 3; i++) {
            md5ofStr = md5Code.getMD5ofStr(md5ofStr);
        }
        return md5ofStr;
    }
}
