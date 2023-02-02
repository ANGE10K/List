import java.time.LocalDate;
import java.time.Month;

public class Company {
     private String name;
     private String foundationDate;
     private String specialization;
     private int countEmployees = 0;
     private Project[] projects = new Project[1000];
     private int countProject = 0;
     private Employee[] employees = new Employee[1000];

     public static void main(String[] args) {
          Company company = new Company("World of games", "1999.08.13", "Game");
          Employee employee0 = new Employee("Mikhail", 100, 30,"Программист", company);
          Employee employee1 = new Employee("Valery", 101, 23,"Программист", company);
          Employee employee2 = new Employee("Semen", 102, 25,"Программист", company);
          Employee employee3 = new Employee("Evgeny", 103, 20,"Старший Программист", company);
          Employee employee4 = new Employee("Sergey", 104, 20,"Старший Программист", company);
          Employee employee5 = new Employee("Maksim", 105, 21,"Аналитик", company);
          Employee employee6 = new Employee("Alex", 106, 22,"Аналитик", company);
          Employee employee7 = new Employee("Kirill", 107, 26,"Старший Аналитик", company);
          Employee employee8 = new Employee("Egor", 108, 20,"Старший Аналитик", company);
          Employee employee9 = new Employee("Petr", 109, 31,"Тимлид", company);
          Employee employee10 = new Employee("Vladimir", 110, 21,"Тимлид", company);
          Project project0 = new Project("Game", 15000, LocalDate.of(2020, 12, 3), 5, company);
          Project project1 = new Project("Advertising", 104000, LocalDate.of(2020, 4, 20), 7, company);
          company.autoAddEmployeeInProject(company.employees, company.projects);
          company.fireEmployee(100);
          company.description();
     }

     Company(String name, String foundationDate, String specialization) {
          this.name = name;
          this.foundationDate = foundationDate;
          this.specialization = specialization;

     }

     public void addEmployee(Employee employee) {
          employees[countEmployees] = employee;
          countEmployees++;
     }

     public void fireEmployee(int id) {
          int k = -1;
          for (int i = 0; i < countEmployees; i++) {
               if (id == employees[i].getId()) {
                    k = i;
                    if (employees[i].getInProject().equals("Да")) {
                         employees[i].getProject().fireEmployeeInProject(id);
                    }
               }
          }
          if (k == -1) {
               return;
          }
          for (int i = k; i < countEmployees; i++) {
               employees[i] = employees[i + 1];
          }
          countEmployees--; // Надо добавть удаленние из всех его проектов: Использовать fireEmployeeInProject
     }

     public void addProject(Project project) {
          projects[countProject] = project;
          countProject++;
     }

     public void autoAddEmployeeInProject(Employee[] employees, Project[] project) {
          for (int k = 0; k < countProject; k++) {
               for (int i = 0; i < countEmployees; i++) {
                    project[k].addEmployeeInProject(employees[i]);
               }
          }
     }

     public void fireProject(String name) {
          int k = -1;
          for (int i = 0; i < countProject; i++) {
               if (name == projects[i].getName()) {
                    k = i;
               }
          }
          if (k == -1) {
               return;
          }
          for (int i = k; i < countProject; i++) {
               projects[i] = projects[i + 1];
          }
          countProject--;
          return;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getFoundationDate() {
          return foundationDate;
     }

     public void setFoundationDate(String foundationDate) {
          this.foundationDate = foundationDate;
     }

     public String getSpecialization() {
          return specialization;
     }

     public void setSpecialization(String specialization) {
          this.specialization = specialization;
     }

     public int getCountEmployees() {
          return countEmployees;
     }

     public void setCountEmployees(int countEmployees) {
          this.countEmployees = countEmployees;
     }

     public void description() {
          System.out.println("Название компании: " + this.getName());
          System.out.println("Дата основания компании: " + this.getFoundationDate());
          System.out.println("Специализация компании: " + this.getSpecialization());
          System.out.println("Количество сотрудников: " + this.getCountEmployees());
          System.out.println("Количество проектов: " + this.countProject);
          System.out.println("Данные проектов:");
          System.out.println();
          for (int i = 0; i < countProject; i++) {
               System.out.println("Название проката: " + projects[i].getName());
               System.out.println("Бюджет: " + projects[i].getBudget());
               System.out.println("Использовано бюджета: " + projects[i].getSum());
               System.out.println("Дата окончания проекта: " + projects[i].getEndDate());
               System.out.println("Человек в прокете: " + projects[i].getCountEmployeeInProject());
               System.out.println("Максимальное количество человек в проекте: " + projects[i].getCountEmployeeInProjectMax());
               System.out.println();
          }
          System.out.println();
          System.out.println("Список сотрудников: ");
          for (int i = 0; i < countEmployees; i++) {
               System.out.println("Имя: " + employees[i].getName() + "  " + "Айди: " + employees[i].getId() + "  "
                       + "Возраст: " + employees[i].getAge() + "  " + "Зарплата: " + employees[i].getSalary() + "  "
                       + "Должность: " + employees[i].getPosition() + "  "
                       + "Участие в проекте: " + employees[i].getInProject());
          }
     }
}

class Employee {
     private String name;
     private int id;
     private int age;
     private int salary = 2000;
     private String position;
     private final int bonusSeniorPro = 1000;
     private int bonusSeniorAn = 800;
     private int bonusTeamLid = 1500;
     private String inProject = "Нет";
     private Project project;

