public class setpasswordA implements CheckAccount {
    public String AdminUser;
    public String AdminPassword;

    public setpasswordA() {
        this.AdminUser = "1";
        this.AdminPassword = "1";
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
