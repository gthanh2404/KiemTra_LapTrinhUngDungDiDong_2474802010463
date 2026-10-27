package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010463

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    // Khai bao cac view (anh xa bang findViewById, KHONG dung ViewBinding)
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1.3. View Mapping bang findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        // 1.4. Xu ly su kien click nut Login
        btnLogin.setOnClickListener {
            validateLogin()
        }
    }

    private fun validateLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        when {
            // Email hoac Password de trong
            email.isEmpty() && password.isEmpty() ->
                showError("Lỗi: Email và Password không được để trống!")
            email.isEmpty() ->
                showError("Lỗi: Email không được để trống!")
            password.isEmpty() ->
                showError("Lỗi: Password không được để trống!")

            // Sai dinh dang email
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                showError("Lỗi: Email không đúng định dạng!")

            // Password < 6 ky tu
            password.length < 6 ->
                showError("Lỗi: Password phải có ít nhất 6 ký tự!")

            // Du lieu hop le
            else -> {
                tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                tvStatus.text = "Validation Successful!"
            }
        }
    }

    private fun showError(message: String) {
        tvStatus.setTextColor(Color.parseColor("#D32F2F"))
        tvStatus.text = message
    }
}
