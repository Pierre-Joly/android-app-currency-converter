package com.example.convertisseur.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convertisseur.R;
import com.example.convertisseur.databinding.FragmentDashboardBinding;
import com.example.convertisseur.databinding.ItemDashboardBinding;

import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerviewDashboard;
        ListAdapter<String, DashboardViewHolder> adapter = new DashboardAdapter();
        recyclerView.setAdapter(adapter);
        dashboardViewModel.getTexts().observe(getViewLifecycleOwner(), adapter::submitList);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private static class DashboardAdapter extends ListAdapter<String, DashboardViewHolder> {

        private final List<Integer> drawables = Arrays.asList(
                R.drawable.flag_us,
                R.drawable.flag_e,
                R.drawable.flag_jap,
                R.drawable.flag_uk,
                R.drawable.flag_china,
                R.drawable.flag_aus,
                R.drawable.flag_canada,
                R.drawable.flag_suiss,
                R.drawable.flasg_hk,
                R.drawable.flag_sing
        );

        protected DashboardAdapter() {
            super(new DiffUtil.ItemCallback<String>() {
                @Override
                public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                    return oldItem.equals(newItem);
                }
            });
        }

        @NonNull
        @Override
        public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemDashboardBinding binding = ItemDashboardBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new DashboardViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
            holder.textView.setText(getItem(position));
            holder.imageView.setImageDrawable(
                    ResourcesCompat.getDrawable(holder.imageView.getResources(),
                            drawables.get(position),
                            null));
        }
    }

    private static class DashboardViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public DashboardViewHolder(ItemDashboardBinding binding) {
            super(binding.getRoot());
            imageView = binding.imageViewItemDashboard;
            textView = binding.textViewItemDashboard;
        }
    }
}