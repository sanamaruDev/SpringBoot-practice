package com.example.demo;

public class UserPass {

    /** ユーザー名 */
    private String name;

    /** パスワード */
    private String pass;

    /**
     * 指定したユーザー名・パスワードをもつUserPassオブジェクトを作成する
     * @param name ユーザー名
     * @param pass パスワード
     */
    public UserPass(String name, String pass){
        this.setName(name);
        this.setPass(pass);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}