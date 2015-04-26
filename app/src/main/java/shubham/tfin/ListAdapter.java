package shubham.tfin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shubham on 4/26/15.
 */
public class ListAdapter extends BaseAdapter{
    ArrayList<ListItem> myList = new ArrayList<ListItem>();
    LayoutInflater inflater;
    Context context;

    public ListAdapter(ArrayList<ListItem> myList, Context context) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item,null);
            mViewHolder = new ViewHolder();
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.tvDishName = detail(convertView, R.id.idDishTile, myList.get(position).getDishName());
        mViewHolder.tvRate = detail(convertView, R.id.idRate, myList.get(position).getRate());
        mViewHolder.ivImg = detail(convertView, R.id.idImageView, myList.get(position).getImg());

        return convertView;
    }

    private TextView detail(View v, int resID, String name){
        TextView tv = (TextView) v.findViewById(resID);
        tv.setText(name);
        return tv;
    }

    private TextView detail(View v, int resID, double rate){
        TextView tv = (TextView) v.findViewById(resID);
        tv.setText("\u20B9" + rate + "/-");
        return tv;
    }

    private ImageView detail(View v, int resID, int src){
        ImageView im = (ImageView) v.findViewById(resID);
        im.setImageResource(src);
        return im;
    }

    class ViewHolder
    {
        TextView tvDishName, tvRate;
        ImageView ivImg;
    }
}
