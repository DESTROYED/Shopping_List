package com.lidchanin.crudindiploma;

import android.os.Environment;

public interface Constants {
    interface Tessaract{

        String SLASH="/";
        String DATA_PATH = String.valueOf(Environment.getExternalStorageDirectory());
        String TESSDATA = "tessdata";
        String RUS_TESS_SHARED ="rus";
        String ENG_TESS_SHARED ="eng";
        String ENGTRAIN = "eng.traineddata";
        String RUSTRAIN = "rus.traineddata";
    }
    interface SharedPreferences{
        String PREF_KEY_LANG_RECOGNIZE = "recognize_lang";
        String PREF_KEY_SCAN_TIMES = "scan_times";
        String PREF_KEY_THEME="theme";
    }
}