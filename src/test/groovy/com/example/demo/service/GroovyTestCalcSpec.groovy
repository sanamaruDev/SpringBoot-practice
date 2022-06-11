/*
spock導入用テストソース
導入完了後削除予定
*/

package com.example.demo.service

import spock.lang.Specification

class GroovyTestCalcSpec extends Specification {

  private GroovyTestCalc instance;

  def setup() {
      instance = new GroovyTestCalc()
  }

  def "adding two numbers"() {
      expect:
      instance.add(a, b) == c

      where:
      a | b | c
      1 | 3 | 4
      7 | 4 | 11
      0 | 0 | 0
  }
}  