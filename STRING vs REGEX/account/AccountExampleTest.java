package account;

public class AccountExampleTest {
    private static AccountExample accountExample;

    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String args[]) {
        accountExample = new AccountExample();
        for (String account : validAccount) {
            boolean isvalid = accountExample.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = accountExample.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
    }
}
/*
Account is 123abc_ is valid: true
Account is _abc123 is valid: true
Account is ______ is valid: true
Account is 123456 is valid: true
Account is abcdefgh is valid: true
Account is .@ is valid: false
Account is 12345 is valid: false
Account is 1234_ is valid: false
Account is abcde is valid: false

Process finished with exit code 0
 */