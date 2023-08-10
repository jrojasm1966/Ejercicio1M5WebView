package com.example.ejercicio1m5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ejercicio1m5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding mBinding;
    private EditText sitio;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        sitio = mBinding.et1;
        boton = mBinding.boton1;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmento();
            }
        });

    }
    private void mostrarFragmento() {
        //crar instancia del fragmento
        FragmentWebView fragment = FragmentWebView.newInstance(sitio.getText().toString(),"");
        // OBTENER EL ADMINISTRADOR DE LOS FRAGMENTOS
        FragmentManager fragmentManager= getSupportFragmentManager();
        // iniciar transacción del fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // reemplazar el contenido del contenedor con el fragmento
        transaction.replace(mBinding.container.getId(), fragment);
        // opcional : añadir la transaccion a la pila de retroceso
        transaction.addToBackStack(null);
        transaction.commit();
    }
}