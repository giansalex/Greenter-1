package com.greenter.core.math;

import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
            float mount = note.getMtoImpVenta();
            if (note.getTipoDoc().equals("07")) {
                mount *= -1;
            }
            total += mount;
        }

        return total;
    }

    public Map<String, Float> getByType(int type)
    {
        Date date = new Date(); // your date
        Map<String, Float> des = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.add(Calendar.DATE, -6);
        Date d = cal.getTime();

        while (d.before(date)) {

            cal.setTime(d);
            cal.add(Calendar.DATE, 1);
            d = cal.getTime();
        }

        for (int i = 0; i < 6; i++) {
            switch (type) {
                case 1:
                    des.put("8am", getMount());
                    des.put("10am", getMount());
                    des.put("12pm", getMount());
                    des.put("2pm", getMount());
                    des.put("4pm", getMount());
                    des.put("6pm", getMount());
                    break;
                case 2:
                    des.put("LUN", getMount());
                    des.put("MAR", getMount());
                    des.put("MIE", getMount());
                    des.put("JUE", getMount());
                    des.put("VIE", getMount());
                    des.put("SAB", getMount());
                    break;
                case 3:
                    des.put("JUN", getMount());
                    des.put("JUL", getMount());
                    des.put("AGO", getMount());
                    des.put("SET", getMount());
                    des.put("OCT", getMount());
                    des.put("NOV", getMount());
                    break;
                case 4:
                    des.put("SEM42", getMount());
                    des.put("SEM43", getMount());
                    des.put("SEM44", getMount());
                    des.put("SEM45", getMount());
                    des.put("SEM46", getMount());
                    des.put("SEM47", getMount());
                    break;
            }
        }

        return des;
    }

    float getMount(){
        return (float) (Math.random() * 1400) + 3;
    }
}
