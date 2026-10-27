package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010463

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    // Khai bao cac view (anh xa bang findViewById, KHONG dung ViewBinding)
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

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

        // 2.4. Nhan du lieu email tu LoginActivity (Bundle extras)
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvUserEmail.text = "Email: $email"

        // 2.5. Dang xuat: dong man hinh hien tai, quay ve LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
