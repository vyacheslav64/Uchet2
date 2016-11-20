package Uchet2;

import java.text.SimpleDateFormat;

public class Monitor extends Ustroystvo {
    Monitor() {
        super();
        size = 0;
        color = false;
        kind = "dontSet";
    }

    public int size;
    public boolean color;
    String kind;

    public void addMonitor(String[] com) {
        for (int i = 0; i < com.length; i++) {
            String comTypeAndValue[] = com[i].split(" ", 2);
            if (comTypeAndValue[0].trim().equals("sku")) {
                setScu(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("type")) {
                setType(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("name")) {
                setName(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("date")) {
                super.setDate(comTypeAndValue[1]);
                ;
            }
            if (comTypeAndValue[0].trim().equals("color")) {
                setColor(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("size")) {
                setSize(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].trim().equals("kind")) {
                setKind(comTypeAndValue[1]);
            }
        }
    }

    public String moniToStr() {
        String str = new String();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        str = String.valueOf(sku) + "--" + type + "--" + name + "--" + String.valueOf(format1.format(dateOfNew)) + "--" + String.valueOf(color) + "--" + String.valueOf(size) + "--" + kind;
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

    public void setSize(String inputSize) {
        try {
            this.size = Integer.parseInt(inputSize.trim());
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат size!");
        }

    }

    public void setKind(String inputKind) {
        if (inputKind.trim().equals("TUBE")) {
            this.kind = "TUBE";
        }
        if (inputKind.trim().equals("LCD")) {
            this.kind = "LCD";
        }
        if (inputKind.trim().equals("PROJECTOR")) {
            this.kind = "PROJECTOR";
        }
    }


}
