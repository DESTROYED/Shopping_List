package com.lidchanin.crudindiploma.forlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidchanin.crudindiploma.Constants;
import com.lidchanin.crudindiploma.R;
import com.lidchanin.crudindiploma.activities.ShoppingListFragmentManager;
import com.lidchanin.crudindiploma.utils.SharedPrefsManager;

import java.util.List;

/**
 * Created by Alexander Destroyed on 13.10.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<RecyclerViewItems> recyclerViewItemses;
    private Activity activity;
    private int page;

    public RecyclerViewAdapter (List<RecyclerViewItems> recyclerViewItemses, Context context, int page){
        this.recyclerViewItemses = recyclerViewItemses;
        this.page = page;
        activity =(Activity) context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPrefsManager(activity).editString(Constants.SharedPreferences.PREF_KEY_THEME, recyclerViewItemses.get(holder.getAdapterPosition()).getTheme());
                Intent intent = new Intent(activity, ShoppingListFragmentManager.class);
                intent.putExtra(Constants.Bundles.SHOPPING_LIST_ID,Constants.Bundles.SETTINGS_FRAGMENT_ID);
                intent.putExtra(Constants.Bundles.VIEWPAGER_PAGE,page);
                activity.startActivity(intent);
            }
        });
        holder.themeName.setText(recyclerViewItemses.get(holder.getAdapterPosition()).getName());
        holder.themeImage.setImageResource(recyclerViewItemses.get(holder.getAdapterPosition()).getPreviewId());
        holder.themeCost.setText(recyclerViewItemses.get(holder.getAdapterPosition()).getCost());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItemses.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private CardView rootView;
        private TextView themeName;
        private TextView themeCost;
        private ImageView themeImage;

        /**
         * Constructor.
         *
         * @param itemView - item in {@link RecyclerView}.
         */
        RecyclerViewHolder(View itemView) {
            super(itemView);
            rootView = (CardView) itemView.findViewById(R.id.theme_root_view);
            themeName = (TextView) itemView.findViewById(R.id.theme_name);
            themeCost = (TextView) itemView.findViewById(R.id.theme_cost);
            themeImage = (ImageView) itemView.findViewById(R.id.theme_image);
        }
    }
}

