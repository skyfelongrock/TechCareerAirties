package com.gokdemiruzunkaya.graduationproject.core;

import java.util.List;
import java.util.Scanner;

public class ATM extends Customer {
    static Scanner customerInput = new Scanner(System.in);
    //değişken sadece oluşturulduğu scope içinde tanımlıdır
    public static void loginAtm(List<Customer> customerList){
        System.out.print("Username giriniz: ");
        String username = customerInput.next();
        if (searchUsername(username, customerList) != null) {
            getPassword(searchUsername(username, customerList), customerList);
        } else {
            System.out.println("Geçersiz bir username girdiniz! Lütfen tekrar deneyin...");
            loginAtm(customerList);
        }
    }
    public static Customer searchUsername(String username, List<Customer> customerList){
        for (Customer customer : customerList) {
            if (username.equals(customer.getUsername())) {
                return customer;
            }
        }
        return null;
    }
    public static void getPassword(Customer currentCustomer, List<Customer> customerList) {
        if (currentCustomer.getInvalidAttemptCounter() < 3) {
            System.out.print(currentCustomer.getUsername() + "'in şifresini giriniz: ");
            String password = customerInput.next();
            if (currentCustomer.getPassword().equals(password)) {
                mainMenu(currentCustomer, customerList);
            } else {
                currentCustomer.setInvalidAttemptCounter(currentCustomer.getInvalidAttemptCounter() + 1);
                if (currentCustomer.getInvalidAttemptCounter() < 3) {
                    System.out.println("Kalan giriş hakkınız: " + (3 - currentCustomer.getInvalidAttemptCounter()));
                }
                getPassword(currentCustomer, customerList);
            }
        } else {
            System.out.println("Bu hesap bloke olmuştur. Lütfen geçerli bir hesapla giriş yapınız...");
            loginAtm(customerList);
        }
    }
    public static void mainMenu(Customer loggedInCustomer, List<Customer> customerList) {
        if (loggedInCustomer.getBalance() <= 0.0) {
            System.out.println("Bakiyeniz 0.0 olduğu için para yatırmaya yönlendiriliyorsunuz...");
            depositMoney(loggedInCustomer, customerList);
        } else {
            System.out.println("\n 1. Bakiye Görüntüle\n 2. Para Yatır\n 3. Para Çek\n 4. ParaTransferi\n 5. Çıkış Yap\n");
            System.out.print("Yapmak istediğiniz işlemin numarasını giriniz: ");
            String menuType = customerInput.next();
            switch (menuType) {
                case "1" -> {
                    System.out.println("Bakiyeniz: " + (String.valueOf(loggedInCustomer.getBalance())) + "\n Ana menü için herhangi bir tuşa basın\n 0. Çıkış Yap");
                    menuType = customerInput.next();
                    if (menuType.equals("0")) { exit(loggedInCustomer, customerList); }
                    else { mainMenu(loggedInCustomer, customerList); }
                }
                case "2" -> { depositMoney(loggedInCustomer, customerList); }
                case "3" -> { withdrawMoney(loggedInCustomer, customerList); }
                case "4" -> { transferMoney(loggedInCustomer, customerList); }
                case "5" -> { exit(loggedInCustomer, customerList); }
                default -> {
                    System.out.println("Geçersiz tuşlama yaptınız. Lütfen tekrar deneyiniz...");
                    mainMenu(loggedInCustomer, customerList);
                }
            }
        }
    }
    public static void depositMoney(Customer loggedInCustomer, List<Customer> customerList) {
        System.out.print("Lütfen yatırmak istediğiniz tutarı girin: ");
        double depositValue = Double.parseDouble(customerInput.next());
        loggedInCustomer.setBalance(loggedInCustomer.getBalance() + depositValue);
        System.out.println("Yeni bakiyeniz : " + loggedInCustomer.getBalance());
        mainMenu(loggedInCustomer, customerList);
    }
    public static void withdrawMoney (Customer loggedInCustomer, List<Customer> customerList) {
        System.out.print("Lütfen çekmek istediğiniz tutarı girin: ");
        double withdrawValue = Double.parseDouble(customerInput.next());
        if (withdrawValue <= loggedInCustomer.getBalance()) {
            loggedInCustomer.setBalance(loggedInCustomer.getBalance() - withdrawValue);
            System.out.println("Yeni bakiyeniz : " + loggedInCustomer.getBalance());
            mainMenu(loggedInCustomer, customerList);
        } else {
            System.out.println("Bakiyeniz yetersiz!");
            withdrawMoney(loggedInCustomer, customerList);
        }
    }
    public static void transferMoney (Customer loggedInCustomer, List<Customer> customerList) {
        System.out.print("\n 1. Banka içi\n 2. Başka bankaya\n 3. Ana menü\n 0. Çıkış yap\n\nPara transfer tipini seçiniz: ");
        String transferChoice = customerInput.next();
        switch (transferChoice) {
            case "1" -> { countinueToMoneyTransfer(loggedInCustomer, customerList, ETransferType.HAVALE); }
            case "2" -> { countinueToMoneyTransfer(loggedInCustomer, customerList, ETransferType.EFT); }
            case "3" -> { mainMenu(loggedInCustomer, customerList); }
            case "0" -> { exit(loggedInCustomer, customerList); }
            default -> {
                System.out.println("Lütfen geçerli bir transfer tipi seçiniz!");
                transferMoney(loggedInCustomer, customerList);
            }
        }
    }
    public static void countinueToMoneyTransfer (Customer loggedInCustomer, List<Customer> customerList, ETransferType transferType) {
        System.out.print("Lütfen para göndermek istediğiniz username'i giriniz: ");
        String receiverCustomerUsername = customerInput.next();
        Customer receiverCustomer = searchUsername(receiverCustomerUsername, customerList);
        if (receiverCustomer != null) {
            System.out.print("Lütfen seçili müşteriye göndermek istediğiniz tutarı giriniz: ");
            double moneyValue = Double.parseDouble(customerInput.next());
            // (Ternary Operator) variable = (condition) ? expressionTrue :  expressionFalse;
            double transferCost = (transferType == ETransferType.EFT) ? 5.0 : 0.0;
            if (isBalanceAvailableForCurrentTransfer(moneyValue + transferCost, loggedInCustomer.getBalance())) {
                loggedInCustomer.setBalance(loggedInCustomer.getBalance() - (moneyValue + transferCost));
                receiverCustomer.setBalance(receiverCustomer.getBalance() + moneyValue);
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getUsername().equals(receiverCustomer.getUsername())) {
                        customerList.set(i, receiverCustomer);
                        break;
                    }
                }
                System.out.println("Para transfer işleminiz başarıyla gerçekleşmiştir. Yeni bakiyeniz: " + loggedInCustomer.getBalance() + "\n Ana menüye yönlendiriliyolarsunuz...");
                mainMenu(loggedInCustomer, customerList);
            } else {
                System.out.print("Yapmak istediğiniz işlem için bakiyeniz yetersizdir.\n Para transfer menüsüne yönlendiriliyorsunuz...");
                transferMoney(loggedInCustomer, customerList);
            }
        } else {
            System.out.println("Girilen username için müşteri bulunamadı.\n Para transferine yönlendiriliyorsunuz...");
            transferMoney(loggedInCustomer, customerList);
        }
    }
    public static boolean isBalanceAvailableForCurrentTransfer (Double totalCost, Double loggedInCustomerBalance) {
        return totalCost <= loggedInCustomerBalance;
    }
    public static void exit(Customer loggedInCustomer, List<Customer> customerList) {
        System.out.println(loggedInCustomer.getUsername() + " çıkış yaptınız. Girişe yönlendiriliyosunuz...\n");
        loginAtm(customerList);
    }

    public static void main(String[] args) {
        List<Customer> customerList = createCustomerList();
        loginAtm(customerList);
    }
}
