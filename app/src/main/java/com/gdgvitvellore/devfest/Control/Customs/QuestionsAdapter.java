package com.gdgvitvellore.devfest.Control.Customs;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gdgvitvellore.devfest.Entity.Actors.Faq;
import com.gdgvitvellore.devfest.gdgdevfest.R;

import java.util.ArrayList;


public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ParentViewHolder>{

    private static final String TAG = "TAG";
    private ArrayList<Faq> questionArrayList ;

    public QuestionsAdapter(ArrayList<Faq> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }

    class ParentViewHolder extends RecyclerView.ViewHolder{

        private TextView tvQuestionTitle ;
        private ImageButton ibQuestionAnswer ;

        ParentViewHolder(View itemView) {
            super(itemView);
            tvQuestionTitle = (TextView) itemView.findViewById(R.id.card_list_parent_question_title) ;
            ibQuestionAnswer = (ImageButton) itemView.findViewById(R.id.card_list_parent_question_answer) ;
        }
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_faq_general_parent, parent, false);

        return new ParentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ParentViewHolder holder, final int position) {
        final Faq question = questionArrayList.get(position);
        holder.tvQuestionTitle.setText(question.getQuestion());
        holder.ibQuestionAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: " + position);
                Log.i(TAG, "onClick: " + question.getAnswer());
            }
        });

    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }
}