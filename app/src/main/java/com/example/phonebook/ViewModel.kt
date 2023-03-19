package com.example.phonebook

import androidx.lifecycle.ViewModel

//ViewModel 클래스 정의
class ViewModel : ViewModel() {
    //번호 목록 표시를 지속적인 추가와 출력을 위한 mutableList 선언
    private var name = mutableListOf<String>()
    private var phone = mutableListOf<String>()
    //인덱스 확인 위한 size 선언
    private var size : Int  = -1

    fun getName(index : Int): String{
        return name[index]
    }

    fun getPhone(index: Int): String{
        return phone[index]
    }
    fun getSize(): Int{
        return size
    }


    fun addUser(inputName : String, inputPhone : String){
        name.add(inputName)
        phone.add(inputPhone)
        size++
    }
}