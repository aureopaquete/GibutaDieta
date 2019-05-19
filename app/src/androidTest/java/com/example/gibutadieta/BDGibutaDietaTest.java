package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
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
    @Before
    public void apagarBaseDados() {
        getAppContext().deleteDatabase(BdGibutaDietaOpenHelper.NOME_BASE_DADOS);
    }
    @Test
    public void criaBdGibutaDieta(){
        Context appContext = getAppContext();

        BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(appContext);

        SQLiteDatabase db = openHelper.getReadableDatabase(); //BD pra fazer leitura

        assertTrue("Não foi possível Criar BdGibutaDieta",db.isOpen()); //Mensagem se caso não conseguir criar a base de dados
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testCRUDAlimento() {
        BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase(); //BD pra fazer escrita

        BdTabelaTiposAlimentos tabelaTiposAlimentos = new BdTabelaTiposAlimentos(db);

        // Teste read alimentos (CRUD)
        Cursor cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(0, cursorAlimentos.getCount());

        // Teste create/read Alimentos (CRUD)
        String nome = "Carboidratos";
        long idCarboidratos = criaTiposAlimentos(tabelaTiposAlimentos, nome);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(1, cursorAlimentos.getCount());

        TiposAlimentos tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idCarboidratos);
        assertEquals(nome, tiposAlimentos.getAlimentos());

        // -----------------

        nome = "Legumes";
        long idLegumes = criaTiposAlimentos(tabelaTiposAlimentos, nome);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(2, cursorAlimentos.getCount());

        tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idLegumes);
        assertEquals(nome, tiposAlimentos.getAlimentos());

        // Teste update/ Alimentos (CRUD)

        nome = "Proteinas/legumes";
        tiposAlimentos.setAlimentos(nome);

        int registosAlterados = tabelaTiposAlimentos.update(tiposAlimentos.getContentValues(), BdTabelaTiposAlimentos.ID + "=?", new String[]{String.valueOf(idLegumes)});
        assertEquals(1, registosAlterados);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idLegumes);

        assertEquals(nome, tiposAlimentos.getAlimentos());

        // Teste Creat/Delete/Read (CRUD)

        long id = criaTiposAlimentos(tabelaTiposAlimentos, "Testar");
        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(3, cursorAlimentos.getCount());

        tabelaTiposAlimentos.delete(BdTabelaTiposAlimentos.ID + "=?", new String[]{String.valueOf(id)});
        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(2, cursorAlimentos.getCount());

        getAlimentosCOMID(cursorAlimentos, idLegumes);
        getAlimentosCOMID(cursorAlimentos, idCarboidratos);
    }
        //--------------------------------------------------------------------//
        @Test
        public void testCRUDBebida() {
            BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(getAppContext());
            SQLiteDatabase db = openHelper.getWritableDatabase(); //BD pra fazer escrita

            BdTabelaTiposBebidas tabelaTiposBebidas= new BdTabelaTiposBebidas(db);

        //teste CRUD / Tipo Bebidas
        Cursor cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(0,cursorBebidas.getCount());

        // Teste create/read Bebidas (CRUD)
        String nome = "Agua";
        long idAgua = criaTiposBebidas(tabelaTiposBebidas,nome);

        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(1, cursorBebidas.getCount());

        TiposBebidas tiposBebidas = getBebidasCOMID(cursorBebidas, idAgua);
        assertEquals(nome, tiposBebidas.getBebidas());


        //-------------------------

        // Teste create/read Alimentos (CRUD)
        nome = "Cafe";
        long idCafe = criaTiposBebidas(tabelaTiposBebidas,nome);

        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(2, cursorBebidas.getCount());

        tiposBebidas = getBebidasCOMID(cursorBebidas, idCafe);
        assertEquals(nome, tiposBebidas.getBebidas());


        // Teste update/ Alimentos (CRUD)

        nome = "Cafe/Agua";
        tiposBebidas.setBebidas(nome);

        int ValoresAlterados = tabelaTiposBebidas.update(tiposBebidas.getContentValues(), BdTabelaTiposBebidas.ID + "=?", new String[]{String.valueOf(idAgua)});
        assertEquals(1,ValoresAlterados);

        cursorBebidas = getBebidas(tabelaTiposBebidas);
        tiposBebidas = getBebidasCOMID(cursorBebidas, idAgua);

        assertEquals(nome, tiposBebidas.getBebidas());


        // Teste Creat/Delete/Read (CRUD)

        long id = criaTiposBebidas(tabelaTiposBebidas,"Testar");
        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(3,cursorBebidas.getCount());

        tabelaTiposBebidas.delete(BdTabelaTiposBebidas.ID + "=?", new String[]{String.valueOf(id)});
        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(2, cursorBebidas.getCount());

        getBebidasCOMID(cursorBebidas, idAgua);
        getBebidasCOMID(cursorBebidas, idCafe);

        }


    //--------------------------------------------------------------------//
    @Test
    public void testCRUDQuantidade() {
        BdGibutaDietaOpenHelper openHelper = new BdGibutaDietaOpenHelper(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase(); //BD pra fazer escrita

        BdTabelaQuantidade tabelaQuantidade= new BdTabelaQuantidade(db);

        //teste CRUD / Quantidade
        Cursor cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(0,cursorQuantidade.getCount());

        //Teste create/ Quantidade
        String Manga = "5";


       long id = criaQuantidade(tabelaQuantidade,  Manga);
        cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(1, cursorQuantidade.getCount());

        Quantidade quantidade = getQuantidadeCOMID(cursorQuantidade,id);
        assertEquals(Manga,quantidade.getQuantidade());


    }



    // Funções Quantidade

    private Quantidade getQuantidadeCOMID(Cursor cursor, long id) {

        Quantidade quantidade = null;
        while (cursor.moveToNext()){
            quantidade = Quantidade.fromCursor(cursor);
            if (quantidade.getId_Quantidade() == id) {
                break;
            }
        }

        assertNotNull(quantidade);
        return quantidade;
    }


    private long criaQuantidade(BdTabelaQuantidade tabelaQuantidade, String Manga) {
        Quantidade quantidade = new Quantidade();

        quantidade.setQuantidade(Manga);



        long id = tabelaQuantidade.insert(quantidade.getContentValues());
        assertNotEquals(-1, id);

        return id;

    }


    private Cursor getQuantidade(BdTabelaQuantidade tabelaQuantidade) {
        return tabelaQuantidade.query(BdTabelaQuantidade.TODAS_COLUNAS, null, null, null, null, null);
    }


    // Funções Alimentos

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


    // Funções Bebidas

    private long criaTiposBebidas(BdTabelaTiposBebidas tabelaTiposBebidas, String nome) {
        TiposBebidas tiposBebidas = new TiposBebidas();
        tiposBebidas.setBebidas(nome);



        long id = tabelaTiposBebidas.insert(tiposBebidas.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getBebidas(BdTabelaTiposBebidas tabelaTiposBebidas) {
        return tabelaTiposBebidas.query(BdTabelaTiposBebidas.TODAS_COLUNAS, null, null, null, null, null);
    }

    private TiposBebidas getBebidasCOMID(Cursor cursor, long id) {
        TiposBebidas tiposBebidas = null;
        while (cursor.moveToNext()){
            tiposBebidas= TiposBebidas.fromCursor(cursor);
            if (tiposBebidas.getId_Bebidas() == id) {
                break;
            }
        }
        assertNotNull(tiposBebidas);
        return tiposBebidas;
    }



}

