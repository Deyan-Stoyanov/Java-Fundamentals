package p05_security_system;

public class KeyCardCheck extends BaseSecurityCheck {

    public KeyCardCheck(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        String code = this.getSecurityUI().requestKeyCard();
        return isValid(code);
    }

    private boolean isValid(String code) {
        return true;
    }
}
