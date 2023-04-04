package com.example.softkeyboardpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.softkeyboardpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var inputMethodManager: InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnSoftKeyShow.setOnClickListener(this)
        binding.btnSoftKeyHide.setOnClickListener(this)

        inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSoftKeyShow -> {
                binding.edtData.requestFocus() // 커서활성화
                inputMethodManager.showSoftInput(binding.edtData, InputMethodManager.SHOW_IMPLICIT)
            }
            R.id.btnSoftKeyHide -> {
                inputMethodManager.hideSoftInputFromWindow(
                    currentFocus?.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                ) // currentFocus = 현재커서
                binding.edtData.clearFocus()

            }
        }
    }
}