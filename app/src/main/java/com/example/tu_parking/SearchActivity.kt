package com.example.tu_parking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tu_parking.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private val TAG = "SearchActivity"
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 객체 생성
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DatabaseHelper(this)

        // 데이터베이스 초기화
        dbHelper.resetDatabase()

        // 차량 번호가 맞을 경우 MyCarActivity로 이동
        binding.btn.setOnClickListener {
            val editText = binding.number.editableText.toString()

            // 임시로 값 넣고 자리를 채운다
            dbHelper.insertLog("1234", 1, "2025-01-08 10:30:00")
            dbHelper.insertLog("1111", 2, "2025-01-08 10:30:00")
            //두개는 안되냐
            // 남은 자리를 갱신

            if (dbHelper.isCarParked(editText)) {
                // 차량이 주차 중인 경우
                Toast.makeText(this, "차량이 주차되어 있습니다!", Toast.LENGTH_SHORT).show()

                // MyCarActivity로 이동
                val intent = Intent(this, MycarActivity::class.java)
                intent.putExtra("car_num", editText)  // 번호판 정보 넘기기
                startActivity(intent)
            } else {
                // 차량이 주차되지 않은 경우
                Toast.makeText(this, "차량이 주차되어 있지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // SeatActivity로 이동
        binding.seatschk.setOnClickListener {
            val intent = Intent(this, SeatActivity::class.java)  // SeatActivity로 이동
            startActivity(intent)
        }
    }
}
