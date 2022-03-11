package com.example.demo;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserForm implements Serializable{

    /** ID */
    private String id;

    /** 名前 */
    private String name;

    /** 生年月日_年 */
    private String birthYear;

    /** 生年月日_月 */
    private String birthMonth;

    /** 生年月日_日 */
    private String birthDay;

    /** 性別 */
    private String sex;

}
