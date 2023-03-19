package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main.xml 바인딩
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //addFrag fragment 출력
        replaceFragment(AddFrag())

        //bottomNavigationView 터치시 fragment 전환
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.add -> replaceFragment(AddFrag())
                R.id.list -> replaceFragment(ListFrag())

                else -> {

                }

            }

            true
        }

    }

    //fragment 전환을 위한 함수 정의
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

}