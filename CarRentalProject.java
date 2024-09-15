import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car
{
    private String carId;
    private String brand;
    private String model;
    private double BasePricePerDay;
    private boolean isAvailable;

    public Car(String carId,String brand,String model,double BasePricePerDay)
    {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.BasePricePerDay = BasePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId()
    {
        return carId;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public double calculatorPrice(int rentalDays)
    {
        return BasePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent()
    {
        isAvailable = false;
    }

    public void returnCar()
    {
        isAvailable = true;
    }
}

class Customer
{
    private String customerId;
    private String name;

    public Customer(String customerId,String name)
    {
        this.customerId = customerId;
        this.name=name;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    public String getName()
    {
        return name;
    }
}

class Rental
{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car,Customer customer,int days)
    {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar()
    {
        return car;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public int getDays()
    {
        return days;
    }
}

class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent : ");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println(" Car was not Rented ");
        }
    }

    public void menu() {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("====== Car Rental System ======");
            System.out.println("1. Rent a Car ");
            System.out.println("2. Return a Car ");
            System.out.println("3. Exit ");
            System.out.print("Enter your Choice : ");

            int choice = s.nextInt();
            s.nextLine();

            if (choice == 1) {
                System.out.println("\n == Rent a Car ==\n");
                System.out.println("Enter your Name : ");
                String customerName = s.nextLine();

                System.out.println("\n Available Cars : ");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }

                System.out.println("\n Enter the car ID you want to rent : ");
                String carId = s.nextLine();

                System.out.println("Enter the number of days for rental : ");
                int rentalDays = s.nextInt();
                s.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatorPrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = s.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n==== Return a Car ====\n");
                System.out.println("Enter the car Id your want to return : ");
                String carId = s.nextLine();

                Car CarToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) {
                        CarToReturn = car;
                        break;
                    }
                }
                if (CarToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == CarToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null) {
                        returnCar(CarToReturn);
                        System.out.println("Car was Returned Successfully by  : " + customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing : ");
                    }
                }
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid Choice Please enter a valid option : ");
                }

        }
            System.out.println("\n THANKYOU!!! for using your cars");
            s.close();
    }
}
public class CarRentalProject
        {
            public static void main(String[] args) {

                CarRentalSystem rentalSystem = new CarRentalSystem();
                Car car1 = new Car("C001","Maruti Suzuki","Swift",6000.00);
                Car car2 = new Car("C002","Toyota","Fortunar",8000.00);
                Car car3 = new Car("C003" ,"Mahindra","Scorpio",7000.00);

                rentalSystem.addCar(car1);
                rentalSystem.addCar(car2);
                rentalSystem.addCar(car3);

                rentalSystem.menu();
                
            }

        }


