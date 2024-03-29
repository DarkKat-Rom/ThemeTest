/*
 * Copyright (C) 2019 DarkKat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.darkkatrom.themetest.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import net.darkkatrom.themetest.R;
import net.darkkatrom.themetest.utils.Config;
import net.darkkatrom.themetest.utils.ThemeHelper;

public class SettingsFragment extends PreferenceFragmentCompat {

    public static final String TAG = "SettingsFragmentTag";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);

        findPreference(Config.PREF_KEY_APP_THEME).setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        String appTheme = (String) newValue;
                        ThemeHelper.applyTheme(appTheme);
                        return true;
                    }
                });
    }

    @Override
    public void onResume() {
        ((AppCompatActivity) getActivity())
                    .getSupportActionBar().setTitle(R.string.toolbar_settings_subtitle);
        super.onResume();
    }
}