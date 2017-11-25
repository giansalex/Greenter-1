package com.analycer.greenter.greenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.greenter.core.model.Company;
import com.greenter.core.model.Invoice;

import java.util.List;

/**
 * Created by User on 24/11/2017.
 */

public class AdapterListUsers extends RecyclerView.Adapter<AdapterListUsers.UserViewHolder> {


    private List<Company> lsCompany;
    private Context context;
    private OnItemClickListClient clickListener;

    public AdapterListUsers(Context context)
    {
        this.context = context;
        //this.lsCompany = lsModelSms;
    }


    public void setOnItemClickListener(OnItemClickListClient clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.iten_list_clients, parent, false);
        return new UserViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        String mNumberUser = lsCompany.get(position).getRuc();
        //String mMessage = lsCompany.get(position).getRazonSocial();
        String mFullname = lsCompany.get(position).getNombreComercial();
        /*char[] getName = mMessage.toCharArray();
        for (char c:getName){
                char sam =c;
                if (getName.length>15){
                }
        }*/
        if (this.clickListener != null) {
            holder.setOnItemClickListener(lsCompany.get(position), this.clickListener);
        }
        /*if (lsCompany.get(position).getMessage_sent()){
            holder.imgCheck.setImageResource(R.drawable.correct);
        }else {
            holder.imgCheck.setImageResource(R.drawable.wrong);
        }*/

        holder.txtNumber.setText(mNumberUser);
        holder.txtName.setText(mFullname);
    }

    public void mReset(){
        notifyDataSetChanged();
    }

    public List<Company> getLsCompany() {
        return lsCompany;
    }

    public void setElement(List<Company> lsModelSms) {
        this.lsCompany = lsModelSms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lsCompany.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtNumber;
        protected TextView txtName;
        protected ImageView imgCheck;
        public UserViewHolder(View itemView)
        {
            super(itemView);
            //imgCheck = (ImageView) itemView.findViewById(R.id.ticket_icon);
            txtNumber = (TextView) itemView.findViewById(R.id.textView);
            txtName = (TextView) itemView.findViewById(R.id.textView2);
        }

        public void setOnItemClickListener(final Company element, final OnItemClickListClient listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                }
            });

        }
    }
}