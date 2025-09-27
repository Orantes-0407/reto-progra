package com.example.zenquotesapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.zenquotesapp.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmocionActivity extends AppCompatActivity {
    private EditText editEmocion;
    private TextView textFrase;
    private Button btnGenerar, btnRegresar;

    private Map<String, String[]> frasesPorEmocion;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emocion);
        editEmocion = findViewById(R.id.editEmocion);
        textFrase = findViewById(R.id.textFrase);
        btnGenerar = findViewById(R.id.btnGenerar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Inicializar las frases por emoción
        frasesPorEmocion = new HashMap<>();
        frasesPorEmocion.put("feliz", new String[]{
            "¡Sigue disfrutando cada momento!",
            "La felicidad se comparte, ¡contágiala!",
            "Tu alegría ilumina el día de otros."
        });
        frasesPorEmocion.put("triste", new String[]{
            "Todo pasa, incluso los momentos difíciles.",
            "Después de la tormenta, sale el sol.",
            "Eres más fuerte de lo que crees."
        });
        frasesPorEmocion.put("ansioso", new String[]{
            "Respira hondo, todo estará bien.",
            "Confía en ti, puedes superar cualquier reto.",
            "La calma llega cuando te enfocas en el presente."
        });
        frasesPorEmocion.put("enojado", new String[]{
            "La serenidad es tu mejor aliada.",
            "Respira y deja ir lo que no puedes controlar.",
            "Transforma tu energía en acciones positivas."
        });
        frasesPorEmocion.put("motivado", new String[]{
            "¡Sigue adelante, tus metas están cerca!",
            "La constancia te llevará al éxito.",
            "Cada paso cuenta, no te detengas."
        });
        frasesPorEmocion.put("default", new String[]{
            "Cada día es una nueva oportunidad.",
            "Confía en ti, eres capaz de lograrlo.",
            "Nunca dejes de soñar y luchar por tus metas."
        });

        btnGenerar.setOnClickListener(v -> {
            String emocion = editEmocion.getText().toString().trim();
            if (!emocion.isEmpty()) {
                generarFrase(emocion);
            } else {
                textFrase.setText("Por favor ingresa una emoción.");
            }
        });

        btnRegresar.setOnClickListener(v -> {
            finish();
        });
    }

    private void generarFrase(String emocion) {
        String clave = frasesPorEmocion.containsKey(emocion.toLowerCase()) ? emocion.toLowerCase() : "default";
        String[] frases = frasesPorEmocion.get(clave);
        String frase = frases[random.nextInt(frases.length)];
        textFrase.setText("Emoción: " + emocion + "\n\n" + frase);
    }
}
