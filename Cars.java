package Data_Project;

public class Cars {
    
    String carType;
    String carBrand;
    String carColor;
    int carModel;
    int price;
    static int count;

    Cars() {
        
        carType = " ";
        carBrand = " ";
        carColor = " ";
        carModel = 0;
        price = 0;
        count++;
    }

    public Cars(String carType, String carBrand, String carColor, int carModel, int price) {

        this.carType = carType;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.carModel = carModel;
        this.price = price;
        count++;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarModel() {
        return carModel;
    }

    public void setCarModel(int carModel) {
        this.carModel = carModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Car Type: " + carType + "\nCar Brand: " + carBrand + "\nColor: " + carColor + "\nModel: " + carModel + "\nPrice: " + price;
    }
}
