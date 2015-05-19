package shubham.tfin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by shubham on 5/5/15.
 */
public class FoodClassAdapter extends RecyclerView.Adapter<FoodClassAdapter.MyViewHolder> {
    private LayoutInflater inflator;
    Context context;
    List<FoodListData> list = Collections.emptyList();

    public FoodClassAdapter(Context context, List<FoodListData> dataList) {
        inflator = LayoutInflater.from(context);
        list = dataList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.food_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final FoodListData curr = list.get(position);
        holder.title.setText(curr.FTitle);
        holder.img.setImageResource(curr.FImgID);
        holder.rate.setText("\u20B9" + curr.FPrice);
        holder.quant.setText(String.valueOf(curr.FQuantity));

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePreview preview = new ImagePreview(context);
                switch (position % 4) {
                    case 0:
                        ((ImageView) preview.findViewById(R.id.idPreviewImage)).setImageResource(R.drawable.goa256);
                        preview.show();
                        break;
                    case 1:
                        ((ImageView) preview.findViewById(R.id.idPreviewImage)).setImageResource(R.drawable.maharas256);
                        preview.show();
                        break;
                    case 2:
                        ((ImageView) preview.findViewById(R.id.idPreviewImage)).setImageResource(R.drawable.south256);
                        preview.show();
                        break;
                    case 3:
                        ((ImageView) preview.findViewById(R.id.idPreviewImage)).setImageResource(R.drawable.rajasthani256);
                        preview.show();
                        break;
                }
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr.FQuantity++;
                holder.quant.setText(String.valueOf(curr.FQuantity));
            }
        });

        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr.FQuantity--;
                holder.quant.setText(String.valueOf(curr.FQuantity));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId())
//        {
//            case R.id.idFoodImg:
//                ImagePreview preview = new ImagePreview(context);
//
//                preview.show();
//        }
//    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView img;
        TextView rate;
        TextView quant;
        ImageButton add,sub;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.idTitle);
            img = (ImageView) itemView.findViewById(R.id.idFoodImg);
            rate = (TextView) itemView.findViewById(R.id.idPrice);
            quant = (TextView) itemView.findViewById(R.id.idQuant);
            add = (ImageButton) itemView.findViewById(R.id.idAddItem);
            sub = (ImageButton) itemView.findViewById(R.id.idSubItem);
        }
    }
}
