package com.akeno.resepsurabaya

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_resep_layout.*

class ResepDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_resep_layout)

        var intentThatStartedThisActivity = getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partNama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partResep = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var partFoto = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            namaResep2.text = partNama
            resepResep2.text = partResep
            fotoResep2.setImageResource(partFoto)
        }
    }
}