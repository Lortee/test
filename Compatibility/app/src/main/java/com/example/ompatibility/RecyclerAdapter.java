package com.example.ompatibility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Recycler> recyclers;

    RecyclerAdapter(Context context, List<Recycler> recyclers) {
        this.recyclers = recyclers;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        Recycler recycler = recyclers.get(position);
        holder.imageView.setImageResource(recycler.getImageResource());
        holder.nameView.setText(recycler.getName());
        holder.sDescView.setText(recycler.getsDesc());
    }

    @Override
    public int getItemCount() {
        return recyclers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, sDescView;

        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.im);
            nameView = view.findViewById(R.id.txtName);
            sDescView = view.findViewById(R.id.txtDesc);
        }
    }
}
