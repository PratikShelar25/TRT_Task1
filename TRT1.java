import java.util.Scanner;
    public class Main {

           public static class Bank {
                public String accno;
                public String name;
                public long balance;
                public long Phone;
                public String gender;
                public int number = (int)(Math.random()*100000);
                public int creditNo = (int)(Math.random()*1000000000);
                public int terms;
                public String acc,credit;
                public int verified = 0;

                Scanner KB = new Scanner(System.in);
                void generateotp() {
                    int otp;
                    System.out.println("Enter the OTP Send On Your Register Mobile Number\nYour One Time OTP Is:- "+ number);
                    System.out.println("Enter Your One Time OTP:- ");
                    otp = KB.nextInt();
                    if (number==otp){
                        System.out.println("OTP is verified Successfully.");
                        verified = 1;

                    }
                    else{

                        System.out.println("Enter The Correct OTP.");
                        verified = 0;
                    }
                }
                //method to open an account
                void openAccount() {
                    System.out.println("Fill The Following Form To Create Account In Our Bank.");
                    System.out.print("Enter Account No: ");
                    accno = KB.next();
                    System.out.print("Enter Name: ");
                    name = KB.next();
                    System.out.print("Enter Balance: ");
                    balance = KB.nextLong();
                    System.out.println("Enter Your Phone Number:- ");
                    Phone = KB.nextLong();
                    generateotp();
                    System.out.println("Enter Your Gender:-\n  1.male\n  2.Female\n  3.Other");
                    gender = KB.next();
                    System.out.println("\n ***** TRT Bank *****\n");
                    System.out.println("To Agree Our Terms And Services Press 0:- ");
                    terms = KB.nextInt();
                    System.out.println("Congratulations!!\nYour Account Is created Successfully!!\n");

                }

                //method to display account details
                void showAccount() {
                    System.out.println("Account Number:- "+ accno + "\nAccount Holder:- " + name + "\nAccount Balance:- " + balance+"\n");

                }

                //method to deposit money
                void deposit() {
                    long amt;
                    System.out.println("Enter Amount U Want to Deposit : ");
                    amt = KB.nextLong();
                    generateotp();
                    balance = balance + amt;
                    System.out.println("Amount is Deposited!!\n Now your Account balance is:- " +balance);
                }

                //method to withdraw money
                void withdrawal() {
                    long amt,RM;
                    System.out.println("Enter Amount U Want to withdraw : ");
                    amt = KB.nextLong();
                    System.out.println("Enter Your register mobile number:- ");
                    RM = KB.nextLong();
                    if(RM ==Phone){
                        generateotp();
                    }
                    else{
                        System.out.println("Mobile Number is Not Register With Bank.");
                    }

                    if (balance >= amt && verified == 1) {
                        balance = balance - amt;
                        System.out.println("Your Transaction is successfull!!");
                        System.out.println("Your New Acount Balance is:- "+balance);
                    }
                    else {
                        System.out.println("Less Balance..Transaction Failed..");
                    }
                }

                //method to search an account number
                boolean search(String acn) {
                    if (accno.equals(acn)) {
                        showAccount();
                        return (true);
                    }
                    return (false);
                }
                void debit(){
                    //String acc,credit;
                    System.out.println("Enter account number Register with your bank:- ");
                    acc = KB.next();
                    if(acc.equals(accno)) {
                        System.out.println("Your Debit Card No. is:-"+creditNo + "\nPlease Remember Your debit Card Details Until you didn't Receive Physical Card.");
                        generateotp();
                        System.out.println("Thanks For Applying for dedit Card.\n Your Application for Debit Card Is Successfully Submited!!");
                    }
                    else{
                        System.out.println("Account Number is Not Found!.Please Enter Correct Account Number or create Account First!");
                    }
                }
            }
        public static void main(String[] arg) {
            Scanner KB = new Scanner(System.in);

            //create initial accounts
            System.out.println("*********************************************\n");

            System.out.println("Welcome to TRT Bank.\n");


            System.out.println("*********************************************\n");

            System.out.print("Press 1 to Use Our banks Facilities:- \n");
            int n = KB.nextInt();
            Bank C = new Bank();

            //run loop until menu 5 is not pressed
            int ch;
            do {
                System.out.println("Main Menu\n1.Open a new account\n2.Show Account Details\n"+
                        "3.Search By Account\n4.Deposit Money\n5.Withdrawal\n"+
                        "6.Apply for debit card\n7.Help\n8.Exit ");
                System.out.println("\nWhich Function Of Our Bank You Want to Use:");
                ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        C.openAccount();
                        break;
                    case 2:
                        C.showAccount();
                        break;
                    case 3:
                        System.out.print("Enter Account No. U Want to Search...: ");
                        String acn = KB.next();
                        boolean found = false;
                        C.search(acn);
                        System.out.println("Enter any key To Exit.");
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        C.deposit();
                        break;

                    case 5:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        C.withdrawal();
                        break;
                    case 6:
                        System.out.println("Applying for debit card Fill Following Credentials.");
                        C.debit();
                        break;

                    case 7:
                        System.out.println("Contact For any Help: TRT@gmail.com \nManager Of Bank:- Om Pangavhane\n Contact:9874563215");
                        break;
                    case 8:
                        System.out.println("\n*********************************************");
                        System.out.println("Thanks For Visiting Our bank.\nHave A Nice Day.\nVisit Again!!");
                        System.out.println("*********************************************");
                        break;
                }
            }
            while (ch!=8);
}
    }