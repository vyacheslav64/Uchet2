package Uchet2;

import java.text.SimpleDateFormat;

public class Printer extends Ustroystvo {
    Printer() {
        super();
        color = false;
        network = false;
    }

    public boolean color;
    public boolean network;

    public void addPrinter(String[] com) {
        for (int i = 0; i < com.length; i++) {
            String comTypeAndValue[] = com[i].split(" ", 2);
            if (comTypeAndValue[0].equals("sku")) {
                setScu(comTypeAndValue[1].trim());
            }
            if (comTypeAndValue[0].equals("type")) {
                setType(comTypeAndValue[1].trim());
            }
            if (comTypeAndValue[0].equals("name")) {
                setName(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].equals("date")) {
                setDate(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("color")) {
                setColor(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("network")) {
                setNetwork(comTypeAndValue[1]);
            }
        }
    }


    public String PrinterToStr() {
        String str = new String();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        str = String.valueOf(sku) + "--" + type + "--" + name + "--" + String.valueOf(format1.format(dateOfNew)) + "--" + String.valueOf(color) + "--" + String.valueOf(network);
        return str;
    }

    public void setColor(String inputColor) {
        if (inputColor.trim().equals("true")) {
            this.color = true;
        }
        if (inputColor.trim().equals("false")) {
            this.color = false;
        }
    }

    public void setNetwork(String inputNetwork) {
        if (inputNetwork.trim().equals("true")) {
            this.network = true;
        }
        if (inputNetwork.trim().equals("false")) {
            this.network = false;
        }
    }

}
