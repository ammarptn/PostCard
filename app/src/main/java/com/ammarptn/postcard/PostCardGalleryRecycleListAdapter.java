package com.ammarptn.postcard;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ammarptn on 7/7/2558.
 */
public class PostCardGalleryRecycleListAdapter extends RecyclerView.Adapter<PostCardGalleryRecycleListAdapter.ViewHolder> {


    ArrayList<PostCardGalleryItem> willowGalleryItems  = new ArrayList<>();
    Context context;

    public PostCardGalleryRecycleListAdapter(Context context, ArrayList<PostCardGalleryItem> willowGalleryItems) {
        this.willowGalleryItems = willowGalleryItems;
        this.context=context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.postcard_item, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        //viewHolder.bg.setImageResource(backgroundListItems.get(i).getBackgroundID());


        viewHolder.owner.setText("" + willowGalleryItems.get(i).getOwner());

        if(willowGalleryItems.get(i).getUrl()!=null)
        {
            Glide.with(context)
                    .load(willowGalleryItems.get(i).getUrl())
                    .override(200, 200)
                    .into(viewHolder.bg);
        }



    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return willowGalleryItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView owner;
        private final CardView card;
        // each data item is just a string in this case

        public ImageView bg;



        public ViewHolder(View itemView) {
            super(itemView);

            owner = (TextView)itemView.findViewById(R.id.textView);
            bg = (ImageView)itemView.findViewById(R.id.imageView);
            card = (CardView)itemView.findViewById(R.id.card_view);



        }

    }




}
