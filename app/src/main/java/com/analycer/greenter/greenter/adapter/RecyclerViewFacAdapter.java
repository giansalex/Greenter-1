package com.analycer.greenter.greenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.greenter.core.model.Invoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 22/11/2017.
 */

public class RecyclerViewFacAdapter extends RecyclerView.Adapter<RecyclerViewFacAdapter.ViewHolder> {

    private List<Invoice> datasetlist;
    private Context mContext;
    private OnItemClickListenerFac clickListener;
    private int redColor,greenColor;

    public RecyclerViewFacAdapter(Context context) {
        this.datasetlist = new ArrayList<Invoice>();
        mContext = context;
        redColor = mContext.getResources().getColor(R.color.red);
        greenColor = mContext.getResources().getColor(R.color.green);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_factura, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.bindData(datasetlist.get(position),redColor,greenColor);

    }

    @Override
    public int getItemCount() {
        return datasetlist.size();
    }

    public void addElement(Invoice element){
        datasetlist.add(0, element);
        notifyDataSetChanged();
    }

    public void setElement(List<Invoice> datasetlist){
        this.datasetlist = datasetlist;
        notifyDataSetChanged();
    }
    public void clear() {
        datasetlist.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCorrelativo;
        TextView montoTotal;
        TextView nombreCliente;

        public ViewHolder(View itemView) {
            super(itemView);
            this.txtCorrelativo = (TextView) itemView.findViewById(R.id.txCrrltvo);
            this.montoTotal = (TextView) itemView.findViewById(R.id.txtTotal);
            this.nombreCliente = (TextView) itemView.findViewById(R.id.txtCliente);

        }

        public void bindData(Invoice mInvoice,int redColor,int greenColor) {
            String moneda = mInvoice.getTipoMoneda() == "USD" ? "$" : "S/";
            txtCorrelativo.setText(mInvoice.getSerie() + "-" + mInvoice.getCorrelativo());
            montoTotal.setText(moneda + " " +  mInvoice.getMtoImpVenta());
            nombreCliente.setText(mInvoice.getClient().getRznSocial());
           // montoTotal.setTextColor(mInvoice.getTipoOperacion().isEmpty()? redColor : greenColor);
        }

        public void setOnItemClickListener(final Invoice element,final OnItemClickListenerFac listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                }
            });

        }
    }


}
