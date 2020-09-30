public class setpasswordA implements CheckAccount {
    public String AdminUser;
    public String AdminPassword;

    public setpasswordA() {
        this.AdminUser = "6210406572";
        this.AdminPassword = "0000";
    }

    public String getUser() {
        return AdminUser;
    }

    public String getPassword() {
        return AdminPassword;
    }

    @Override
    public boolean check(String user, String pin) {
        if (this.AdminUser.equals(user) && this.AdminPassword.equals(pin)) {
            return true;
        }
        return false;
    }
}
