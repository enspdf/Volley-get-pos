package com.example.sebastianhiguita.postvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    Button btnGuardar;
    String url = "";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtName);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        queue = Volley.newRequestQueue(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://shackox.apphb.com/api/Parqueaderos/43";
                JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response) {
                                // response
                                //Log.d("Response", response);
                                ParqueaderoDTO parqueadero = new ParqueaderoDTO();
                                try {
                                    parqueadero.setIdParqueadero(response.getInt("IdParqueadero"));
                                    parqueadero.setNombreParqueadero(response.getString("nombre"));
                                    Log.d("IdParqueadero", String.valueOf(parqueadero.getIdParqueadero()));
                                    Log.d("Nombre", parqueadero.getNombreParqueadero());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError response) {
                                // error
                                Log.d("Error.Response", response.getMessage());
                                Toast.makeText(getApplicationContext(), "Error response", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                queue.add(getRequest);
            }
        });
    }
}
