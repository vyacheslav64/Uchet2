package Uchet2;

import java.io.File;
import java.util.*;


public class Uchet2Main {
    public static void readFile(String[] ArrayLikeSkuAndType) {
        Scanner forReadFile;
        try {
            forReadFile = new Scanner(new File("res//datab.txt"));
            while (forReadFile.hasNext()) {
                String a = forReadFile.nextLine();
                String[] arr = a.split("--", 2);
                int skuA = Integer.parseInt(arr[0].trim());
                ArrayLikeSkuAndType[skuA] = a;
            }
        } catch (Exception e) {
            System.out.println("Can't find datab");
        }
    }

    public static void exitFromThis(String[] ArrayLikeSkuAndType) {
        try {
            Formatter x = new Formatter("res//datab.txt");
            for (int i = 0; i < ArrayLikeSkuAndType.length; i++) {
                if (!ArrayLikeSkuAndType[i].equals("empty")) {
                    x.format(ArrayLikeSkuAndType[i] + "\n");
                }
            }
            x.close();
        } catch (Exception e) {
            System.out.println("Exception when write datab.txt");
        }

    }

    public static void main(String[] args) {


        //System.out.println("Hello World");

        String[] SkuAndType = new String[1000];
        for (int i = 0; i < 1000; i++) {
            SkuAndType[i] = "empty";
        }
        readFile(SkuAndType);
        while (true) {

            Scanner sc = new Scanner(System.in);
            String command;
            command = sc.nextLine();
            if (command.equals("exit")) {
                exitFromThis(SkuAndType);
                sc.close();
                break;
            }
            String[] commandArray = command.split("--");
            if (commandArray[0].trim().equals("add")) {
                String[] for2words = commandArray[2].trim().split(" ", 2);


                switch (for2words[1].trim()) {
                    case "PRINTER":
                        Printer p = new Printer();
                        p.addPrinter(commandArray);
                        if (!SkuAndType[p.sku].equals("empty")) {
                            System.out.println("SKU isn't empty, overwrite");
                        }
                        SkuAndType[p.sku] = p.PrinterToStr();
                        System.out.println(p.PrinterToStr());
                        break;
                    case "SCANER":
                        Scaner s = new Scaner();
                        s.addScaner(commandArray);
                        if (!SkuAndType[s.sku].equals("empty")) {
                            System.out.println("SKU isn't empty, overwrite");
                        }
                        SkuAndType[s.sku] = s.ScanerToStr();
                        System.out.println(s.ScanerToStr());
                        break;
                    case "MONITOR":
                        Monitor m = new Monitor();
                        m.addMonitor(commandArray);
                        if (!SkuAndType[m.sku].equals("empty")) {
                            System.out.println("SKU isn't empty, overwrite");
                        }
                        SkuAndType[m.sku] = m.moniToStr();
                        break;
                    default:
                        System.out.println("I don't know this type");
                        break;
                }
            }
            if (command.equals("delete")) {
                System.out.println("Удалить все? введите yes");
                String commandDel = sc.nextLine();
                if (commandDel.equals("yes")) {
                    for (int i = 0; i < 1000; i++) {
                        SkuAndType[i] = "empty";
                    }
                }
            }

            if (commandArray[0].equals("delete") && !commandArray[1].equals(null)) {
                String[] skuForDel = commandArray[1].split(" ");
                SkuAndType[Integer.parseInt(skuForDel[1].trim())] = "empty";
            }

            if (command.equals("list")) {
                for (int i = 0; i < 1000; i++) {
                    if (!SkuAndType[i].equals("empty")) {
                        String[] ListSandT = SkuAndType[i].split("--");
                        if (ListSandT[1].equals("MONITOR")) {
                            System.out.println("It's a " + ListSandT[1] + " SKU:" + ListSandT[0] + " name:" + ListSandT[2] +
                                    " date:" + ListSandT[3] + " color:" + ListSandT[4] + " size:" + ListSandT[5] + " kind:" + ListSandT[6]);
                        }
                        if (ListSandT[1].equals("SCANER")) {
                            System.out.println("It's a " + ListSandT[1] + " SKU:" + ListSandT[0] + " name:" + ListSandT[2] +
                                    " date:" + ListSandT[3] + " color:" + ListSandT[4] + " WiFi:" + ListSandT[5] + " Ethernet:" + ListSandT[6]);
                        }
                        if (ListSandT[1].equals("PRINTER")) {
                            System.out.println("It's a " + ListSandT[1] + " SKU:" + ListSandT[0] + " name:" + ListSandT[2] +
                                    " date:" + ListSandT[3] + " color:" + ListSandT[4] + " NetWork:" + ListSandT[5]);
                        }
                    }
                }

            }

        }
    }

}
