package matope.simarro.aplicacion38;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class HipotecasCursorAdapter extends CursorAdapter {

    private HipotecasDAO hipotecasDAO = null;

    public HipotecasCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        hipotecasDAO = new HipotecasDAO(context);
        hipotecasDAO.abrir();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view;
        int i = cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_NOMBRE);
        tv.setText(cursor.getString(i));
    }
}
