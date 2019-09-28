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

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import net.darkkatrom.themetest.R;
import net.darkkatrom.themetest.utils.ThemeHelper;
import net.darkkatrom.themetest.utils.Config;

public class MainFragment extends Fragment {

    public static final String TAG = "MainFragmentTag";
    
    private boolean mViewCreated = false;
    private View mRootView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRootView = view;
        mViewCreated = true;
        updateContent();
    }

    public void updateContent() {
        if (!mViewCreated) {
            return;
        }
        Resources res = getResources();
        if (res == null) {
            return;
        }

        int systemTheme = ThemeHelper.getSystemTheme(getActivity());
        if (systemTheme == ThemeHelper.THEME_ERROR) {
            return;
        }

        int appTheme = ThemeHelper.getAppTheme(getActivity());

        View systemThemeLayout = mRootView.findViewById(R.id.fragment_main_system_theme_layout);
        TextView systemThemeLayoutTitle = (TextView) mRootView.findViewById(R.id.system_theme_layout_title);
        ImageView systemThemeLayoutImage = (ImageView) mRootView.findViewById(R.id.system_theme_layout_image);
        View appThemeLayout = mRootView.findViewById(R.id.fragment_main_app_theme_layout);
        TextView appThemeLayoutTitle = (TextView) mRootView.findViewById(R.id.app_theme_layout_title);
        ImageView appThemeLayoutImage = (ImageView) mRootView.findViewById(R.id.app_theme_layout_image);

        int systemThemeBgColor;
        int systemThemeTextColor;
        int systemThemeIconColor;
        Drawable systemThemeIcon;
        int appThemeBgColor;
        int appThemeTextColor;
        int appThemeIconColor;
        Drawable appThemeIcon;

        boolean colorizeImage = Config.getColorizeThemeImage(getActivity());

        switch (systemTheme) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                systemThemeBgColor = getActivity().getColor(R.color.bg_tint_day);
                systemThemeTextColor = getActivity().getColor(R.color.text_day);
                systemThemeIconColor =  colorizeImage
                        ? getActivity().getColor(R.color.icon_tint_day_colored)
                        : getActivity().getColor(R.color.icon_tint_day);
                systemThemeIcon = getActivity().getDrawable(R.drawable.ic_day);
                break;
            case AppCompatDelegate.MODE_NIGHT_YES:
                systemThemeBgColor = getActivity().getColor(R.color.bg_tint_night);
                systemThemeTextColor = getActivity().getColor(R.color.text_night);
                systemThemeIconColor = colorizeImage
                        ? getActivity().getColor(R.color.icon_tint_night_colored)
                        : getActivity().getColor(R.color.icon_tint_night);
                systemThemeIcon = getActivity().getDrawable(R.drawable.ic_night);
                break;
            default:
                systemThemeBgColor = getActivity().getColor(R.color.bg_tint_day);
                systemThemeTextColor = getActivity().getColor(R.color.text_day);
                systemThemeIconColor = colorizeImage
                        ? getActivity().getColor(R.color.icon_tint_day_colored)
                        : getActivity().getColor(R.color.icon_tint_day);
                systemThemeIcon = getActivity().getDrawable(R.drawable.ic_day);
                break;
        }

        switch (appTheme) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                appThemeBgColor = getActivity().getColor(R.color.bg_tint_day);
                appThemeTextColor = getActivity().getColor(R.color.text_day);
                appThemeIconColor = colorizeImage
                        ? getActivity().getColor(R.color.icon_tint_day_colored)
                        : getActivity().getColor(R.color.icon_tint_day);
                appThemeIcon = getActivity().getDrawable(R.drawable.ic_day);
                break;
            case AppCompatDelegate.MODE_NIGHT_YES:
                appThemeBgColor = getActivity().getColor(R.color.bg_tint_night);
                appThemeTextColor = getActivity().getColor(R.color.text_night);
                appThemeIconColor = colorizeImage
                        ? getActivity().getColor(R.color.icon_tint_night_colored)
                        : getActivity().getColor(R.color.icon_tint_night);
                appThemeIcon = getActivity().getDrawable(R.drawable.ic_night);
                break;
            default:
                appThemeBgColor = systemThemeBgColor;
                appThemeTextColor = systemThemeTextColor;
                appThemeIconColor = systemThemeIconColor;
                appThemeIcon = systemThemeIcon;
                break;
        }
        
        systemThemeLayout.setBackgroundColor(systemThemeBgColor);
        systemThemeLayoutTitle.setTextColor(systemThemeTextColor);
        systemThemeLayoutImage.setImageTintList(ColorStateList.valueOf(systemThemeIconColor));
        systemThemeLayoutImage.setImageDrawable(systemThemeIcon);
        appThemeLayout.setBackgroundColor(appThemeBgColor);
        appThemeLayoutTitle.setTextColor(appThemeTextColor);
        appThemeLayoutImage.setImageTintList(ColorStateList.valueOf(appThemeIconColor));
        appThemeLayoutImage.setImageDrawable(appThemeIcon);
    }
}