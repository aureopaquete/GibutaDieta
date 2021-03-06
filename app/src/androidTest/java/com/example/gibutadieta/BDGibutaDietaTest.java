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


        //teste CRUD / Tipo Alimentos
        Cursor cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(0,cursorAlimentos.getCount());

        // Teste create/read Alimentos(CRUD)
        String nome = "Carboidratos";
        long idCarboidratos = criaTiposAlimentos(tabelaTiposAlimentos,"Carboidratos", "Batata");

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(1, cursorAlimentos.getCount());

        TiposAlimentos tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idCarboidratos);
        assertEquals(nome, tiposAlimentos.getAlimentos());


        //-------------------------

        // Teste create/read Alimentos (CRUD)
        String Alimentos = "Proteinas";
        long idProteinas = criaTiposAlimentos(tabelaTiposAlimentos,"Proteinas", "Carne Vemelha");

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(2, cursorAlimentos.getCount());

        tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idProteinas);
        assertEquals(Alimentos, tiposAlimentos.getAlimentos());


        // Teste update/ Alimentos (CRUD)

        nome = "Proteinas/Carboidratos";
        tiposAlimentos.setAlimentos(nome);

        int ValoresAlterados = tabelaTiposAlimentos.update(tiposAlimentos.getContentValues(), BdTabelaTiposAlimentos._ID + "=?", new String[]{String.valueOf(idCarboidratos)});
        assertEquals(1,ValoresAlterados);

        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        tiposAlimentos = getAlimentosCOMID(cursorAlimentos, idCarboidratos);

        assertEquals(nome, tiposAlimentos.getAlimentos());


        // Teste Creat/Delete/Read (CRUD)

        long id = criaTiposAlimentos(tabelaTiposAlimentos,"Legumes", "Legumas");
        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(3,cursorAlimentos.getCount());

        tabelaTiposAlimentos.delete(BdTabelaTiposAlimentos._ID + "=?", new String[]{String.valueOf(id)});
        cursorAlimentos = getAlimentos(tabelaTiposAlimentos);
        assertEquals(2, cursorAlimentos.getCount());

        getAlimentosCOMID(cursorAlimentos, idCarboidratos);
        getAlimentosCOMID(cursorAlimentos, idProteinas);

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

        // Teste create/read Bebidas (CRUD)
        nome = "Cafe";
        long idCafe = criaTiposBebidas(tabelaTiposBebidas,nome);

        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(2, cursorBebidas.getCount());

        tiposBebidas = getBebidasCOMID(cursorBebidas, idCafe);
        assertEquals(nome, tiposBebidas.getBebidas());


        // Teste update/ Bebidas (CRUD)

        nome = "Cafe/Agua";
        tiposBebidas.setBebidas(nome);

        int ValoresAlterados = tabelaTiposBebidas.update(tiposBebidas.getContentValues(), BdTabelaTiposBebidas._ID + "=?", new String[]{String.valueOf(idAgua)});
        assertEquals(1,ValoresAlterados);

        cursorBebidas = getBebidas(tabelaTiposBebidas);
        tiposBebidas = getBebidasCOMID(cursorBebidas, idAgua);

        assertEquals(nome, tiposBebidas.getBebidas());


        // Teste Creat/Delete/Read (CRUD)

        long id = criaTiposBebidas(tabelaTiposBebidas,"Testar");
        cursorBebidas = getBebidas(tabelaTiposBebidas);
        assertEquals(3,cursorBebidas.getCount());

        tabelaTiposBebidas.delete(BdTabelaTiposBebidas._ID + "=?", new String[]{String.valueOf(id)});
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

        //teste CRUD / Tipo Quantidades
        Cursor cursorQuantidade= getQuantidade(tabelaQuantidade);
        assertEquals(0,cursorQuantidade.getCount());

        // Teste create/read Quantidade(CRUD)
        int nome = 5;
        long idQuantidades = criaQuantidade(tabelaQuantidade,nome);

        cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(1, cursorQuantidade.getCount());

        Quantidade quantidade = getQuantidadeCOMID(cursorQuantidade, idQuantidades);
        assertEquals(nome, quantidade.getQuantidade());


        //-------------------------

        // Teste create/read Quantidade (CRUD)
        int Nome = 250;
        long idValor = criaQuantidade(tabelaQuantidade,Nome);

        cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(2, cursorQuantidade.getCount());

        quantidade = getQuantidadeCOMID(cursorQuantidade, idValor);
        assertEquals(Nome, quantidade.getQuantidade());


        // Teste update/ Alimentos (CRUD)

        int Nomes = 80;
        quantidade.setQuantidade(Nomes);

        int ValoresAlterados = tabelaQuantidade.update(quantidade.getContentValues(), BdTabelaQuantidade._ID + "=?", new String[]{String.valueOf(idQuantidades)});
        assertEquals(1,ValoresAlterados);

        cursorQuantidade = getQuantidade(tabelaQuantidade);
        quantidade = getQuantidadeCOMID(cursorQuantidade, idQuantidades);

        assertEquals(Nomes, quantidade.getQuantidade());


        // Teste Creat/Delete/Read (CRUD)

        long id = criaQuantidade(tabelaQuantidade,54);
        cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(3,cursorQuantidade.getCount());

        tabelaQuantidade.delete(BdTabelaQuantidade._ID + "=?", new String[]{String.valueOf(id)});
        cursorQuantidade = getQuantidade(tabelaQuantidade);
        assertEquals(2, cursorQuantidade.getCount());

        getQuantidadeCOMID(cursorQuantidade, idQuantidades);
        getQuantidadeCOMID(cursorQuantidade, idValor);

    }



    // Funções Quantidade

    private Quantidade getQuantidadeCOMID(Cursor cursor, long id) {

        Quantidade quantidade = null;
        while (cursor.moveToNext()){
            quantidade = Quantidade.fromCursor(cursor);
            if (quantidade.getId() == id) {
                break;
            }
        }

        assertNotNull(quantidade);
        return quantidade;
    }


    private long criaQuantidade(BdTabelaQuantidade tabelaQuantidade, int Manga) {
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

    private long criaTiposAlimentos(BdTabelaTiposAlimentos tabelaTiposAlimentos, String Alimentos, String descricaoAlimentos) {
        TiposAlimentos tiposAlimentos = new TiposAlimentos();
        tiposAlimentos.setAlimentos(Alimentos);
        tiposAlimentos.setDescricaoAlimentos(descricaoAlimentos);

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
            if (tiposAlimentos.getId() == id) {
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
        tiposBebidas.setDescricaoBebidas(nome);

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
            if (tiposBebidas.getId() == id) {
                break;
            }
        }
        assertNotNull(tiposBebidas);
        return tiposBebidas;
    }



}

