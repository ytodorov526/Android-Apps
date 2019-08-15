package com.zoo20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_animal_info.tvDes
import kotlinx.android.synthetic.main.activity_animal_info.tvName
import kotlinx.android.synthetic.main.activity_animal_info.ivAnimalImage

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle: Bundle= intent.extras!!
        ivAnimalImage.setImageResource(bundle.getInt("image"))
        tvName.text=bundle.getString("name")
        tvDes.text= bundle.getString("des")
    }
}
