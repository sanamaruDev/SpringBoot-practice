package com.example.demo;

public class UserPass {

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
        this.setName(user_name);
        this.setPass(user_pass);
    }

	public String getName() {
		return user_name;
	}

	public void setName(String user_name) {
		this.user_name = user_name;
	}

	public String getPass() {
		return user_pass;
	}

	public void setPass(String user_pass) {
		this.user_pass = user_pass;
	}

}