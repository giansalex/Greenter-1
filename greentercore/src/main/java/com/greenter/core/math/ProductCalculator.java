package com.greenter.core.math;

import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;
import com.greenter.core.model.Product;
import com.greenter.core.model.ProductExtend;
import com.greenter.core.model.SaleDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCalculator {
    private DataStore data;

    public ProductCalculator(DataStore data) {
        this.data = data;
    }

    public List<ProductExtend> getTotals(List<Product> products) {
        Map<String, Float> codeTotals = new HashMap<>();

        for (Invoice invoice :
                data.invoices) {
            for (SaleDetail detail:
                    invoice.getDetails()) {
                float mount = detail.getMtoValorVenta();
                if (codeTotals.containsKey(detail.getCodProducto())) {
                    mount += codeTotals.get(detail.getCodProducto());
                }
                codeTotals.put(detail.getCodProducto(), mount);
            }
        }

        for (Note note :
                data.notes) {
            String tipo = note.getTipoDoc();
            for (SaleDetail detail:
                    note.getDetails()) {

                float mount = detail.getMtoValorVenta();
                if (tipo.equals("07")) {
                    mount *= -1;
                }

                if (codeTotals.containsKey(detail.getCodProducto())) {
                    mount += codeTotals.get(detail.getCodProducto());
                }
                codeTotals.put(detail.getCodProducto(), mount);
            }
        }

        List<ProductExtend> items = new ArrayList<>(products.size());

        for (Product prod : products) {
            ProductExtend ext = new ProductExtend();
            ext.setProduct(prod);

            for(Map.Entry<String, Float> entry : codeTotals.entrySet()) {
                String key = entry.getKey();
                Float value = entry.getValue();
                if (prod.getCodigo().equals(key)) {
                    ext.setTotal(value);
                    break;
                }
            }

            items.add(ext);
        }
        
        return items;
    }
}
