package com.example.adiligencia;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class criaBanco extends SQLiteOpenHelper {

    private static final String NOME = "nome";
    private static final String TABELA = "usuarios";
    private static final String ID = "_id";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";
    private static final int VERSAO = 1;

    public criaBanco(Context context) {
        super(context, "banco.db", null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criar tabela
        String sql = "CREATE TABLE " + TABELA + "(" + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + EMAIL + " text,"
                + SENHA + " text"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
