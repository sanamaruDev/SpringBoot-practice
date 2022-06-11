/*
spock導入用テストソース
導入完了後削除予定
*/

package com.example.demo.service

import spock.lang.Specification

class CalcSpec extends Specification {

    def "assert 1"() {
        when:
        def answer = 1+1
        then:
        answer == 2
    }

    def "assert 2"() {
        when:
        def answer = 1+2
        then:
        answer == 3
    }
}
