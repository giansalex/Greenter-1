package com.greenter.core.service;

import android.support.annotation.Nullable;

import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;
import com.greenter.core.model.Product;
import com.greenter.core.model.SaleDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    private DataStore store;

    public ProductService() {
        this.store = DataService.getInstance().getStore();
    }

    public ProductService(DataStore store) {
        this.store = store;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Map<String, String> codes = new HashMap<>();

        for (Invoice invoice :
                store.invoices) {
            for (SaleDetail detail:
                 invoice.getDetails()) {
                Product prod = tryGetProd(detail, codes);
                if (prod != null) {
                    products.add(prod);
                }
            }
        }

        for (Note note :
                store.notes) {
            for (SaleDetail detail:
                    note.getDetails()) {
                Product prod = tryGetProd(detail, codes);
                if (prod != null) {
                    products.add(prod);
                }
            }
        }

        return  products;
    }

    @Nullable
    private Product tryGetProd(SaleDetail detail, Map<String, String> codes) {
        String code = detail.getCodProducto();
        if (code == null || code.isEmpty()) {
            return null;
        }

        if (codes.containsKey(code.trim())) {
            return null;
        }

        Product prod = new Product();
        prod.setCodigo(code);
        prod.setDescripcion(detail.getDesItem());

        return prod;
    }
}
