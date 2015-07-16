
import java.rmi.*;
import java.util.*;

public class CalculatorClientComponent {

    private static Double memory = 0D;
    private static Double result = 0D;
    private static final String host = "localhost";
    private static Double x, y;

    public static void main(String[] args) {
        try {
            ICalculator iCalculator = (ICalculator) Naming.lookup("rmi://" + host + "/Calculator");

            Scanner sc = new Scanner(System.in);
            String opt;
            String d1 = null;
            String d2 = "";
            int val, test;

            showHELP();

            System.out.println("M=" + memory);
            System.out.println("R=" + result + "\n");

            opt = sc.nextLine();

            while (!opt.equalsIgnoreCase("exit")) {
                boolean ok = true;
                if (opt.contains("*")) {
                    if (result.isNaN()) {
                        System.out.println("Current result is Nan");
                    } else {
                        opt = opt.replace("*", result.toString());
                    }
                }
                if (opt.equals("m+")) {
                    if (result.isNaN()) {
                        System.out.println("Current result is NaN");
                    } else {
                        try {
                            memory = iCalculator.add(memory, result);
                        } catch (RemoteException rex) {
                            System.out.println(rex);
                        }
                    }
                } else if (opt.equals("m-")) {
                    if (result.isNaN()) {
                        System.out.println("Current result is NaN");
                    } else {
                        try {
                            memory = iCalculator.sub(memory, result);
                        } catch (RemoteException rex) {
                            System.out.println(rex);
                        }
                    }
                } else if (opt.equals("ms")) {
                    if (result.isNaN()) {
                        System.out.println("Current result is NaN");
                    } else {
                        memory = result;
                    }
                } else if (opt.equals("mr")) {
                    result = memory;
                } else if (opt.equals("mc")) {
                    memory = 0D;
                } else if (opt.startsWith("add ")) {
                    opt = opt.substring(4);
                    try {
                        d1 = opt.substring(0, opt.indexOf(' '));
                        x = Double.parseDouble(d1);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d1 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("add x y");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            d2 = opt.substring(opt.indexOf(' ') + 1);
                            y = Double.parseDouble(d2);
                        } catch (NumberFormatException nfe) {
                            System.out.println(d2 + " is NaN");
                            ok = false;
                        } catch (Exception ex) {
                            System.out.println("add x y");
                            ok = false;
                        }
                    }
                    if (ok) {
                        try {
                            result = iCalculator.add(x, y);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("sub ")) {
                    opt = opt.substring(4);
                    try {
                        d1 = opt.substring(0, opt.indexOf(' '));
                        x = Double.parseDouble(d1);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d1 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("sub x y");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            d2 = opt.substring(opt.indexOf(' ') + 1);
                            y = Double.parseDouble(d2);
                        } catch (NumberFormatException nfe) {
                            System.out.println(d2 + " is NaN");
                            ok = false;
                        } catch (Exception ex) {
                            System.out.println("sub x y");
                            ok = false;
                        }
                    }
                    if (ok) {
                        try {
                            result = iCalculator.sub(x, y);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("mult ")) {
                    opt = opt.substring(5);
                    try {
                        d1 = opt.substring(0, opt.indexOf(' '));
                        x = Double.parseDouble(d1);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d1 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("mult x y");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            d2 = opt.substring(opt.indexOf(' ') + 1);
                            y = Double.parseDouble(d2);
                        } catch (NumberFormatException nfe) {
                            System.out.println(d2 + " is NaN");
                            ok = false;
                        } catch (Exception ex) {
                            System.out.println("mult x y");
                            ok = false;
                        }
                    }
                    if (ok) {
                        try {
                            result = iCalculator.mult(x, y);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("div ")) {
                    opt = opt.substring(4);
                    try {
                        d1 = opt.substring(0, opt.indexOf(' '));
                        x = Double.parseDouble(d1);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d1 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("div x y");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            d2 = opt.substring(opt.indexOf(' ') + 1);
                            y = Double.parseDouble(d2);
                        } catch (NumberFormatException nfe) {
                            System.out.println(d2 + " is NaN");
                            ok = false;
                        } catch (Exception ex) {
                            System.out.println("div x y");
                            ok = false;
                        }
                    }
                    if (ok) {
                        try {
                            result = iCalculator.div(x, y);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("inv ")) {
                    opt = opt.substring(4);
                    try {
                        x = Double.parseDouble(opt);
                    } catch (NumberFormatException nfe) {
                        System.out.println(opt + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("inv x");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            result = iCalculator.inv(x);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("pow ")) {
                    opt = opt.substring(4);
                    try {
                        d1 = opt.substring(0, opt.indexOf(' '));
                        x = Double.parseDouble(d1);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d1 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("pow x y");
                        ok = false;
                    }
                    if(ok) {
                    try {
                        d2 = opt.substring(opt.indexOf(' ') + 1);
                        y = Double.parseDouble(d2);
                    } catch (NumberFormatException nfe) {
                        System.out.println(d2 + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("pow x y");
                        ok = false;
                    }}
                    if (ok) {
                        try {
                            result = iCalculator.pow(x, y);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("fact ")) {
                    opt = opt.substring(5);
                    try {
                        x = Double.parseDouble(opt);
                    } catch (NumberFormatException nfe) {
                        System.out.println(opt + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("fact x");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            result = iCalculator.fact(x);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.startsWith("sqrt ")) {
                    opt = opt.substring(5);
                    try {
                        x = Double.parseDouble(opt);
                    } catch (NumberFormatException nfe) {
                        System.out.println(opt + " is NaN");
                        ok = false;
                    } catch (Exception ex) {
                        System.out.println("sqrt x");
                        ok = false;
                    }
                    if (ok) {
                        try {
                            result = iCalculator.sqrt(x);
                        } catch (RemoteException rex) {
                            System.out.println("Unable to communicate with server!");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (opt.equalsIgnoreCase("help")) {
                    showHELP();
                } else {
                    System.out.println("Inexistent option!" + "\n");
                }
                System.out.println("M=" + memory);
                System.out.println("R=" + result + "\n");
                opt = sc.nextLine();
            }
        } catch (ConnectException conEx) {
            System.out.println("Unable to connect to server!");
            System.exit(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    private static void showHELP() {
        System.out.println("\nadd x y   \tx+y");
        System.out.println("sub x y   \tx-y");
        System.out.println("mult x y  \tx*y");
        System.out.println("div x y   \tx/y");
        System.out.println("inv x     \t1/x");
        System.out.println("pow x y   \tx^y");
        System.out.println("fact x    \tx!");
        System.out.println("sqrt x    \t√x\n");
        System.out.println("m+        \tAdauga la memorie");
        System.out.println("m-        \tScade din memorie");
        System.out.println("ms        \tSeteaza memoria");
        System.out.println("mr        \tCiteste memoria");
        System.out.println("mc        \tGoleste memoria\n");
        System.out.println("func * (y)\tFunctie in care * este rezultatul curent\n");
        System.out.println("func (x) *\tFunctie in care * este rezultatul curent\n");
    }
}
