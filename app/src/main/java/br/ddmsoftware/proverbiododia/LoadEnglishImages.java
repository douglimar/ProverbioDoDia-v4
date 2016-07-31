
package br.ddmsoftware.proverbiododia;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by douglimar on 26/09/15.
 */
public class LoadEnglishImages {

/*
    public int[] imagesEn = {R.drawable.alexanderpope_en01, R.drawable.alexanderpope_en02, R.drawable.alexanderpope_en03,
            R.drawable.alexanderpope_en04, R.drawable.alexanderpope_en05, R.drawable.alexanderpope_en06, R.drawable.alexanderpope_en07,
            R.drawable.alexanderpope_en08, R.drawable.alexanderpope_en09, R.drawable.alexanderpope_en10,
            R.drawable.adamsmith_en01, R.drawable.adamsmith_en02,R.drawable.adamsmith_en03,R.drawable.adamsmith_en04,
            R.drawable.adamsmith_en05,R.drawable.adamsmith_en06,R.drawable.adamsmith_en07,R.drawable.adamsmith_en08,
            R.drawable.adamsmith_en09,R.drawable.adamsmith_en10,R.drawable.adamsmith_en11,R.drawable.adamsmith_en12,
            R.drawable.aristotle_en01, R.drawable.aristotle_en02,R.drawable.aristotle_en03, R.drawable.aristotle_en04,
            R.drawable.aristotle_en05, R.drawable.aristotle_en06, R.drawable.aristotle_en07, R.drawable.aristotle_en08, R.drawable.aristotle_en09,
            R.drawable.bob_en01,R.drawable.bob_en02, R.drawable.bob_en03, R.drawable.bob_en04, R.drawable.bob_en05, R.drawable.bob_en06,
            R.drawable.bob_en07, R.drawable.bob_en08, R.drawable.bob_en09, R.drawable.bob_en10,R.drawable.bob_en11, R.drawable.bob_en12,
            R.drawable.bob_en13, R.drawable.bob_en14, R.drawable.bob_en15, R.drawable.bob_en16, R.drawable.bob_en17, R.drawable.bob_en18, R.drawable.bob_en19, R.drawable.bob_en20,
            R.drawable.confucius01, R.drawable.confucius02, R.drawable.confucius03,R.drawable.confucius04, R.drawable.confucius05, R.drawable.confucius06, R.drawable.confucius07,
            R.drawable.confucius08, R.drawable.confucius09, R.drawable.confucius10, R.drawable.confucius11, R.drawable.confucius12, R.drawable.confucius13, R.drawable.confucius14,
            R.drawable.confucius15, R.drawable.confucius16, R.drawable.confucius17, R.drawable.confucius18,
            R.drawable.chaplin_en01, R.drawable.chaplin_en02, R.drawable.chaplin_en03, R.drawable.chaplin_en04, R.drawable.chaplin_en05, R.drawable.chaplin_en06, R.drawable.chaplin_en07, R.drawable.chaplin_en08,
            R.drawable.chaplin_en09, R.drawable.chaplin_en10, R.drawable.chaplin_en11, R.drawable.chaplin_en12, R.drawable.chaplin_en13, R.drawable.chaplin_en14, R.drawable.chaplin_en15,
            R.drawable.dickens_en01,R.drawable.dickens_en02, R.drawable.dickens_en03, R.drawable.dickens_en04, R.drawable.dickens_en05, R.drawable.dickens_en06, R.drawable.dickens_en07, R.drawable.dickens_en08, R.drawable.dickens_en09, R.drawable.dickens_en10,
*/


