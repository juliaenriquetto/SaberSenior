package com.example.sabersenior.JogoVelha;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.example.sabersenior.R;

public class PrefFragment extends PreferenceFragmentCompat {
   @Override
   public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
       addPreferencesFromResource(R.xml.preferences);
   }
}
