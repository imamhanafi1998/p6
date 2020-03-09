package com.akeno.resepsurabaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createResepData()
        resepParts.layoutManager = LinearLayoutManager(this)
        resepParts.setHasFixedSize(true)
        resepParts.adapter = ResepAdapter(testData, { resepItem: ResepData -> resepItemClicked(resepItem)})
    }

    private fun resepItemClicked(resepItem: ResepData) {
        val showDetailActivityIntent = Intent(this, ResepDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, resepItem.namaResep.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, resepItem.resepResep.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, resepItem.fotoResep.toString())
        startActivity(showDetailActivityIntent)
    }

    private fun createResepData() : List<ResepData> {
        val partList = ArrayList<ResepData>()
        partList.add(ResepData("Rawon", "Rawon adalah masakan Indonesia berupa sup daging berkuah hitam sebagai campuran bumbu khas yang menggunakan kluwek. Rawon, meskipun dikenal sebagai masakan khas Jawa Timur, dikenal pula oleh masyarakat Jawa Tengah sebelah timur (daerah Surakarta).", R.drawable.rawon))
        partList.add(ResepData("Pecel", "pecel adalah makanan sing terdiri dari berbagai macam sayur. Pecel di daerah kebuman tidak jauh berbeda dengan di daerah lain di jawa. Pecel terdiri dari sayuran seperti sayur bayam, kacang panjang,kol atau kubis, kecambah atau taoge, dan timun sing di beri sambal pecel atau bumbu kacang.Tapi di wilayah kebumen, pecel sering pula dibubuhi dengan bahan-bahan (sayuran) sing berbau merangsang. ", R.drawable.pecel))
        partList.add(ResepData("Gado-Gado", "Gado-gado adalah salah satu makanan yang berasal dari Indonesia yang berupa sayur-sayuran yang direbus dan dicampur jadi satu, dengan bumbu kacang atau saus dari kacang tanah dan yang dihaluskan disertai irisan telur dan pada umumnya banyak yang menambahkan kentang rebus yang sudah dihaluskan untuk saus gado gado kentang rebus dimasak bersamaan dengan bumbu kacang kemudian di atasnya ditaburi bawang goreng.", R.drawable.gado))
        partList.add(ResepData("Lodeh", "Lodeh adalah masakan sayur yang berkuah santan khas Indonesia, terutama di daerah Jawa Tengah. Sayur lodeh mempunyai berbagai macam variasi terutama pada bumbunya, ada yang santannya berwarna putih dan ada juga yang santannya berwarna kuning kemerahan.", R.drawable.lodeh))
        partList.add(ResepData("Bakso", "Bakso atau baso adalah jenis bola daging yang lazim ditemukan pada masakan Indonesia.[2] Bakso umumnya dibuat dari campuran daging sapi giling dan tepung tapioka, akan tetapi ada juga bakso yang terbuat dari daging ayam, ikan, atau udang bahkan daging kerbau. Dalam penyajiannya, bakso umumnya disajikan panas-panas dengan kuah kaldu sapi bening, dicampur mi, bihun, taoge, tahu, terkadang telur dan ditaburi bawang goreng dan seledri.", R.drawable.bakso))
        partList.add(ResepData("Rujak", "Rujak adalah makanan tradisional yang biasanya terbuat dari campuran berbagai macam sayuran atau buah dan dibubuhi bumbu atau kuah yang dicampuri cabe. Rujak mudah ditemukan di Indonesia, Malaysia, dan Singapura dan di sana disebut rojak.", R.drawable.rujak))
        return partList
    }
}
