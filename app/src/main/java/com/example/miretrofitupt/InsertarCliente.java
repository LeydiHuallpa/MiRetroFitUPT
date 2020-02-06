package com.example.miretrofitupt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InsertarCliente  extends AppCompatActivity {
    @BindView(R.id.nombre)
    EditText edtnombre;
    @BindView(R.id.apellido)
    EditText edtapellido;
    @BindView(R.id.sexo)
    Spinner spsexo;
    @BindView(R.id.direccion)
    EditText edtdireccion;
    @BindView(R.id.telefono)
    EditText edttelefono;
    Retrofit retrofit;
    servicioRetrofit miserviceretrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_cliente);
        ButterKnife.bind(this);
        final String url = "https://testand1.000webhostapp.com/";
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        miserviceretrofit = retrofit.create(servicioRetrofit.class);
    }

}