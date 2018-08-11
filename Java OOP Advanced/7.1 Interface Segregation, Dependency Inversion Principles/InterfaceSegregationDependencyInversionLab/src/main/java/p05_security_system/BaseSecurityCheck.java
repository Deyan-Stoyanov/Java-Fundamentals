package p05_security_system;

public abstract class BaseSecurityCheck implements SecurityCheck{
    private SecurityUI securityUI;

    protected BaseSecurityCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    public SecurityUI getSecurityUI() {
        return this.securityUI;
    }

    public void setSecurityUI(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }
}
