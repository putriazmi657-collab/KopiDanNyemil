
package lat.pam.kopidannyemil

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    companion object {
        var registeredName = ""
        var selectedProduct = ""
        var selectedPrice = 0
    }

    private var orderingFromHome = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSplash()
    }

    private fun showSplash() {
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            showSignUp()
        }
    }

    private fun showSignUp() {
        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            showRegister()
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            showLogin()
        }
    }

    private fun showRegister() {
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.etFullName)
        val username = findViewById<EditText>(R.id.etRegUsername)
        val password = findViewById<EditText>(R.id.etRegPassword)

        findViewById<Button>(R.id.btnRegisterUser).setOnClickListener {
            val nama = name.text.toString().trim()
            val user = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if (nama.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Semua data harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val prefs = getSharedPreferences("akun_kopi", MODE_PRIVATE)

                prefs.edit()
                    .putString("nama", nama)
                    .putString("username", user)
                    .putString("password", pass)
                    .apply()

                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                showLogin()
            }
        }
    }

    private fun showLogin() {
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLoginUser).setOnClickListener {
            val user = username.text.toString().trim()
            val pass = password.text.toString().trim()

            val prefs = getSharedPreferences("akun_kopi", MODE_PRIVATE)

            val savedUsername = prefs.getString("username", "")
            val savedPassword = prefs.getString("password", "")
            val savedName = prefs.getString("nama", "")

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show()
            } else if (user == savedUsername && pass == savedPassword) {
                registeredName = savedName ?: ""
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                showHome()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showHome() {
        setContentView(R.layout.activity_home)

        findViewById<TextView>(R.id.tvWelcome).text = "Halo, $registeredName!"

        findViewById<Button>(R.id.btnProduct1).setOnClickListener {
            selectProduct("Kopi Susu Gula Aren", 22000)
        }

        findViewById<Button>(R.id.btnProduct2).setOnClickListener {
            selectProduct("Donat Cokelat", 12000)
        }

        findViewById<Button>(R.id.btnProduct3).setOnClickListener {
            selectProduct("Sourdough Loaf", 35000)
        }

        findViewById<Button>(R.id.btnProduct4).setOnClickListener {
            selectProduct("Cappuccino", 25000)
        }

        findViewById<Button>(R.id.btnProduct5).setOnClickListener {
            selectProduct("Matcha Latte", 27000)
        }

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            if (selectedProduct.isEmpty()) {
                Toast.makeText(this, "Pilih produk terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                orderingFromHome = true
                showAddress()
            }
        }

        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            showProfile()
        }
    }

    private fun selectProduct(product: String, price: Int) {
        selectedProduct = product
        selectedPrice = price

        findViewById<TextView>(R.id.tvSelectedProduct).text =
            "Produk dipilih: $product - Rp$price"

        Toast.makeText(this, "$product dipilih", Toast.LENGTH_SHORT).show()
    }

    private fun showProfile() {
        setContentView(R.layout.activity_profile)

        findViewById<TextView>(R.id.tvProfileName).text = registeredName

        findViewById<Button>(R.id.btnBackHome).setOnClickListener {
            showHome()
        }

        findViewById<Button>(R.id.btnProfileAddress).setOnClickListener {
            orderingFromHome = false
            showAddress()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            registeredName = ""
            selectedProduct = ""
            selectedPrice = 0

            Toast.makeText(this, "Berhasil logout", Toast.LENGTH_SHORT).show()
            showSignUp()
        }
    }

    private fun showAddress() {
        setContentView(R.layout.activity_address)

        val recipient = findViewById<EditText>(R.id.etRecipient)
        val phone = findViewById<EditText>(R.id.etPhone)
        val address = findViewById<EditText>(R.id.etFullAddress)

        val prefs = getSharedPreferences("akun_kopi", MODE_PRIVATE)

        recipient.setText(prefs.getString("penerima", registeredName))
        phone.setText(prefs.getString("telepon", ""))
        address.setText(prefs.getString("alamat", ""))

        findViewById<Button>(R.id.btnSaveAddress).setOnClickListener {
            val namaPenerima = recipient.text.toString().trim()
            val nomorTelepon = phone.text.toString().trim()
            val alamatLengkap = address.text.toString().trim()

            if (namaPenerima.isEmpty() || nomorTelepon.isEmpty() || alamatLengkap.isEmpty()) {
                Toast.makeText(this, "Lengkapi semua data alamat", Toast.LENGTH_SHORT).show()
            } else {
                prefs.edit()
                    .putString("penerima", namaPenerima)
                    .putString("telepon", nomorTelepon)
                    .putString("alamat", alamatLengkap)
                    .apply()

                if (orderingFromHome) {
                    showConfirmation()
                } else {
                    Toast.makeText(this, "Alamat berhasil disimpan!", Toast.LENGTH_SHORT).show()
                    showProfile()
                }
            }
        }

        findViewById<Button>(R.id.btnAddressBack).setOnClickListener {
            showProfile()
        }
    }

    private fun showConfirmation() {
        setContentView(R.layout.activity_confirmation)

        val prefs = getSharedPreferences("akun_kopi", MODE_PRIVATE)

        val recipient = prefs.getString("penerima", "")
        val phone = prefs.getString("telepon", "")
        val address = prefs.getString("alamat", "")

        findViewById<TextView>(R.id.tvConfirmProduct).text =
            "Produk: $selectedProduct"

        findViewById<TextView>(R.id.tvConfirmPrice).text =
            "Harga: Rp${selectedPrice}"

        findViewById<TextView>(R.id.tvConfirmRecipient).text =
            "Nama Penerima: $recipient"

        findViewById<TextView>(R.id.tvConfirmPhone).text =
            "Nomor Telepon: $phone"

        findViewById<TextView>(R.id.tvConfirmAddress).text =
            "Alamat: $address"

        findViewById<TextView>(R.id.tvConfirmTotal).text =
            "Total Pembayaran: Rp${selectedPrice}"

        findViewById<Button>(R.id.btnFinishOrder).setOnClickListener {
            Toast.makeText(this, "Pesanan berhasil dikonfirmasi!", Toast.LENGTH_LONG).show()

            selectedProduct = ""
            selectedPrice = 0
            orderingFromHome = false

            showHome()
        }

        findViewById<Button>(R.id.btnConfirmationBack).setOnClickListener {
            showHome()
        }
    }
}
