package com.example.myapplication2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.buttonCalculate.setOnClickListener(this)
        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }

    }


    private fun isValid(): Boolean {
        return binding.editHeight.text.toString() != ""
                && binding.editWeight.text.toString() != ""


    }


    private fun calculate() {


        if (isValid()) {
            val height = binding.editHeight.text.toString().toFloat()
            val weight = binding.editWeight.text.toString().toFloat()

            val imc = weight / (height * height)
            binding.textImc.text = "Imc ${"%.2f".format(imc)}"

        } else {
            Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()





            }
        }
    }


