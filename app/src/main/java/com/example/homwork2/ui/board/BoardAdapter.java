package com.example.homwork2.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.homwork2.R;
import com.example.homwork2.databinding.ItemNewsBinding;
import com.example.homwork2.models.Board;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder>{
    private ArrayList<Board> list;
    private FinishBoard finishBoard;
    private final int[] lottie = new int [] {R.raw.anime_one};

    public void setFinishBoard(FinishBoard finishBoard) {
        this.finishBoard = finishBoard;
    }

    public BoardAdapter() {
        list = new ArrayList<>();
        list.add(new Board("Фаст Фуд", "Добро пожаловать!", R.drawable.ic_fastfod));
        list.add(new Board("Машина", "Бексултан ТОП", R.drawable.ic_car));
        list.add(new Board("Копилка", "Бексултан ТОП", R.drawable.kopilka));
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private Button btn_start;
        private TextView textTitle;
        private TextView textInfo;
        private LottieAnimationView animationView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            btn_start = itemView.findViewById(R.id.btnStart);
            textInfo = itemView.findViewById(R.id.text_info);
            animationView = itemView.findViewById(R.id.animationView);
            btn_start.setOnClickListener(view -> {
            finishBoard.btnClickFinishBoard();
            });
        }

        public void bind(int position) {
            Board board= list.get(position);
            textTitle.setText(board.getTitle());
            textInfo.setText(board.getDesc());
            if (position == list.size() - 1){
                btn_start.setVisibility(View.VISIBLE);
            }else{
                btn_start.setVisibility(View.INVISIBLE);
            }
        }
    }

    interface FinishBoard{
        void  btnClickFinishBoard();
    }

}