     Employee(String name, int id, int age, String position, Company company) {
          this.name = name;
          this.id = id;
          this.age = age;
          this.position = position;
          company.addEmployee(this);
          if(position.equals("Старший Программист")) {
               salary += bonusSeniorPro;
          }
          if(position == "Старший Аналитик") {
               salary += bonusSeniorAn;
          }
          if(position == "Тимлид") {
               salary += bonusTeamLid;
          }
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }

     public int getSalary() {
          return salary;
     }

     public void setSalary(int salary) {
          this.salary = salary;
     }

     public String getPosition() {
          return position;
     }

     public void setPosition(String position) {
          this.position = position;
     }

     public String getInProject() {
          return inProject;
     }

     public void setInProject(String inProject) {
          this.inProject = inProject;
     }

     public Project getProject() {
          return project;
     }

     public void setProject(Project project) {
          this.project = project;
     }
}

class Project {
     private String name;
     private int budget;
     private int sum;
     private LocalDate endDate;
     private Employee[] employeesInProject;
     private int countEmployeeInProjectMax;
     private int countEmployeeInProject = 0;


     Project(String name, int budget, LocalDate endDate, int countEmployeeInProjectMax, Company company) {
          this.name = name;
          this.budget = budget;
          this.endDate = endDate;

          this.countEmployeeInProjectMax = countEmployeeInProjectMax;
          this.employeesInProject = new Employee[countEmployeeInProjectMax];
          company.addProject(this);
     }

     public void addEmployeeInProject(Employee employee) {
          if (countEmployeeInProject < countEmployeeInProjectMax && sum + employee.getSalary() <= budget && employee.getInProject() == "Нет") {
               employeesInProject[countEmployeeInProject] = employee;
               countEmployeeInProject++;
               sum += employee.getSalary();
               employee.setInProject("Да");
               employee.setProject(this);
          }
     }

     public void fireEmployeeInProject(int id) {
          int k = -1;
          for (int i = 0; i < countEmployeeInProject; i++) {
               if (id == employeesInProject[i].getId()) {
                    k = i;
               }
          }
          if (k == -1) {
               return;
          }
          for (int i = k; i < countEmployeeInProject - 1; i++) {
               employeesInProject[i] = employeesInProject[i + 1];
          }
          countEmployeeInProject--;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getBudget() {
          return budget;
     }

     public void setBudget(int budget) {
          this.budget = budget;
     }

     public LocalDate getEndDate() {
          return endDate;
     }

     public void setEndDate(LocalDate endDate) {
          this.endDate = endDate;
     }

     public int getCountEmployeeInProject() {
          return countEmployeeInProject;
     }

     public void setCountEmployeeInProject(int countEmployeeInProject) {
          this.countEmployeeInProject = countEmployeeInProject;
     }

     public int getCountEmployeeInProjectMax() {
          return countEmployeeInProjectMax;
     }

     public void setCountEmployeeInProjectMax(int countEmployeeInProjectMax) {
          this.countEmployeeInProjectMax = countEmployeeInProjectMax;
     }

     public int getSum() {
          return sum;
     }

     public void setSum(int sum) {
          this.sum = sum;
     }
}

