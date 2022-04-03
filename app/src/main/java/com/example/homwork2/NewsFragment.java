package com.example.homwork2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.homwork2.databinding.FragmentNewsBinding;
import com.example.homwork2.models.News;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private News news;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        news = (News) requireArguments().getSerializable("updateTask");

            if (news != null) binding.EditText.setText(news.getTitle());


            binding.btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    save();
                }
            });
        }

        private void save () {
            Bundle bundle = new Bundle();
            String text = binding.EditText.getText().toString().trim();
            String text1 = binding.EditText.getText().toString();
            if (text1.isEmpty()) {
                YoYo.with(Techniques.Shake).duration(700).repeat(1).playOn(binding.EditText);
            }
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "type task!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (news == null) {
                news = new News(text, System.currentTimeMillis());
            } else {
                news.setTitle(text);
            }
            App.getDatabase().newsDao().insert(news);
            bundle.putSerializable("news", news);
            getParentFragmentManager().setFragmentResult("rk_news", bundle);
            saveToFireStore(news);
        }

    private void saveToFireStore(News news) {
        db.collection("news")
                .add(news)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                        close();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}