    public int[] imagesEn = {R.drawable.alexanderpope_en01, R.drawable.alexanderpope_en02, R.drawable.alexanderpope_en03,
            R.drawable.alexanderpope_en04, R.drawable.alexanderpope_en05, R.drawable.alexanderpope_en06, R.drawable.alexanderpope_en07,
            R.drawable.alexanderpope_en08, R.drawable.alexanderpope_en09, R.drawable.alexanderpope_en10,
            R.drawable.adamsmith_en01, R.drawable.adamsmith_en02,R.drawable.adamsmith_en03,R.drawable.adamsmith_en04,
            R.drawable.adamsmith_en05,R.drawable.adamsmith_en06,R.drawable.adamsmith_en07,R.drawable.adamsmith_en08,
            R.drawable.adamsmith_en09,R.drawable.adamsmith_en10,R.drawable.adamsmith_en11,R.drawable.adamsmith_en12,
            R.drawable.aristotle_en01, R.drawable.aristotle_en02,R.drawable.aristotle_en03, R.drawable.aristotle_en04,
            R.drawable.aristotle_en05, R.drawable.aristotle_en06, R.drawable.aristotle_en07, R.drawable.aristotle_en08, R.drawable.aristotle_en09,
            R.drawable.bob_en01,R.drawable.bob_en02, R.drawable.bob_en03, R.drawable.bob_en04, R.drawable.bob_en05, R.drawable.bob_en06,
            R.drawable.bob_en07, R.drawable.bob_en08, R.drawable.bob_en09, R.drawable.bob_en10,R.drawable.bob_en11, R.drawable.bob_en12,
            R.drawable.bob_en13, R.drawable.bob_en14, R.drawable.bob_en15, R.drawable.bob_en16, R.drawable.bob_en17, R.drawable.bob_en18, R.drawable.bob_en19, R.drawable.bob_en20,
            R.drawable.confucius01, R.drawable.confucius02, R.drawable.confucius03,R.drawable.confucius04, R.drawable.confucius05, R.drawable.confucius06, R.drawable.confucius07,
            R.drawable.confucius08, R.drawable.confucius09, R.drawable.confucius10, R.drawable.confucius11, R.drawable.confucius12, R.drawable.confucius13, R.drawable.confucius14,
            R.drawable.confucius15, R.drawable.confucius16, R.drawable.confucius17, R.drawable.confucius18,
            R.drawable.chaplin_en01, R.drawable.chaplin_en02, R.drawable.chaplin_en03, R.drawable.chaplin_en04, R.drawable.chaplin_en05, R.drawable.chaplin_en06, R.drawable.chaplin_en07, R.drawable.chaplin_en08,
            R.drawable.chaplin_en09, R.drawable.chaplin_en10, R.drawable.chaplin_en11, R.drawable.chaplin_en12, R.drawable.chaplin_en13, R.drawable.chaplin_en14, R.drawable.chaplin_en15,
            R.drawable.dickens_en01,R.drawable.dickens_en02, R.drawable.dickens_en03, R.drawable.dickens_en04, R.drawable.dickens_en05, R.drawable.dickens_en06, R.drawable.dickens_en07, R.drawable.dickens_en08, R.drawable.dickens_en09, R.drawable.dickens_en10,
            R.drawable.einstein_en01,R.drawable.einstein_en02,R.drawable.einstein_en03,R.drawable.einstein_en04,R.drawable.einstein_en05,
            R.drawable.einstein_en06,R.drawable.einstein_en07,R.drawable.einstein_en08,R.drawable.einstein_en09,R.drawable.einstein_en10,
            R.drawable.freud_en01, R.drawable.freud_en02, R.drawable.freud_en03, R.drawable.freud_en04, R.drawable.freud_en05, R.drawable.freud_en06,
            R.drawable.freud_en07, R.drawable.freud_en08, R.drawable.freud_en09, R.drawable.freud_en10,
            R.drawable.nietzsche_en01, R.drawable.nietzsche_en02, R.drawable.nietzsche_en03, R.drawable.nietzsche_en04, R.drawable.nietzsche_en05, R.drawable.nietzsche_en06, R.drawable.nietzsche_en07, R.drawable.nietzsche_en08, R.drawable.nietzsche_en09,
            R.drawable.gandhi_en01, R.drawable.gandhi_en02, R.drawable.gandhi_en03, R.drawable.gandhi_en04, R.drawable.gandhi_en05, R.drawable.gandhi_en06, R.drawable.gandhi_en07, R.drawable.gandhi_en08, R.drawable.gandhi_en09, R.drawable.gandhi_en10,
            R.drawable.henryford_en01, R.drawable.henryford_en02, R.drawable.henryford_en03, R.drawable.henryford_en04, R.drawable.henryford_en05, R.drawable.henryford_en06, R.drawable.henryford_en07, R.drawable.henryford_en08,
            R.drawable.marx_en01, R.drawable.marx_en02, R.drawable.marx_en03, R.drawable.marx_en04, R.drawable.marx_en05, R.drawable.marx_en06, R.drawable.marx_en07, R.drawable.marx_en08,
            R.drawable.malcomx_en01, R.drawable.malcomx_en02, R.drawable.malcomx_en03, R.drawable.malcomx_en04, R.drawable.malcomx_en05, R.drawable.malcomx_en06, R.drawable.malcomx_en07, R.drawable.malcomx_en08, R.drawable.malcomx_en09, R.drawable.malcomx_en10,
            R.drawable.marcus_aurelius_en01, R.drawable.marcus_aurelius_en02, R.drawable.marcus_aurelius_en03, R.drawable.marcus_aurelius_en04, R.drawable.marcus_aurelius_en05, R.drawable.marcus_aurelius_en06, R.drawable.marcus_aurelius_en07, R.drawable.marcus_aurelius_en08,
            R.drawable.marg_tatcher_en01, R.drawable.marg_tatcher_en02, R.drawable.marg_tatcher_en03, R.drawable.marg_tatcher_en04, R.drawable.marg_tatcher_en05, R.drawable.marg_tatcher_en06, R.drawable.marg_tatcher_en07, R.drawable.marg_tatcher_en08, R.drawable.marg_tatcher_en09, R.drawable.marg_tatcher_en10,
            R.drawable.marilyn_monroe_en01, R.drawable.marilyn_monroe_en02, R.drawable.marilyn_monroe_en03, R.drawable.marilyn_monroe_en04, R.drawable.marilyn_monroe_en05, R.drawable.marilyn_monroe_en06, R.drawable.marilyn_monroe_en07, R.drawable.marilyn_monroe_en08, R.drawable.marilyn_monroe_en09,

            R.drawable.marktwain_en01, R.drawable.marktwain_en02, R.drawable.marktwain_en03, R.drawable.marktwain_en04, R.drawable.marktwain_en05, R.drawable.marktwain_en06, R.drawable.marktwain_en07, R.drawable.marktwain_en08, R.drawable.marktwain_en09, R.drawable.marktwain_en10,

    };


    public int[] loadQuotes() {

        getAllImages();

        return imagesEn;

    }


    public int getQuoteImageEn() {

        //getAllImages();

        Random random = new Random();

        int indice = random.nextInt(imagesEn.length);

        return imagesEn[indice];
    }

    public void getAllImages(){

        Field[] ID_Fields = R.drawable.class.getFields();
        int[] resArray = new int[ID_Fields.length];

        for (int i =0; i<ID_Fields.length;i++) {

            try {

                resArray[i] = ID_Fields[i].getInt(null);

            } catch (Exception e) {

                e.printStackTrace();
            }

        }


    }


}