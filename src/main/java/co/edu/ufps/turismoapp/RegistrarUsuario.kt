package co.edu.ufps.turismoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegistrarUsuario : AppCompatActivity() {
    lateinit var usuario: TextInputEditText
    lateinit var clave: TextInputEditText
    lateinit var registrar: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)
        usuario =findViewById(R.id.usuario)
        clave =findViewById(R.id.clave)
        registrar =findViewById(R.id.registrar)
        registrar.setOnClickListener{
            createAccount(usuario.text.toString(), clave.text.toString())
        }

    }

    fun createAccount(){
        val addOnCompleteListener =
            auth.createUserWithEmailAndPassword(email: String, password: String)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        finish()
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        updateUI(null)
                    }
                }
    }


}