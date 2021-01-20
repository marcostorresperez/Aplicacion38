package matope.simarro.aplicacion38;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.EditText;

public class GestionHipotecasActivity extends AppCompatActivity {
    private HipotecasDAO hipotecasDAO;
    private Cursor cursor;

    private int modo;

    private long id;

    private EditText nombre;
    private EditText condiciones;
    private EditText contacto;
    private EditText telefono;
    private EditText email;
    private EditText observaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_hipotecas);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if (extra == null) return;

        // Obtenemos los elementos de la vista

        nombre = (EditText) findViewById(R.id.nombre);
        condiciones = (EditText) findViewById(R.id.condiciones);
        contacto = (EditText) findViewById(R.id.contacto);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        observaciones = (EditText) findViewById(R.id.observaciones);

        // Creamos el DAO

        hipotecasDAO = new HipotecasDAO(this);
        try {
            hipotecasDAO.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (extra.containsKey(HipotecasDAO.C_COLUMNA_ID)) {
            id = extra.getLong(HipotecasDAO.C_COLUMNA_ID);
            consultar(id);
        }

        // Establecemos el modo del formulario

        establecerModo(extra.getInt(Constantes.C_MODO));
    }

    private void establecerModo(int m) {
        this.modo = m;
        // Si estamos solamente visualizando establecemos el modo edicion desactivado a todo el formulario
        if (modo == Constantes.C_VISUALIZAR) {
            this.setTitle(nombre.getText().toString());
            this.setEdicion(false);
        }
    }

    private void consultar(long id) {

        // Consultamos el centro por el identificador

        cursor = hipotecasDAO.getRegistro(id);
        nombre.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_NOMBRE)));
        condiciones.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_CONDICIONES)));
        contacto.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_CONTACTO)));
        telefono.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_TELEFONO)));
        email.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_EMAIL)));
        observaciones.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_OBSERVACIONES)));
    }

    private void setEdicion(boolean opcion) {
        nombre.setEnabled(opcion);
        condiciones.setEnabled(opcion);
        contacto.setEnabled(opcion);
        telefono.setEnabled(opcion);
        email.setEnabled(opcion);
        observaciones.setEnabled(opcion);
    }
}

