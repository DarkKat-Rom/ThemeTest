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

package net.darkkatrom.themetest.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import net.darkkatrom.themetest.R;
import net.darkkatrom.themetest.fragments.MainFragment;
import net.darkkatrom.themetest.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (savedInstanceState == null) {
            showFragment(MainFragment.TAG);
        }
    }

    public void showFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            switch (tag) {
                case MainFragment.TAG: {
                    fragment = new MainFragment();
                    break;
                }
                case SettingsFragment.TAG: {
                    fragment = new SettingsFragment();
                    break;
                }
                default: {
                    fragment = new MainFragment();
                    break;
                }
            }
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragment instanceof SettingsFragment) {
            ft.addToBackStack(null);
        }
        ft.replace(R.id.fragment_layout, fragment, tag)
            .commit();
    }
}