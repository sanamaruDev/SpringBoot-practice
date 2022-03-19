package com.example.demo.domain;

import lombok.Data;

@Data
public class UserPass {

    /** ユーザーID */
    private String user_id;

    /** ユーザー名 */
    private String user_name;

    /** パスワード */
    private String user_pass;

    /**
     * 指定したユーザー名・パスワードをもつUserPassオブジェクトを作成する
     * @param user_name ユーザー名
     * @param user_pass パスワード
     */
    public UserPass(String user_name, String user_pass){
        this.setUser_name(user_name);
        this.setUser_pass(user_pass);
    }
}