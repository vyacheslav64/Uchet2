package Uchet2;

import java.text.SimpleDateFormat;

public class Scaner extends Ustroystvo {
    Scaner() {
        super();
        color = false;
        networkWiFi = false;
        networkEthernet = false;
    }

    public boolean color;
    public boolean networkWiFi;
    public boolean networkEthernet;

    public void addScaner(String[] com) {
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
            if (comTypeAndValue[0].equals("color")) {
                setColor(comTypeAndValue[1]);
            }
            if (comTypeAndValue[0].equals("network")) {
                setNetwork(comTypeAndValue[1]);

            }
        }
    }

    public String ScanerToStr() {
        String str = new String();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        str = String.valueOf(sku) + "--" + type + "--" + name + "--" + String.valueOf(format1.format(dateOfNew)) +
                "--" + String.valueOf(color) + "--" + String.valueOf(networkWiFi) + "--" + String.valueOf(networkEthernet);
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

    private void setNetwork(String inputNetwork) {
        inputNetwork = inputNetwork.replace(" ", "");
        inputNetwork = inputNetwork.toLowerCase();
        if (inputNetwork.equals("-")) {
            this.networkWiFi = false;
            this.networkEthernet = false;
        }
        if (inputNetwork.equals("ethernet")) {
            this.networkWiFi = false;
            this.networkEthernet = true;
        }
        if (inputNetwork.equals("wifi")) {
            this.networkWiFi = true;
            this.networkEthernet = false;
        }
        if (inputNetwork.equals("ethernet,wifi") || inputNetwork.equals("wifi,ethernet")) {
            this.networkWiFi = true;
            this.networkEthernet = true;
        }
    }
}


