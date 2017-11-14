package com.greenter.core.math;

import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

public class SaleCalculator {
    private DataStore data;

    public SaleCalculator(DataStore data) {
        this.data = data;
    }

    /**
     * Get total from venta.
     * @return total
     */
    public float getTotal() {
        float total = 0;
        for (Invoice invoice :
                data.invoices) {
            total += invoice.getMtoImpVenta();
        }

        for (Note note :
                data.notes) {
            total -= note.getMtoImpVenta();
        }

        return total;
    }
}
