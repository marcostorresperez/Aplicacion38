package matope.simarro.aplicacion38;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HipotecasDAO {

    public static final String C_TABLA = "hipotecas";

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_COLUMNA_ID = "_id";
    public static final String C_COLUMNA_NOMBRE = "nombre";
    public static final String C_COLUMNA_CONDICIONES = "condiciones";
    public static final String C_COLUMNA_CONTACTO = "contacto";
    public static final String C_COLUMNA_EMAIL = "email";
    public static final String C_COLUMNA_TELEFONO = "telefono";
    public static final String C_COLUMNA_OBSERVACIONES = "observaciones";

    private Context contexto;
    private HipotecasSQLiteHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_CONDICIONES,
            C_COLUMNA_CONTACTO, C_COLUMNA_EMAIL, C_COLUMNA_TELEFONO, C_COLUMNA_OBSERVACIONES};

    public HipotecasDAO(Context context) {
        this.contexto = context;
    }

    public HipotecasDAO abrir() {
        dbHelper = new HipotecasSQLiteHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbHelper.close();
    }

    /**
     * Devuelve un cursor con todas las filas y todas las columnas de la tabla
     */

    public Cursor getCursor() {
        Cursor c = db.query(true, C_TABLA, columnas, null, null, null, null, null, null);
        return c;
    }

    public Cursor getRegistro(long id) {
        String condicion = C_COLUMNA_ID + "=" + id;
        Cursor c = db.query(true, C_TABLA, columnas, condicion, null, null, null, null, null);

        //Nos movemos al primer registro de la consulta
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
}
