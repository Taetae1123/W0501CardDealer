package kr.ac.kumoh.s20200085.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20200085.w0501carddealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)    //여기서는 하트3이었음

        getCardName(29)

        binding.card1.setImageResource(R.drawable.c_10_of_spades)   //스페이드 10으로 바꿈
    }

    private fun getCardName(c: Int): String{
        Log.i("getCardName(): ", c.toString())
        val shape = when (c / 13){
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        Log.i("getCardName(): ", shape)

        val number = when (c % 13) {
            in 1..9 -> (c % 13 +1).toString()
            else -> "error"
        }
        Log.i("getCardName(): ", number)
        return "c_ace_of_spades"
    }
}

//activity_main.xml에
// 0dp하면 너가 알아서 크기 맞춰라는 뜻.
//android:src="@drawable/c_3_of_hearts" 하면 처음 이미지를 이걸로 띄워라라는 뜻
//이미지가 소스로 들어갈때 이름이 영문자,소문자로 들어가야 함(숫자는 안됨)
// 폰트 크기는 sp로 함.
//layout-land라는 폴더를 추가해주면 가로로 둔 화면(리소스 분리)
//Internationalization(I18N),local언어같은거 지정


//native앱을 일단 만들고 flutter를 하던가 하기!!
