package com.analycer.greenter.data.graph;

import com.greenter.core.model.Invoice;

import java.util.List;


public class Ventas {

    public float getTotal(List<Invoice> invoices)
    {
        float total = 0;
        for (Invoice invoice :
                invoices) {
            total += invoice.getMtoImpVenta();
        }

        return total;
    }
}
