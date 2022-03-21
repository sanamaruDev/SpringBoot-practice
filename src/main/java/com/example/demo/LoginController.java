package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserPassAccountService;

@Controller
public class LoginController {

    /**
     * Spring-Security用のユーザーアカウント情報を
     * 取得・設定するサービスへのアクセス
     */
    @Autowired
    private UserPassAccountService userDetailsService;

    /**
     * パスワードをBCryptで暗号化するクラスへのアクセス
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * ログイン用ユーザーのデータを登録する
     * @return ログイン画面へのパス
     */
    @GetMapping("/login")
    public String login(){
        //ユーザー名「user」、パスワード「pass」をユーザーパスワードデータテーブル(user_pass)
        //へ登録する。その際、パスワードはBCryptで暗号化する
        userDetailsService.registerUser(
                "user", passwordEncoder.encode("pass"));
        //ログイン画面に遷移する
        return "login";
    }

    /*
	 * サインアウト
	 */
	@ResponseBody
	@PostMapping("/SignOut")
	public AttendanceForm SignOut(@RequestBody AttendanceForm attendanceForm) {
		
		return attendanceForm;
	}
}
