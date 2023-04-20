package com.example.convertisseur.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.convertisseur.R;
import com.example.convertisseur.databinding.FragmentHomeBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private ImageView openMenu1;
    private ImageView openMenu2;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.setHomeModel(homeViewModel);
        View root = binding.getRoot();

        openMenu1 = (ImageView) root.findViewById(R.id.imageView4);
        openMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                try {
                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popupMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper
                                    .getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod(
                                    "setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.us:
                                homeViewModel.i = 0;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_us);
                                return true;
                            case R.id.e:
                                homeViewModel.i = 1;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_e);
                                return true;
                            case R.id.jap:
                                homeViewModel.i = 2;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_jap);
                                return true;
                            case R.id.uk:
                                homeViewModel.i = 3;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_uk);
                                return true;
                            case R.id.china:
                                homeViewModel.i = 4;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_china);
                            case R.id.aus:
                                homeViewModel.i = 5;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_aus);
                                return true;
                            case R.id.canada:
                                homeViewModel.i = 6;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_canada);
                                return true;
                            case R.id.suiss:
                                homeViewModel.i = 7;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_suiss);
                                return true;
                            case R.id.hk:
                                homeViewModel.i = 8;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flasg_hk);
                                return true;
                            case R.id.sing:
                                homeViewModel.i = 9;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagIn.set(R.drawable.flag_sing);
                            default:
                                return false;

                        }
                    }
                });
                popupMenu.show();
            }
        });

        openMenu2 = (ImageView) root.findViewById(R.id.imageView6);
        openMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                try {
                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popupMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper
                                    .getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod(
                                    "setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.us:
                                homeViewModel.j = 0;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_us);
                                return true;
                            case R.id.e:
                                homeViewModel.j = 1;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_e);
                                return true;
                            case R.id.jap:
                                homeViewModel.j = 2;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_jap);
                                return true;
                            case R.id.uk:
                                homeViewModel.j = 3;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_uk);
                                return true;
                            case R.id.china:
                                homeViewModel.j = 4;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_china);
                            case R.id.aus:
                                homeViewModel.j = 5;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_aus);
                                return true;
                            case R.id.canada:
                                homeViewModel.j = 6;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_canada);
                                return true;
                            case R.id.suiss:
                                homeViewModel.j = 7;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_suiss);
                                return true;
                            case R.id.hk:
                                homeViewModel.j = 8;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flasg_hk);
                                return true;
                            case R.id.sing:
                                homeViewModel.j = 9;
                                homeViewModel.setIn(homeViewModel.inD.getValue());
                                homeViewModel.flagOut.set(R.drawable.flag_sing);
                            default:
                                return false;

                        }
                    }
                });
                popupMenu.show();
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}