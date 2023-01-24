import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForms extends JFrame  {

    private JPanel panel1;
    private JButton mojeKontoButton;
    private JButton kategoriaProduktuButton;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JList list1;
    private JList list2;
    private JPanel icon;
    private JButton rejestracjaButton;
    private JButton zdjecieButton;
    private JPanel zdj;


    public static void main(String[] args) {
        MainForms form = new MainForms();
        form.setVisible(true);
}

    public MainForms() {

        super("Wypo\u017Cczalnia Sprz\u0119tu elektronicznego");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(1000, 900);

        mojeKontoButton.addActionListener(new ActionListener() {
            private void actionPerformed2(ActionEvent k) {


                Component logowanie = new logowanie();
                JOptionPane.showInputDialog(logowanie);

                logowanie = null;
                JOptionPane.showMessageDialog(null, "Logowanie");


            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("Logowanie");
                mojeKontoButton.addActionListener(this::actionPerformed2);
                class logowanie extends MainForms {
                    private String login;

                    public String getLogin() {
                        return login;
                    }

                    public void setLogin(String login) {
                        this.login = login;
                    }

                    public String getPassword() {
                        return password;
                    }

                    public void setPassword(String password) {
                        this.password = password;
                    }

                    private String password;
                }
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component ProduktyFinal = new ProduktyFinal();
                JOptionPane.showInputDialog(ProduktyFinal);

                ProduktyFinal = null;
                JOptionPane.showMessageDialog(null, "Produkty");

                class Equipment extends MainForms {
                    private String name;
                    private String id;
                    private boolean available;

                    public Equipment(String name, String id) {
                        this.name = name;
                        this.id = id;
                        this.available = true;
                    }

                    public String getName() {
                        return name;
                    }

                    public String getId() {
                        return id;
                    }

                    public boolean isAvailable() {
                        return available;
                    }

                    public void setAvailability(boolean available) {
                        this.available = available;
                    }
                }
            }

        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component odzialfinal = new odzialfinal();
                JOptionPane.showInputDialog(odzialfinal);

                odzialfinal = null;
                JOptionPane.showMessageDialog(null, "Odziały");
                class odzil extends MainForms {
                    private String City;
                    private String phone_number;
                    private String adress_email;

                    public String getCity() {
                        return City;
                    }

                    public void setCity(String city) {
                        City = city;
                    }

                    public String getPhone_number() {
                        return phone_number;
                    }

                    public void setPhone_number(String phone_number) {
                        this.phone_number = phone_number;
                    }

                    public String getAdress_email() {
                        return adress_email;
                    }

                    public void setAdress_email(String adress_email) {
                        this.adress_email = adress_email;
                    }
                }
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component kliencifinal = new kliencifinal();
                JOptionPane.showInputDialog(kliencifinal);

                kliencifinal = null;
                JOptionPane.showMessageDialog(null, "Klienci");
                class customers extends MainForms{
                    private String name;
                    private String lastname;

                    public String getPhone_number() {
                        return phone_number;
                    }

                    public void setPhone_number(String phone_number) {
                        this.phone_number = phone_number;
                    }

                    public String getAdress() {
                        return adress;
                    }

                    public void setAdress(String adress) {
                        this.adress = adress;
                    }

                    public String getLastname() {
                        return lastname;
                    }

                    public void setLastname(String lastname) {
                        this.lastname = lastname;
                    }

                    @Override
                    public String getName() {
                        return name;
                    }

                    @Override
                    public void setName(String name) {
                        this.name = name;
                    }

                    private String adress;
                    private String phone_number;
                }
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cennikfinal = new cennikfinal();
                JOptionPane.showInputDialog(cennikfinal);

               cennikfinal = null;
                JOptionPane.showMessageDialog(null, "Cennik");
                class price extends MainForms {
                    private String name1;

                    public void setName1(String name1) {
                        this.name1 = name1;
                    }

                    public String getName1() {
                        return name1;
                    }

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }

                    private String price;

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public price(String name1) {
                        this.name1 = name1;
                    }
                }
            }
        });


        rejestracjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component test = new test();
                JOptionPane.showInputDialog(test);

                test = null;
                JOptionPane.showMessageDialog(null, "Rejestracja");
            }
            class rejstracja extends MainForms{
                private String name;
                private String lastaname;
                private String e_mail;

                public String getNumer_telefonu() {
                    return numer_telefonu;
                }

                public void setNumer_telefonu(String numer_telefonu) {
                    this.numer_telefonu = numer_telefonu;
                }

                public String getAdres() {
                    return adres;
                }

                public void setAdres(String adres) {
                    this.adres = adres;
                }

                public String getData_uodzenia() {
                    return data_uodzenia;
                }

                public void setData_uodzenia(String data_uodzenia) {
                    this.data_uodzenia = data_uodzenia;
                }

                public String getE_mail() {
                    return e_mail;
                }

                public void setE_mail(String e_mail) {
                    this.e_mail = e_mail;
                }

                public String getLastaname() {
                    return lastaname;
                }

                public void setLastaname(String lastaname) {
                    this.lastaname = lastaname;
                }

                @Override
                public String getName() {
                    return name;
                }

                @Override
                public void setName(String name) {
                    this.name = name;
                }

                private String data_uodzenia;
                private String adres;
                private String numer_telefonu;

            }
        });


        kategoriaProduktuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Component kategoriaproduktu = new kategoriaproduktu();
                JOptionPane.showInputDialog(kategoriaproduktu);

                kategoriaproduktu = null;
                JOptionPane.showMessageDialog(null, "Kategoria Produktu");
            }
        });
    }}



