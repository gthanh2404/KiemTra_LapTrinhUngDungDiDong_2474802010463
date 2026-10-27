package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010463

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    // Khai bao cac view (anh xa bang findViewById, KHONG dung ViewBinding)
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2.2. View Mapping bang findViewById
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        // 3.2. Anh xa ListView bang findViewById
        lvSubjects = findViewById(R.id.lvSubjects)

        // 2.4. Nhan du lieu email tu LoginActivity (Bundle extras)
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvUserEmail.text = "Email: $email"

        // 2.5. Dang xuat: dong man hinh hien tai, quay ve LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // 3.3. Mang du lieu mau (it nhat 5 mon hoc / ky nang)
        val subjects = arrayOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture"
        )

        // 3.4. Gan ArrayAdapter voi layout mau android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // 3.5. Bat su kien click item: hien Toast ten phan tu duoc chon
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Bạn đã chọn: ${subjects[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
