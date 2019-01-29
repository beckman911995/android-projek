package firmansyahprojek.myapplicationkitten;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by USER on 23/01/2019.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampelViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList){
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item,parent,false);
        return new ExampelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampelViewHolder holder, int position) {
        ExampleItem currenItem = mExampleList.get(position);

        String imageUrl = currenItem.getImageUrl();
        String creatorName = currenItem.getCreator();
        int likeCount = currenItem.getlikeCount();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampelViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;


        public ExampelViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image_view);
            mTextViewCreator = (TextView)itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = (TextView)itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                        public void onClick(View v) {
                            if (mListener !=null) {
                                int position = getAdapterPosition();
                                if (position != RecyclerView.NO_POSITION){
                                    mListener.onItemClick(position);

                                }
                            }
                }
            });
        }
    }

}
