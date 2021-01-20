package matope.simarro.aplicacion38;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class HipotecasSQLiteHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nombreBD = "HipotecaDB";
    private static SQLiteDatabase.CursorFactory factory = null;

    private String sqlCreacionTablaHipotecas = "CREATE TABLE hipotecas(" +
            " _id INTEGER PRIMARY KEY," +
            " nombre TEXT NOT NULL, " +
            " condiciones TEXT, " +
            " contacto TEXT," +
            " email TEXT," +
            " telefono TEXT," +
            " observaciones TEXT)";

    private String sqlIndiceNombreHipotecas = "CREATE UNIQUE INDEX nombrehipotecas ON hipotecas(nombre ASC)";

    private String[] sqlInsertHipotecas = {"INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(1,'Santander', 'Sin condiciones', " +
            "'Julián Gómez Martínez', 'jgmartinez@gmail.com', '634827472','Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones')",
            "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(2,'BBVA', 'Sin condiciones', " +
                    "'Antonio Díaz Gómez', 'adiaz@gmail.com', '628753726','Tiene toda la documentación y se ha aprobado la operación')",
            "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(3,'La Caixa', 'Condiciones especiales', " +
                    "'Agustin Luque Quintana', 'aluque@gmail.com', '639664736','Tiene toda la documentación y se ha aprobado la operación')", "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(4,'Cajamar', 'Sin condiciones', " +
            "'Maria Ponce Salcedo', 'mponce@gmail.com', '633896537','Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones')",
            "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(5,'Bankia', 'Condiciones especiales', " +
                    "'Maria Amparo Aparicio Ruiz', 'maruiz@gmail.com', '628763410','Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones')",
            "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(6,'Banco Sabadell', 'Condiciones especiales', " +
                    "'Carla Porriño Tomas', 'cporrino@gmail.com', '638557728','Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones')",
            "INSERT INTO hipotecas(_id, nombre, condiciones, contacto, email, telefono, observaciones) VALUES(7,'Banco Popular', 'Condiciones especiales', " +
                    "'Ana Murcia Begoña', 'amurcia@gmail.com', '637997624','Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones')"};

    public HipotecasSQLiteHelper(Context context) {
        super(context, nombreBD, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(this.getClass().toString(), "Creando tabla hipotecas");

        db.execSQL(sqlCreacionTablaHipotecas);
        db.execSQL(sqlIndiceNombreHipotecas);

        Log.i(this.getClass().toString(), "Tabla hipotecas creada");
        Log.i(this.getClass().toString(), "Insertando datos iniciales");

        for (int i = 0; i < sqlInsertHipotecas.length; i++) {
            db.execSQL(sqlInsertHipotecas[i]);
        }

        Log.i(this.getClass().toString(), "Datos iniciales cargados");
        Log.i(this.getClass().toString(), "Base de datos inicial creada");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
