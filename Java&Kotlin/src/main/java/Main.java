

class FuelTankMonitoring {
    public void checkAndWarn() {
        if (checkFuelTank()) {
            giveWaringSignal();
        }
    }

    protected boolean checkFuelTank() {
        return true;
    }

    protected void giveWaringSignal() {
    }
}

class FuelTankMonitoring2 extends FuelTankMonitoring {
    protected boolean checkFuelTank() {
        return true;
    }

    protected void giveWarningSignal() {
    }
}