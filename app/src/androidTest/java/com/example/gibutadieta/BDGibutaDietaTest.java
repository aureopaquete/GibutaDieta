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


}

