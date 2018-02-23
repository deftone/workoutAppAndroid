package de.deftone.bitsandpizzas.helper;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 */

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private List<String> captions;
    private List<Integer> imageIds;
    private Listener listener;

    public interface Listener{
        void  onClick(int position);
    }

    public CaptionedImagesAdapter(List<String> captions, List<Integer> imageIds){
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_exercise, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.card_view_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds.get(position));
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions.get(position));
        TextView textView = cardView.findViewById(R.id.card_view_desc);
        textView.setText(captions.get(position));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
