package com.company;

public class CarDetails {

    private String carRegistration;
    private String carMake;
    private String carModel;
    private double engineSize;

    public CarDetails(String CarRegistration, String CarMake, String CarModel, double EngineSize)
    {
        setCarRegistration(CarRegistration);
        setCarMake(CarMake);
        setCarModel(CarModel);
        setEngineSize(EngineSize);
    }

    public String getCarRegistration() {return carRegistration; }

    public void setCarRegistration(String carRegistration) {this.carRegistration = carRegistration; }

    public String getCarMake() {return carMake;    }

    public void setCarMake(String carMake) { this.carMake = carMake;  }

    public String getCarModel() { return carModel;  }

    public void setCarModel(String carModel) { this.carModel = carModel; }

    public double getEngineSize() { return engineSize;  }

    public void setEngineSize(double engineSize) {this.engineSize = engineSize;   }

    @Override
    public String toString()
    {
        return getCarRegistration() + " " + getCarMake() + " " + getCarModel() + " " + getEngineSize();
    }


}
