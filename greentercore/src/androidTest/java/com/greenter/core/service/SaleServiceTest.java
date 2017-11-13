package com.greenter.core.service;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.androidnetworking.AndroidNetworking;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Invoice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SaleServiceTest {

    @Before
    public void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        AndroidNetworking.initialize(context);
    }

    @Test
    public void getList() throws Exception {
        SaleService service = new SaleService(new ApiDataRequest<List<Invoice>>() {
            @Override
            public void setApiResponse(List<Invoice> data) {
                assertTrue("Lista vacía",data.size() > 0);
            }
        });
        service.getList("20480072872");
    }
}
