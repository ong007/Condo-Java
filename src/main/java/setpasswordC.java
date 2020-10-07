public class setpasswordC implements CheckAccount {
    public String CentralUser;
    public String CentralPassword;

    public setpasswordC(String centralUser, String centralPassword) {
        CentralUser = centralUser;
        CentralPassword = centralPassword;
    }

    public String getUser() {
        return CentralUser;
    }

    public String getPassword() {

        return CentralPassword;
    }

    @Override
    public boolean check(String user, String pin) {
        if (this.CentralUser.equals(user) && this.CentralPassword.equals(pin)) {
            return true;
        }
        return false;
    }
}
