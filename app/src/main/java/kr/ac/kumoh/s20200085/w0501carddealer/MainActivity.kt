package kr.ac.kumoh.s20200085.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20200085.w0501carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)    //여기서는 하트3이었음

        binding.btnDeal.setOnClickListener {
            val res =IntArray(5)
            for(i in 0 until res.size){
                res[i] = resources.getIdentifier(
                    getCardName(Random.nextInt(52)),
                    "drawable",
                    packageName
                )
            }

            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        }


        //val res = resources.getIdentifier(
        //    getCardName(29),
        //    "drawable",
        //    packageName
        //)

        //binding.card1.setImageResource(R.drawable.c_10_of_spades)   //스페이드 10으로 바꿈
        //binding.card1.setImageResource(res)

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
            0->"ace"
            in 1..9 -> (c % 13 +1).toString()
            10->"jack"
            11->"queen"
            12->"king"
            else -> "error"
        }
        Log.i("getCardName(): ", number)
        return "c_${number}_of_${shape}"
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




//app:layout_constraintBottom_toBottomOf="parent" 가로나 세로에 하나씩은 붙여줘야함
//layout_ 는 부모와의 관계가 있을 때 붙음
//지금은 seed를 고정해두는게 좋음
//app:layout_constraintLeft_toRightOf="@id/card3"
//        app:layout_constraintRight_toRightOf="parent" 인지 start end인지 확인(시험 문제)