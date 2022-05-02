package Learning.January;

public class polyTest2 {
    public static void main(String[] args) {
        polyTest2 polyTest2 = new polyTest2();
        Employee employee = new Employee("Mike", 10000);
        worker worker = new worker("John", 20000);
        manager manager = new manager("Jack", 30000, 200000);
        polyTest2.showAnnual(employee);
        polyTest2.showAnnual(worker);
        polyTest2.showAnnual(manager);
        polyTest2.testWork(employee);
        polyTest2.testWork(worker);
        polyTest2.testWork(manager);

    }
    //方法多态显示
    public void showAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e) {
        if (e instanceof worker) {
            ((worker)e).work();
        } else if (e instanceof manager) {
            ((manager)e).manage();
        } else {
            System.out.println("do nothing...");
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getAnnual() {
        return 12 * salary;
    }
}

class worker extends Employee {

    public worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
    public void work() {
        System.out.println("工人干活");
    }
}

class manager extends Employee {
    private double bonus;

    public manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
    public void manage() {
        System.out.println("经理管理");
    }
}