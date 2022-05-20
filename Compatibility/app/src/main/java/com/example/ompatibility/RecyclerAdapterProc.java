package com.example.ompatibility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ompatibility.db.DatabaseHelper;

import java.util.List;

public class RecyclerAdapterProc extends RecyclerView.Adapter<RecyclerAdapterProc.ViewHolder> {



    private final LayoutInflater inflater;
    private final List<Recycler> recyclers;
    SQLiteDatabase db;


    RecyclerAdapterProc(Context context, List<Recycler> recyclers) {
        this.recyclers = recyclers;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapterProc.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterProc.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Recycler recycler = recyclers.get(position);
        holder.imageView.setImageResource(recycler.getImageResource());
        holder.nameView.setText(recycler.getName());
        holder.sDescView.setText(recycler.getsDesc());



        final Context context = holder.buttonDesc.getContext();
        holder.buttonDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                switch (position) {
                    case 0:
                        intent = new Intent(context, DescActivityProc.class);
                        intent.putExtra("proc1", 1);

                        break;
                    case 1:
                        intent = new Intent(context, DescActivityProc.class);

                        intent.putExtra("proc1", 2);




                        break;
                    case 2:
                        intent = new Intent(context, DescActivityProc.class);

                        intent.putExtra("proc1", 3);


                        break;
                    case 3:
                        intent = new Intent(context, DescActivityProc.class);

                        intent.putExtra("proc1", 4);



                        break;
                    case 4:
                        intent = new Intent(context, DescActivityProc.class);

                        intent.putExtra("proc1", 5);



                        break;


                    default:
                        intent = new Intent(context, DescActivityProc.class);

                        intent.putExtra("proc1", 0);


                        break;
                }
                context.startActivity(intent);
            }
        });



        final Context context2 = holder.buttonPlus.getContext();
        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 1);



                        break;
                    case 1:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 2);



                        break;
                    case 2:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 3);




                        break;
                    case 3:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 4);



                        break;
                    case 4:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 5);



                        break;

                    default:
                        intent = new Intent(context2, MainActivity2.class);
                        intent.putExtra("procDB1", 0);



                        break;
                }
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
        public Button buttonDesc, buttonPlus;

        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.im);
            nameView = view.findViewById(R.id.txtName);
            sDescView = view.findViewById(R.id.txtDesc);
            buttonDesc = view.findViewById(R.id.btnDesc);
            buttonPlus = view.findViewById(R.id.btnPlus);
        }
    }

    public void readDB(){
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;

    }


}
