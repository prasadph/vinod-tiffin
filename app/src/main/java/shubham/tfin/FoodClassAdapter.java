package shubham.tfin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by shubham on 5/5/15.
 */
public class FoodClassAdapter extends RecyclerView.Adapter<FoodClassAdapter.MyViewHolder> {
    private LayoutInflater inflator;
    List<FoodListData> list = Collections.emptyList();

    public FoodClassAdapter(Context context, List<FoodListData> dataList) {
        inflator = LayoutInflater.from(context);
        list = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.food_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FoodListData curr = list.get(position);
        holder.title.setText(curr.FTitle);
        holder.img.setImageResource(curr.FImgID);
        holder.rate.setText("\u20B9" + curr.FPrice);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView img;
        TextView rate;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.idTitle);
            img = (ImageView) itemView.findViewById(R.id.idFoodImg);
            rate = (TextView) itemView.findViewById(R.id.idPrice);
        }
    }
}
