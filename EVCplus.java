import java.util.Scanner;

public class EVCplus {
    private static double balance = 1000;
    private static double ac_balance = 100;
    private static final int pass = 1111;
    private static final int ac_pass = 123456;
    private static final String EVC_CODE = "*770#";
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---- GELI EVCPLUS ----- ");
        String EVC = input.next();
        
        if (EVC_CODE.equals(EVC)) {
            showMainMenu();
        } else {
            System.out.println("Invalid EVC code");
        }
    }

    private static void showMainMenu() {
        System.out.println("- EVCPLUS. -");
        System.out.println("faldan geli pin-kaaga(Enter pin)");
        int user_pass = input.nextInt();
        
        if (pass == user_pass) {
            displayMenuOptions();
        } else {
            System.out.println("Invalid PIN");
        }
    }

    private static void displayMenuOptions() {
        System.out.println("EVCPLUS");
        String[] menuItems = {
            "1. Itus Haraaga", "2. kaarka hadalka", "3. Bixi Biil",
            "4. U wareeji EVCPLUS", "5. Warbixin Kooban", "6. Salaam Bank",
            "7. Maareynta", "8. TAAJ", "9. Bill Payment"
        };
        
        for (String item : menuItems) {
            System.out.println(item);
        }
        
        int choice = input.nextInt();
        handleMenuChoice(choice);
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1: checkBalance(); break;
            case 2: handleAirtime(); break;
            case 3: handleBillPayment(); break;
            case 4: handleTransfer(); break;
            case 5: showMiniStatement(); break;
            case 6: handleBankServices(); break;
            case 7: handleManagement(); break;
            case 8: handleTaaj(); break;
            case 9: handleBillPaymentService(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void checkBalance() {
        System.out.println("[---EVCPLUS---] Haraagaagu waa $" + balance);
    }

    private static void handleAirtime() {
        System.out.println("Kaarka hadalka");
        String[] airtimeOptions = {
            "1. Ku shubo Airtime", "2. Ugu shubo Airtime", 
            "3. MIFI Packages", "4. Ku shubo Internet", 
            "5. Ugu shub qof kale (MMT)"
        };
        
        for (String option : airtimeOptions) {
            System.out.println(option);
        }
        
        int airtimeChoice = input.nextInt();
        processAirtimeChoice(airtimeChoice);
    }

    private static void processAirtimeChoice(int choice) {
        switch (choice) {
            case 1: topUpSelf(); break;
            case 2: topUpOthers(); break;
            case 3: handleMifiPackages(); break;
            case 4: handleInternetPackages(); break;
            case 5: transferToOthers(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void topUpSelf() {
        System.out.println("Fadlan Gali lacagta");
        double amount = input.nextDouble();
        System.out.println("Fadlan Geli numberka");
        int number = input.nextInt();
        
        confirmTransaction(amount, number, "ku shubtid");
    }

    private static void topUpOthers() {
        System.out.println("Fadlan Geli mobile-ka");
        int number = input.nextInt();
        System.out.println("Fadlan Geli lacagta");
        double amount = input.nextDouble();
        
        confirmTransaction(amount, number, "ugu shubtid");
    }

    private static void confirmTransaction(double amount, int number, String action) {
        System.out.printf("Ma hubtaa inaad $%.2f %s %d?\n", amount, action, number);
        System.out.println("1. haa");
        System.out.println("2. maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("waad guuleysady inaa lacagta u shubto %d \n haraagaga hada waa $%.2f\n", 
                    number, balance);
            } else {
                System.out.println("haraagagu kuma filano");
            }
        } else {
            System.out.println("OK");
        }
    }

    private static void handleMifiPackages() {
        System.out.println("EVCPlus");
        System.out.println("1. Ku shubo Data-da MIFI");
        int choice = input.nextInt();
        
        if (choice == 1) {
            showMifiPackageOptions();
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void showMifiPackageOptions() {
        System.out.println("-Internet Bundle Recharge-");
        String[] packageTypes = {
            "1. Isbuucle(Weekly)", "2. maalinle(Daily)", "3. Bille(MiFi)"
        };
        
        for (String type : packageTypes) {
            System.out.println(type);
        }
        
        int packageChoice = input.nextInt();
        processMifiPackageChoice(packageChoice);
    }

    private static void processMifiPackageChoice(int choice) {
        switch (choice) {
            case 1: handleWeeklyPackages(); break;
            case 2: handleDailyPackages(); break;
            case 3: handleMonthlyPackages(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void handleWeeklyPackages() {
        System.out.println("fadlan dooro bundle ka");
        System.out.println("1. $5= 10 GB");
        System.out.println("2. $10=25 GB");
        int weeklyChoice = input.nextInt();
        
        if (weeklyChoice == 1 || weeklyChoice == 2) {
            double amount = (weeklyChoice == 1) ? 5 : 10;
            processMifiTransaction(amount, "isbuucle ah");
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void handleDailyPackages() {
        System.out.println("fadlan dooro bundle ka");
        System.out.println("1. $1= 2 GB");
        System.out.println("2. $2=5 GB");
        int dailyChoice = input.nextInt();
        
        if (dailyChoice == 1 || dailyChoice == 2) {
            double amount = (dailyChoice == 1) ? 1 : 2;
            processMifiTransaction(amount, "maalinle ah");
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void handleMonthlyPackages() {
        System.out.println("fadlan dooro bundle ka");
        String[] monthlyOptions = {
            "1. $20= 40 GB", "2. $40=85 GB",
            "3. $60= 150 GB", "4. $30= monthly unlimit"
        };
        
        for (String option : monthlyOptions) {
            System.out.println(option);
        }
        
        int monthlyChoice = input.nextInt();
        double amount = 0;
        String description = "";
        
        switch (monthlyChoice) {
            case 1: amount = 20; description = "bille ah"; break;
            case 2: amount = 40; description = "bille ah"; break;
            case 3: amount = 60; description = "bille ah"; break;
            case 4: amount = 30; description = "monthnly unlimit"; break;
            default: System.out.println("Invalid choice"); return;
        }
        
        processMifiTransaction(amount, description);
    }

    private static void processMifiTransaction(double amount, String description) {
        System.out.println("fadlan Gali MIFI user");
        int user = input.nextInt();
        
        System.out.printf("Ma hubtaa inaad $%.2f ugu shubtid %d?\n", amount, user);
        System.out.println("1. haa");
        System.out.println("2. maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("waad ku guuleysaday inaad ku shubtid $%.2f %s\n haraagaga hada waa $%.2f\n", 
                    amount, description, balance);
            } else {
                System.out.println("haraagagu kuma filano");
            }
        } else {
            System.out.println("OK");
        }
    }

    private static void handleInternetPackages() {
        System.out.println("Fadlan dooro number-ka ku shubeyso");
        String[] internetOptions = {
            "1. Isbuucle(Weekly)", "2.TIMES BASED PACKAGES",
            "3. DATA", "4. Maalinle (Daily)", "5. Bille(MiFi)"
        };
        
        for (String option : internetOptions) {
            System.out.println(option);
        }
        
        int internetChoice = input.nextInt();
        processInternetChoice(internetChoice);
    }

    private static void processInternetChoice(int choice) {
        System.out.println("fadlan geli lacagta");
        double amount = input.nextDouble();
        System.out.println("fadlan gali mobile-ka");
        int number = input.nextInt();
        
        String description = "";
        switch (choice) {
            case 1: description = "data internet-ah"; break;
            case 2: description = "data internet-ah"; break;
            case 3: description = "data internet-ah"; break;
            case 4: description = "data internet-ah"; break;
            case 5: description = "data internet-ah oo bile ah"; break;
            default: System.out.println("Invalid choice"); return;
        }
        
        confirmInternetTransaction(amount, number, description);
    }

    private static void confirmInternetTransaction(double amount, int number, String description) {
        System.out.printf("Ma hubtaa inaad $%.2f ugu shubtid %d?\n", amount, number);
        System.out.println("1. haa");
        System.out.println("2. maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("waad ku guuleysaday inaad ku shubtid $%.2f %s\n haraagaga hada waa $%.2f\n", 
                    amount, description, balance);
            } else {
                System.out.println("haragaagu kuma filno");
            }
        } else {
            System.out.println("ok");
        }
    }

    private static void transferToOthers() {
        System.out.println("fadlan soo geli mobile-ka");
        int number = input.nextInt();
        System.out.println("fadlan soo geli lacagta");
        double amount = input.nextDouble();
        
        confirmTransaction(amount, number, "ugu shubtid");
    }

    private static void handleBillPayment() {
        System.out.println("Bixi Biil");
        System.out.println("1. Post Paid");
        System.out.println("2. ku Iibso");
        int billChoice = input.nextInt();
        
        if (billChoice == 1) {
            handlePostPaid();
        } else if (billChoice == 2) {
            handleBuy();
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void handlePostPaid() {
        System.out.println("Post Paid");
        String[] postPaidOptions = {
            "1. Ogow biil", "2. Bixi biil", "3. Ka Bixi Biil"
        };
        
        for (String option : postPaidOptions) {
            System.out.println(option);
        }
        
        int postPaidChoice = input.nextInt();
        processPostPaidChoice(postPaidChoice);
    }

    private static void processPostPaidChoice(int choice) {
        switch (choice) {
            case 1: 
                System.out.println("haraagagu waa $" + balance);
                break;
            case 2: 
                payBill();
                break;
            case 3: 
                payBillForOthers();
                break;
            default: 
                System.out.println("Invalid choice");
        }
    }

    private static void payBill() {
        System.out.println("Fadlan geli lacagta biil-ka");
        double amount = input.nextDouble();
        confirmBillPayment(amount, "bixisid biil");
    }

    private static void payBillForOthers() {
        System.out.println("fadlan soo geli mobile-ka");
        int number = input.nextInt();
        System.out.println("fadlan geli lacgta");
        double amount = input.nextDouble();
        
        System.out.printf("Ma hubtaa inaad bixisid bill lacagtiisu tahay: $%.2f oo laga rabo tell NO %d\n", 
            amount, number);
        confirmBillPayment(amount, "bixiso lacagta");
    }

    private static void confirmBillPayment(double amount, String action) {
        System.out.println("1.haa");
        System.out.println("2. maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("waad ku guuleysay inaa %s \n haragaagu hada waa $%.2f\n", 
                    action, balance);
            } else {
                System.out.println("haragaagu kuma filno");
            }
        } else {
            System.out.println("ok");
        }
    }

    private static void handleBuy() {
        System.out.println("Fadlan geli agoonsiga ganacsiga");
        double businessId = input.nextDouble();
        
        if (businessId == 1) {
            System.out.println("Fadlan Gali Number ka");
            int number = input.nextInt();
            System.out.println("Fadlan Gali lacagta");
            double amount = input.nextDouble();
            
            System.out.printf("Ma hubtaa inaad %.2f udirto %d\n1.haa\n2.maya\n", amount, number);
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.printf("waad ku guuleystay howshaan\nHaraagaagu waa %.2f\n", balance);
                }
            } else {
                System.out.println("Mahadsanid!");
            }
        } else {
            System.out.println("aqoonsigaaga waa qalad");
        }
    }

    private static void handleTransfer() {
        System.out.println("fadlan geli mobile-ka");
        int number = input.nextInt();
        System.out.println("fadaln geli lacagta");
        double amount = input.nextDouble();
        
        confirmTransaction(amount, number, "ugu shubtid");
    }

    private static void showMiniStatement() {
        System.out.println("Warbixin Kooban");
        String[] statementOptions = {
            "1. Last Action", "2. Wareejintii u dambeysay",
            "3. Iibsashadii u dambeysay", "4. Last 3 Action",
            "5. Email Me My ACtivity"
        };
        
        for (String option : statementOptions) {
            System.out.println(option);
        }
        
        int statementChoice = input.nextInt();
        processStatementChoice(statementChoice);
    }

    private static void processStatementChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("$100 Ayaad u wareejisay +252615698262, Taariikh: 25/01/25 25:08:00");
                break;
            case 2:
                handleTransferStatement();
                break;
            case 3:
                // No action for this case in original code
                break;
            case 4:
                showLastThreeTransactions();
                break;
            case 5:
                System.out.println("your request is being processed and the activity will be emailed to xaamudx92@gmail.com");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void handleTransferStatement() {
        System.out.println("Statementiga");
        System.out.println("1. U dirtay");
        System.out.println("2. kaheshay");
        int transferType = input.nextInt();
        
        if (transferType == 1) {
            System.out.println("fadlan geli mobile-ka");
            int number = input.nextInt();
            System.out.printf("$2 Ayaad ka dirtay +252%d, Taariikh: 18/01/25 25:06:33\n", number);
        } else if (transferType == 2) {
            System.out.println("fadlan geli mobile-ka");
            int number = input.nextInt();
            System.out.printf("$1 Ayaad ka heshay +252%d, Taariikh: 18/01/25 25:06:33\n", number);
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void showLastThreeTransactions() {
        System.out.println("$50 Ayaad u wareejisay +252685698262, Taariikh: 25/07/225 09:23:02");
        System.out.println("$200 Ayaad u wareejisay +25261277636, Taariikh: 17/09/25 18:00:50");
        System.out.println("$30 Ayaad u wareejisay +252618103339, Taariikh: 12/11/24 22:28:33");
    }

    private static void handleBankServices() {
        System.out.println("Salaam Bank");
        String[] bankServices = {
            "1. Itus haraaga", "2. Lacag dhigasho", "3. Lacag qaadasho",
            "4. Ka wareeji EVCPlus", "5. Ka wareeji Account-kaga",
            "6. hubi wareeji account", "7. Maareynta Bankiga"
        };
        
        for (String service : bankServices) {
            System.out.println(service);
        }
        
        int bankChoice = input.nextInt();
        processBankChoice(bankChoice);
    }

    private static void processBankChoice(int choice) {
        switch (choice) {
            case 1: checkBankBalance(); break;
            case 2: depositToBank(); break;
            case 3: withdrawFromBank(); break;
            case 4: transferFromEVCToBank(); break;
            case 5: transferFromBankToAccount(); break;
            case 6: verifyAccountTransfer(); break;
            case 7: manageBankAccount(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void checkBankBalance() {
        System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
        int pin = input.nextInt();
        
        if (pin == ac_pass) {
            System.out.println("haragaaga bangiga waa:" + ac_balance + "USD");
        } else {
            System.out.println("numberkaaga sirta ee bangiga waa qalad");
        }
    }

    private static void depositToBank() {
        System.out.println("fadlan geli lacagta");
        double amount = input.nextDouble();
        System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
        int pin = input.nextInt();
        
        if (pin == ac_pass) {
            System.out.printf("Ma hubtaa inaad $%.2f dhigatid account_kaaga bangiga?\n1.haa\n2.mya\n", amount);
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                ac_balance += amount;
                System.out.printf("USD %.2f ayaa dhigatay koontadaada bangiga\n haragaagu hada waa: $%.2f\n", 
                    amount, ac_balance);
            }
        } else {
            System.out.println("numberkaaga sirta ee bangiga waa qalad");
        }
    }

    private static void withdrawFromBank() {
        System.out.println("fadlan geli lacagta");
        double amount = input.nextDouble();
        System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
        int pin = input.nextInt();
        
        if (pin == ac_pass) {
            System.out.printf("Ma hubtaa inaad $%.2f qaadatid account_kaaga bangiga?\n1.haa\n2.mya\n", amount);
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                if (ac_balance >= amount) {
                    ac_balance -= amount;
                    System.out.printf("USD %.2f ayaa kala baxday koontadaada bangiga\n haragaagu hda waa: $%.2f\n", 
                        amount, ac_balance);
                } else {
                    System.out.println("haragaagu kuma filno");
                }
            }
        } else {
            System.out.println("numberkaaga sirta ee bangiga waa qalad");
        }
    }

    private static void transferFromEVCToBank() {
        System.out.println("fadlan soo dooro xisaabta bangiga");
        System.out.println("SALAAM SOMALI BANK");
        int bankChoice = input.nextInt();
        
        if (bankChoice == 1) {
            System.out.println("fadlan soo geli account-ka");
            int account = input.nextInt();
            System.out.println("fadlan geli macluumad");
            int info = input.nextInt();
            System.out.println("fadlan soo geli lacagta");
            double amount = input.nextDouble();
            System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
            int pin = input.nextInt();
            
            if (pin == ac_pass) {
                System.out.printf("Ma hubtaa inaa u dhigatay  accounta NO:%d?\n1.Haa\n2. Maya\n", account);
                int confirmation = input.nextInt();
                
                if (confirmation == 1) {
                    if (balance >= amount) {
                        balance -= amount;
                        ac_balance += amount;
                        System.out.printf("waad ku guuleysay inaa dhigato  ACCOUNT NO:%d\n", account);
                    } else {
                        System.out.println("haragagu kuma filno");
                    }
                }
            }
        }
    }

    private static void transferFromBankToAccount() {
        System.out.println("fadlan soo geli account ama mobile");
        int account = input.nextInt();
        System.out.println("fadlan soo geli lacagta");
        double amount = input.nextDouble();
        System.out.println("fadlan soo geli macluumad");
        input.nextLine(); // Consume newline
        String info = input.nextLine();
        System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
        int pin = input.nextInt();
        
        if (pin == ac_pass) {
            System.out.printf("Ma hubtaa inaad USB%.2fu wareejiso Bank Account NO:%d?\n1.Haa\n2. Maya\n", 
                amount, account);
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                if (ac_balance >= amount) {
                    ac_balance -= amount;
                    System.out.println("waad ku guuleysay inaad u wareejiso lacagtan");
                } else {
                    System.out.println("haraagagu kuma filno");
                }
            }
        } else {
            System.out.println("numberkaaga sirta ee bangiga waa qalad");
        }
    }

    private static void verifyAccountTransfer() {
        System.out.println("fadlan geli OTP");
        int otp = input.nextInt();
        System.out.println("Ma hubtaa in aad aqbasho lacgta diridan \n1.Haa\n2.Maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            System.out.println("waad ku guuleysay inaa ku dirto lacgta account to account");
        }
    }

    private static void manageBankAccount() {
        System.out.println(" Maareynta Bankiga");
        System.out.println("1. Bedel PIN-ka Bangiga");
        System.out.println("2.Bedel Passwordka Ebank");
        int managementChoice = input.nextInt();
        
        if (managementChoice == 1) {
            changeBankPin();
        } else if (managementChoice == 2) {
            System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
            int pin = input.nextInt();
            System.out.println("error occurred ,please try again later");
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void changeBankPin() {
        System.out.println("Fadlan Geli numberkaaga sirta ee bangiga");
        int oldPin = input.nextInt();
        
        if (oldPin == ac_pass) {
            System.out.println("Fadlan Geli pin-ka cusub ee bangiga");
            int newPin = input.nextInt();
            System.out.println("hubi pin-ka cusub");
            int confirmPin = input.nextInt();
            
            if (newPin != oldPin) {
                if (newPin == confirmPin) {
                    System.out.println("waad ku guuleysay inaa badasho pin-kaaga bangiga");
                } else {
                    System.out.println("fadlan iska hubi pin-kaga cusub");
                }
            } else {
                System.out.println("fadlan iska hubi number sireed ka cusub inuusan la mid aheyn number sireed kaagi hore ee bangiga");
            }
        } else {
            System.out.println("numberkaaga sirta ee bangiga waa qalad");
        }
    }

    private static void handleManagement() {
        System.out.println("Maareynta ");
        String[] managementOptions = {
            "1.Bedel Lambarka Sirta", "2. Bedel Luqadda",
            "3. Wargellin Mobile Lumay", "4. Lacag Xirasho",
            "5. U celli Lacag Qaldantay", "6. EnableMobileBanking"
        };
        
        for (String option : managementOptions) {
            System.out.println(option);
        }
        
        int managementChoice = input.nextInt();
        processManagementChoice(managementChoice);
    }

    private static void processManagementChoice(int choice) {
        switch (choice) {
            case 1: changePin(); break;
            case 2: changeLanguage(); break;
            case 3: reportLostPhone(); break;
            case 4: blockMoney(); break;
            case 5: refundMoney(); break;
            case 6: enableMobileBanking(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void changePin() {
        System.out.println("Fadlan Gelli PIN-Kaaga Cusub");
        int newPin = input.nextInt();
        System.out.println("Hubi PIN-Kaaga Cusub");
        int confirmPin = input.nextInt();
        
        if (newPin == confirmPin) {
            System.out.println("<-EVCPlus-> Waad Ku guuleysatay in aad badasho PIN-kaaga");
        } else {
            System.out.println("Kuma aadan Guleysan inaad badasho pinkaaga");
        }
    }

    private static void changeLanguage() {
        System.out.println("Falan Dooro luqada");
        System.out.println("1.English");
        System.out.println("2. Soomaali");
        int languageChoice = input.nextInt();
        
        if (languageChoice == 1) {
            System.out.println("<-EVCPlus-> you are succesfully changed your language");
        } else if (languageChoice == 2) {
            System.out.println("<-EVCPLus-> Waad ku guuleysatey inaad badasho luqadda");
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void reportLostPhone() {
        System.out.println("Fadlan Geli Mobile-ka lumay");
        int lostNumber = input.nextInt();
        
        System.out.printf("Ma hubtaa in aad u diiwaan Geliso lumid number-kan %d\n1. haa\n2. maya\n", lostNumber);
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            System.out.println("waad ku guuleysay inaa u diiwan geliso mobile-lumay");
        }
    }

    private static void blockMoney() {
        System.out.println("fadlan Geli numberka khalad ah");
        int wrongNumber = input.nextInt();
        System.out.println("faldan geli numberkii loo rabay");
        int correctNumber = input.nextInt();
        
        if (wrongNumber == correctNumber) {
            System.out.println("Ma hubtaa inaa aad xirto lacagtan?\n1. haa\n2. maya");
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                System.out.println("waad ku guuleysay inaa xirato lacagtaan");
            }
        } else {
            System.out.println("dhaqdhaaqaan ma ahan mid jira");
        }
    }

    private static void refundMoney() {
        System.out.println("fadlan Geli aqoonsiga lacag diridda");
        int transactionId = input.nextInt();
        System.out.printf("Ma hubtaa in aad celiso lacgtan? %d\n1. haa\n2. maya\n", transactionId);
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            System.out.println("waad ku guuleysay inaa celiso lacagta");
        }
    }

    private static void enableMobileBanking() {
        System.out.println("fadlan  geli  number-ka is diiwan gelinta");
        int number = input.nextInt();
        System.out.println(number + " Activation record was found");
    }

    private static void handleTaaj() {
        System.out.println("TAAJ");
        String[] taajOptions = {
            "1. Gudaha", "2. Dibadda", "3. Ogoow Khidmada",
            "4. Macluumadka xawaaladda", "5. Jooji Xawaaladda",
            "6. Fur Xawaaladda"
        };
        
        for (String option : taajOptions) {
            System.out.println(option);
        }
        
        int taajChoice = input.nextInt();
        processTaajChoice(taajChoice);
    }

    private static void processTaajChoice(int choice) {
        switch (choice) {
            case 1: case 2:
                handleDomesticInternationalTransfer(choice);
                break;
            case 3:
                handleTaajService();
                break;
            case 4: case 5: case 6:
                handleTaajTransactionManagement(choice);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void handleDomesticInternationalTransfer(int type) {
        System.out.println("Fadlan Geli Taleefanka qaataha");
        int phone = input.nextInt();
        input.nextLine(); // Consume newline
        
        System.out.println("Fadlan Geli Magaca qaataha oo seddexan");
        String name = input.nextLine();
        
        System.out.println("Fadlan Geli Magaalada qaataha uu joogo");
        String city = input.nextLine();
        
        System.out.println("Fadlan Geli lacagta");
        double amount = input.nextDouble();
        
        System.out.println("Khidmada ma xisaabtada ayaa laga jarayaa?\n1. Haa\n2. Maya");
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (ac_balance < amount) {
                System.out.println("Haraagaagu kuguma filna");
            } else {
                ac_balance -= amount;
                System.out.printf("Waxaad lacag $%.2f u dirtay %s oo jooga magaalada %s. Haraagaaga hadda waa $%.2f\n", 
                    amount, name, city, ac_balance);
            }
        } else {
            System.out.println("Lacag lama dirin. Waad ka laabatay.");
        }
    }

    private static void handleTaajService() {
        System.out.println("Fadlan dooro shirkada");
        String[] companies = {
            "1. PAY TO EVCPLUS TMT", "2. TAAJ", "3. TaajPay",
            "4. New Etaaj", "5. TAAJ IPS"
        };
        
        for (String company : companies) {
            System.out.println(company);
        }
        
        int companyChoice = input.nextInt();
        System.out.println("Fadlan Geli Taleefanka qaataha");
        int phone = input.nextInt();
        System.out.println("Fadlan Geli lacagta");
        double amount = input.nextDouble();
        
        System.out.printf("mahubtaa inaad $%.2f u dirto tel No %d?\n1.Haa\n2.Maya\n", amount, phone);
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            if (ac_balance < amount) {
                System.out.println("Haraaga koontadan kuma filna");
            } else {
                ac_balance -= amount;
                System.out.printf("Waxaad $%.2f u dirtay tell No %d. Haraagaagu waa $%.2f\n", 
                    amount, phone, ac_balance);
            }
        } else {
            System.out.println("Mahadsanid");
        }
    }

    private static void handleTaajTransactionManagement(int action) {
        System.out.println("Fadlan Geli aqoonsiga lacag diridda");
        int transactionId = input.nextInt();
        System.out.println("Fadlan Geli Macluumaad");
        int info = input.nextInt();
        
        if (info != transactionId) {
            System.out.println("Invalid Input match (length)");
            return;
        }
        
        String actionName = "";
        switch (action) {
            case 4: actionName = "xirto"; break;
            case 5: actionName = "joojiso"; break;
            case 6: actionName = "furto"; break;
        }
        
        System.out.printf("Mahubtaa in aad %s aqoonsiga xawilaada %d?\n1.Haa\n2.Maya\n", actionName, transactionId);
        int confirmation = input.nextInt();
        
        if (confirmation == 1) {
            System.out.printf("Waxaad %s lacagta aqoonsiga %d\n", actionName, transactionId);
        } else {
            System.out.println("Mahadsanid");
        }
    }

    private static void handleBillPaymentService() {
        int reference = 615698262;
        System.out.println("EVCPlus");
        System.out.println("1. itus haraaaga bill ka\n2. Wada Bixi bill ka\n3. Qayb ka bixi Bill");
        int billChoice = input.nextInt();
        
        if (billChoice < 1 || billChoice > 3) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }
        
        System.out.println("Fadlan Geli bill reference number");
        int userReference = input.nextInt();
        
        if (reference != userReference) {
            System.out.println("some parameters are missing. please check your request");
            return;
        }
        
        if (billChoice == 1) {
            System.out.println("Haraagaaga bill ku waa $" + balance);
        } else {
            System.out.println("Fadlan Geli lagacta bill ka");
            double amount = input.nextDouble();
            
            String action = (billChoice == 2) ? "wada bixisay" : "Qayb ka bixisay";
            System.out.printf("Ma hubtaa in aad %s lacagta bill ka una udirtay %d \n1.Haa \n2.Maya\n", 
                action, userReference);
            int confirmation = input.nextInt();
            
            if (confirmation == 1) {
                if (amount < 1 || amount > balance) {
                    System.out.println("Haraagaagu kuguma filna");
                    return;
                }
                
                balance -= amount;
                System.out.printf("waxaad %s lacagta bill ka waxaad na udirtay %d haraagaagu waa $%.2f\n", 
                    action, userReference, balance);
            } else {
                System.out.println("Mahadsanid!");
            }
        }
    }
}