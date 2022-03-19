package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 初期表示(検索)画面に遷移する
     * @return 検索画面へのパス
     */
    @RequestMapping("/")
    public String index(Model model){
        // ドロップダウン
        // 時間
    	model.addAttribute("lstHours", this.createDropDownListHours());
        // 分
    	model.addAttribute("lstMinutes", this.createDropDownListMinutes());
    	return "hello";
    }

    private List<String> createDropDownListHours() {
    	List<String> lstHours = new ArrayList<>();
    	for (int i = 1; i <= 9; i++) {
	    	lstHours.add(String.valueOf(i));
		}
        return lstHours;
    }
    
    private List<String> createDropDownListMinutes() {
    	List<String> lstMinutes = new ArrayList<>();
    	lstMinutes.add("00");
    	lstMinutes.add("15");
    	lstMinutes.add("30");
    	lstMinutes.add("45");
        return lstMinutes;
    }

}
