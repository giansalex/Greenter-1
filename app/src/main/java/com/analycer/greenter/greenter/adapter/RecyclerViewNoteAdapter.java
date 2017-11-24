package com.analycer.greenter.greenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewNoteAdapter extends RecyclerView.Adapter<RecyclerViewNoteAdapter.ViewHolder>{

    private List<Note> datasetlist;
    private Context mContext;
    private int redColor,greenColor;

    public RecyclerViewNoteAdapter(Context context) {
        this.datasetlist = new ArrayList<Note>();
        mContext = context;
        redColor = mContext.getResources().getColor(R.color.red);
        greenColor = mContext.getResources().getColor(R.color.green);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_factura, parent, false);

        return new ViewHolder(v);
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

    public void setElement(List<Note> datasetlist){
        this.datasetlist = datasetlist;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCorrelativo;
        TextView montoTotal;
        TextView nombreCliente;

        public ViewHolder(View itemView) {
            super(itemView);
            this.txtCorrelativo = itemView.findViewById(R.id.txCrrltvo);
            this.montoTotal = itemView.findViewById(R.id.txtTotal);
            this.nombreCliente = itemView.findViewById(R.id.txtCliente);

        }

        public void bindData(Note mNote, int redColor, int greenColor) {
            String moneda = mNote.getTipoMoneda() == "USD" ? "$" : "S/";
            txtCorrelativo.setText(mNote.getSerie() + "-" + mNote.getCorrelativo());
            montoTotal.setText(moneda + " " + mNote.getMtoImpVenta());
            nombreCliente.setText(mNote.getClient().getRznSocial());
            // montoTotal.setTextColor(mInvoice.getTipoOperacion().isEmpty()? redColor : greenColor);
        }

        public void setOnItemClickListener(final Note element,final OnItemClickListenerFac listener){

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(element);
//                }
//            });

        }
    }
}
