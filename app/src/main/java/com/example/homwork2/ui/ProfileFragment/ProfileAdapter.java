package com.example.homwork2.ui.ProfileFragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homwork2.databinding.ItemProfileBinding;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private ArrayList<Model> data;

    public ProfileAdapter(ArrayList<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        private ItemProfileBinding binding;

        public ProfileViewHolder(@NonNull ItemProfileBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Model model) {
            binding.image1.setImageResource(model.getImage1());
            binding.image2.setImageResource(model.getImage2());
            binding.image3.setImageResource(model.getImage3());
        }
    }
}
