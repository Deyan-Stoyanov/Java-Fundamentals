package p05_security_system;

public class PinCodeCheck extends BaseSecurityCheck {

    public PinCodeCheck(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        int pin = this.getSecurityUI().requestPinCode();
        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }
}
