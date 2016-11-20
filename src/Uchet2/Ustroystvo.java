package Uchet2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ustroystvo {
    Ustroystvo() {
        type = "defaulttype";
        sku = 0;
        name = "defaultname";
        dateOfNew = new Date();
    }

    public String type;
    public int sku;
    public String name;
    public Date dateOfNew;

    public void setScu(String inputScu) {
        try {
            this.sku = Integer.parseInt(inputScu.trim());
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат sku!");
        }

    }

    public void setType(String inputType) {
        this.type = inputType.trim();
    }

    public void setName(String inputName) {
        this.name = inputName.trim();
    }


    public void setDate(String inputDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            this.dateOfNew = format.parse(inputDate.trim());
        } catch (Exception e) {
            System.err.println("Неверный формат date!");
        }

    }


}
