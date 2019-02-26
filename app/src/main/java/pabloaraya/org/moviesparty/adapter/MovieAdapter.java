package pabloaraya.org.moviesparty.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import pabloaraya.org.moviesparty.R;
import pabloaraya.org.view.modelview.MovieModelView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<MovieModelView> movieModelViews;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public AppCompatTextView mTextView;
        public AppCompatImageView mPosterView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.titleView);
            mPosterView = v.findViewById(R.id.posterView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieAdapter(List<MovieModelView> movieModelViews) {
        this.movieModelViews = movieModelViews;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(movieModelViews.get(position).title);
        Picasso.get().load(movieModelViews.get(position).poster).into(holder.mPosterView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movieModelViews.size();
    }
}
