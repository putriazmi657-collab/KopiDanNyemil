# ☕ Kopi dan Nyemil

**Aplikasi Pemesanan Kopi dan Camilan Berbasis Android**

## 1. Deskripsi Aplikasi

Kopi dan Nyemil merupakan aplikasi berbasis Android yang dibuat untuk memudahkan pengguna dalam melihat pilihan menu kopi dan camilan serta melakukan pemesanan secara sederhana.

Aplikasi ini memiliki tampilan yang didominasi warna cream dan cokelat dengan desain yang sederhana, menarik, dan mudah digunakan. Pengguna dapat membuat akun, login, memilih menu, mengisi alamat pengiriman, melihat detail pesanan, hingga melakukan konfirmasi pesanan.

Aplikasi ini dikembangkan sebagai pemenuhan tugas Ujian Tengah Semester (UTS) mata kuliah Pengembangan Aplikasi Mobile.

## 2. Fitur Aplikasi

Berikut fitur-fitur yang tersedia pada aplikasi Kopi dan Nyemil:

1. **Splash Screen**  
   Menampilkan halaman pembuka aplikasi dengan nama dan identitas Kopi dan Nyemil.

2. **Sign Up**  
   Menyediakan pilihan bagi pengguna untuk membuat akun baru atau masuk menggunakan akun yang sudah tersedia.

3. **Register**  
   Memungkinkan pengguna membuat akun dengan mengisi nama lengkap, username, dan password.

4. **Login**  
   Memungkinkan pengguna masuk ke aplikasi menggunakan username dan password yang telah didaftarkan.

5. **Home**  
   Menampilkan daftar lima pilihan menu kopi dan camilan beserta harga dan deskripsinya.

6. **Profile**  
   Menampilkan informasi nama pengguna serta menyediakan akses ke halaman alamat, halaman utama, dan logout.

7. **Alamat Pengiriman**  
   Memungkinkan pengguna mengisi nama penerima, nomor telepon, dan alamat lengkap untuk keperluan pengiriman pesanan.

8. **Konfirmasi Pesanan**  
   Menampilkan informasi menu yang dipilih, harga, total pembayaran, dan alamat pengiriman sebelum pesanan dikonfirmasi.

## 3. Daftar Menu

Berikut daftar menu yang tersedia pada aplikasi:

| No. | Nama Menu | Harga |
|---|---|---:|
| 1 | Kopi Susu Gula Aren | Rp22.000 |
| 2 | Donat Cokelat | Rp12.000 |
| 3 | Sourdough Loaf | Rp35.000 |
| 4 | Cappuccino | Rp25.000 |
| 5 | Matcha Latte | Rp27.000 |

## 4. Teknologi yang Digunakan

Teknologi dan perangkat pengembangan yang digunakan dalam pembuatan aplikasi ini adalah:

- **Android Studio** – Sebagai IDE untuk mengembangkan aplikasi Android.
- **Kotlin** – Sebagai bahasa pemrograman utama.
- **XML Layout** – Untuk membuat dan mengatur tampilan antarmuka aplikasi.
- **Gradle** – Untuk mengelola proses build dan konfigurasi project.
- **SharedPreferences** – Untuk menyimpan data akun dan alamat pengguna secara lokal.
- **Git dan GitHub** – Untuk mengelola versi dan menyimpan source code aplikasi.

## 5. Cara Menjalankan Aplikasi

Berikut langkah-langkah untuk menjalankan aplikasi Kopi dan Nyemil:

1. Pastikan Android Studio sudah terpasang pada komputer.
2. Clone repository GitHub menggunakan perintah berikut:

   ```bash
   git clone https://github.com/putriazmi657-collab/KopiDanNyemil.git
   ```

3. Buka Android Studio.
4. Pilih menu **Open**, kemudian pilih folder `KopiDanNyemil`.
5. Tunggu proses Gradle Sync hingga selesai.
6. Hubungkan perangkat Android melalui USB atau jalankan emulator.
7. Klik tombol **Run** untuk menjalankan aplikasi.
8. Aplikasi Kopi dan Nyemil siap digunakan.

## 6. Alur Penggunaan Aplikasi

Alur penggunaan aplikasi dimulai dari halaman Splash Screen, kemudian pengguna diarahkan ke halaman Sign Up.

Urutan penggunaan aplikasi:

1. Pengguna membuka aplikasi.
2. Pengguna memilih Register untuk membuat akun baru.
3. Pengguna mengisi nama lengkap, username, dan password.
4. Setelah registrasi berhasil, pengguna melakukan Login.
5. Pengguna masuk ke halaman Home dan memilih salah satu menu.
6. Pengguna mengisi alamat pengiriman.
7. Aplikasi menampilkan halaman Konfirmasi Pesanan.
8. Pengguna memeriksa detail pesanan dan menekan tombol Konfirmasi Pesanan.
9. Setelah berhasil dikonfirmasi, pengguna kembali ke halaman Home.

## 7. Penyimpanan Data

Aplikasi ini menggunakan penyimpanan lokal melalui SharedPreferences untuk menyimpan informasi akun dan alamat pengguna.

Aplikasi tidak menggunakan database maupun backend server. Data yang digunakan disimpan secara lokal pada perangkat.

## 8. Screenshot Tampilan Aplikasi

Berikut dokumentasi tampilan aplikasi Kopi dan Nyemil.

> Tambahkan screenshot asli dari aplikasi pada folder `screenshots` di repository GitHub, kemudian gunakan nama file sesuai daftar berikut.

### Splash Screen
![Splash Screen](screenshots/splash-screen.jpeg)

### Sign Up
![Sign Up](screenshots/sign-up.jpeg)

### Register
![Register](screenshots/register.jpeg)

### Login
![Login](screenshots/login.jpeg)

### Home
![Home](screenshots/home.jpeg)

### Profile
![Profile](screenshots/profile.jpeg)

### Alamat Pengiriman
![Alamat Pengiriman](screenshots/alamat-pengiriman.jpeg)

### Konfirmasi Pesanan
![Konfirmasi Pesanan](screenshots/konfirmasi-pesanan.jpeg)

## 9. Repository GitHub

Source code lengkap aplikasi Kopi dan Nyemil dapat diakses melalui repository berikut:

**GitHub:** https://github.com/putriazmi657-collab/KopiDanNyemil

---

**Dibuat oleh:** Azmi Putri Kuswandi  
**Mata Kuliah:** Pengembangan Aplikasi Mobile  
**Tahun:** 2026
