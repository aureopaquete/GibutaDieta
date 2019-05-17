package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BDGibutaDietaTest {
    @Test
    public void apagarBaseDados() {
        getAppContext().deleteDatabase(BdGibutaDietaOpenHelper.NOME_BASE_DADOS);
    }

    public void criaBdGibutaDieta(){
        Context appContext = getAppContext();

        BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(appContext);

        SQLiteDatabase db = openHelper.getReadableDatabase(); //BD pra fazer leitura

        assertTrue("Não foi possível Criar BdGibutaDieta",db.isOpen()); //Mensagem se caso não conseguir criar a base de dados
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getTargetContext();
    }


    public void testCRUD() {
        BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase(); //BD pra fazer escrita

        BdTabelaTiposAlimentos tabelaTiposAlimentos = new BdTabelaTiposAlimentos(db);

        // Teste read tabela alimentos (CRUD)
        Cursor cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(0,cursorAlimentos.getCount());

        // Teste create/read Alimentos (CRUD)
        String nome = "Carboidratos";
        long idCarboidratos = criaTiposAlimentos(tabelaTiposAlimentos,nome);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(1, cursorAlimentos.getCount());

        TiposAlimentos tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idCarboidratos);
        assertEquals(nome, tiposAlimentos.getAlimentos());

        // -----------------

        nome = "Legumes";
        long idLegumes = criaTiposAlimentos(tabelaTiposAlimentos,nome);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(2, cursorAlimentos.getCount());

        tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idLegumes);
        assertEquals(nome, tiposAlimentos.getAlimentos());
    }



    // Funções
    private long criaTiposAlimentos(BdTabelaTiposAlimentos tabelaTiposAlimentos, String nome) {
        TiposAlimentos tiposAlimentos = new TiposAlimentos();
        tiposAlimentos.setAlimentos(nome);

        long id = tabelaTiposAlimentos.insert(tiposAlimentos.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getAlimentos(BdTabelaTiposAlimentos tabelaTiposAlimentos) {
        return tabelaTiposAlimentos.query(BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, null, null, null);

    }
    private TiposAlimentos getAlimentosCOMID(Cursor cursor, long id) {
           TiposAlimentos tiposAlimentos = null;
           while (cursor.moveToNext()){
               tiposAlimentos = TiposAlimentos.fromCursor(cursor);
               if (tiposAlimentos.getId_Alimentos() == id) {
                   break;
               }
           }
           assertNotNull(tiposAlimentos);
           return tiposAlimentos;
    }

}

