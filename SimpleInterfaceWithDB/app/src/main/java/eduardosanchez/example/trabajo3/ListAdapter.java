package eduardosanchez.example.trabajo3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;

    private List<ListElement> mData;

    private ArrayList<String> movie_id, movie_title, movie_type, movie_status;
    public ListAdapter(Context context,
                       ArrayList<String> movie_id,
                       ArrayList<String> movie_title,
                       ArrayList<String> movie_type,
                       ArrayList<String> movie_status) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_type = movie_type;
        this.movie_status = movie_status;
        mData = createListElements(movie_id.size());

    }
    private List<ListElement> createListElements(int sizeArray){
        mData = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < sizeArray; i++) {
            int number = random.nextInt(999999);
            @SuppressLint("DefaultLocale") String  color = "#"+ String.format("%06d", number);
            ListElement element = new ListElement( color, movie_title.get(i), movie_type.get(i), movie_status.get(i));
            mData.add(element);
        }
        return mData;
    }
    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items) { mData = items; }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, type, status;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            type = itemView.findViewById(R.id.typeTextView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListElement item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            type.setText(item.getType());
            status.setText(item.getStatus());
        }
    }

}
