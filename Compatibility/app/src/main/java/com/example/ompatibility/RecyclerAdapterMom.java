package com.example.ompatibility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterMom extends RecyclerView.Adapter<RecyclerAdapterMom.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Recycler> recyclers;

    //конструктор
    RecyclerAdapterMom(Context context, List<Recycler> recyclers) {
        this.recyclers = recyclers;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapterMom.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterMom.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Recycler recycler = recyclers.get(position);
        holder.imageView.setImageResource(recycler.getImageResource());
        holder.nameView.setText(recycler.getName());
        holder.sDescView.setText(recycler.getsDesc());

        //обрабатываем нажатие на кнопку "описание"
        final Context context = holder.button.getContext();
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, DescActivityMom.class);
                        intent.putExtra("mom1", 1);

                        break;
                    case 1:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 2);




                        break;
                    case 2:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 3);


                        break;
                    case 3:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 4);



                        break;
                    case 4:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 5);



                        break;
                    case 5:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 6);



                        break;
                    default:
                        intent = new Intent(context, DescActivityMom.class);

                        intent.putExtra("mom1", 0);


                        break;
                }
                //запускаем экран
                context.startActivity(intent);
            }
        });


        //обрабатываем нажатие на кнопку "+"
        final Context context2 = holder.buttonPlus.getContext();
        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 1);



                        break;
                    case 1:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 2);



                        break;
                    case 2:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 3);




                        break;
                    case 3:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 4);



                        break;
                    case 4:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 5);



                        break;

                    default:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("momDB1", 0);



                        break;
                }
                //запускаем экран
                context2.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return recyclers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, sDescView;
        public Button button, buttonPlus;

        ViewHolder(View view) {
            super(view);
            //связываем элементы по id
            imageView = view.findViewById(R.id.im);
            nameView = view.findViewById(R.id.txtName);
            sDescView = view.findViewById(R.id.txtDesc);
            button = view.findViewById(R.id.btnDesc);
            buttonPlus = view.findViewById(R.id.btnPlus);
        }
    }
}
