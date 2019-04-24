package com.example.yueyingwu.testapp;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;

public class customListview extends ArrayAdapter<String> {

    private String[] pdfName;
    private Integer[] picID;
    private Activity context;

    public customListview(Activity context,String[] pdfName,Integer[] picID){
        super(context,R.layout.listview_content,pdfName);

        this.context=context;
        this.pdfName=pdfName;
        this.picID=picID;
    }

//    @androidx.annotation.NonNull
//    @androidx.annotation.Nullable
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View r=convertView;
        viewHolder viewholder =null;
        if(r==null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_content, null, true);
            viewholder=new viewHolder(r);
            r.setTag(viewholder);
        }else{
            viewholder=(viewHolder) r.getTag();
        }
        viewholder.figureList.setImageResource(picID[position]);
        viewholder.figureList.setScaleType(ImageView.ScaleType.FIT_XY);
        viewholder.namelist.setText(pdfName[position]);

        return r;
    }
    class viewHolder{
        TextView namelist;
        ImageView figureList;

        viewHolder(View v){
            namelist=(TextView) v.findViewById(R.id.tvName);
            figureList=(ImageView) v.findViewById(R.id.figure1);
        }
    }

}
