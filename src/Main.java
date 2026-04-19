import Classes.*;
import Classes.Classwork.*;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidLoginException;


void main() {
    int choice=-1;
    String[] menuElements=new String[]{
            "Сделайте ваш выбор:",
            "1.Калькулятор",
            "2.Игра Быки и Коровы",
            "3.Найти четные числа",
            "4.Форматирование double массива",
            "5.Анализ двумерного массива",
            "6.Деление",
            "7.Банковский аккаунт",
            "8.Создание пользователя с валидацией",
            "9.Менеджер паролей",
            "0.Выход"
    };
    while(choice!=0){
        clearConsole();
        for(String menu:menuElements ){
            System.out.println(menu);
        }
        System.out.print("->");
        try{
            choice=Integer.parseInt(getInput());
        }catch (Exception e){
            choice=-1;
        }

        switch (choice){
            case 1: {
                simpleCalculator();
                clearConsole();
                break;
            }
            case 2:{
                bullsAndCows();
                clearConsole();
                break;
            }
            case 3:{
                findEvenNumbers();
                clearConsole();
                break;
            }
            case 4:{
                formatDoubleArray();
                clearConsole();
                break;
            }
            case 5:{
                analysisOfTwoDimensionalArray();
                clearConsole();
                break;
            }
            case 6:{
                processingDivide();
                clearConsole();
                break;
            }
            case 7:{
                processingBankAccount();
                clearConsole();
                break;
            }
            case 8:{
                processUserValidating();
                clearConsole();
                break;
            }
            case 9:{
                runPasswordManager();
                clearConsole();
                break;
            }
            case -10:{
                clearConsole();
                Animal[] animalsArray = {
                        new Dog("Собака1", 3),
                        new Cat("Кот1", 2),
                        new Dog("Собака2", 5),
                        new Cat("Кот2", 4)
                };
                for(Animal animal:animalsArray){
                    animal.makeSound();
                }
                getInput();
                break;
            }
            case -11:{
                clearConsole();
                Employee[] employees={
                  new Manager("Manager1",100000),
                  new Manager("Manager2",87000),
                  new Developer("Developer1", 150000,1),
                  new Developer("Developer2", 120000,2),
                        new Developer("Developer3",100000,0),
                        new Developer("Developer4",200000,999)
                };
                for(Employee employee:employees){
                    employee.work();
                }
                getInput();
                break;
            }
            case -12:{
                clearConsole();
                PaymentMethod[] paymentMethods={
                        new BankCard("BC1",100000),
                        new BankCard("BC2",6000),
                        new BankCard("BC3",10000),
                        new Wallet("W1",50000),
                        new Wallet("W2",10000),
                        new Wallet("W3",1000)
                };
                for(PaymentMethod paymentMethod:paymentMethods){
                    System.out.printf("Попытка списать 10.000 у %s с балансом %f",paymentMethod.getOwnerName(),paymentMethod.getBalance());
                    paymentMethod.pay(10000);
                    System.out.printf("\nБаланс %s после списывания средств: %f\n\n",paymentMethod.getOwnerName(),paymentMethod.getBalance());
                }
                getInput();
                break;
            }
            case 0: break;
            default: {
                choice=-1;
                break;
            }
        }
    }
}

String getInput(){
    String input="";
    try{
    InputStream inputStream = System.in;
    Reader inputStreamReader= new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    input= bufferedReader.readLine();
    }catch (Exception e){
        input= e.getMessage();
    }
    return  input;
}

public static void clearConsole() {
    for(int i=0;i<20;i++){
        System.out.println("\n");
    }
}

boolean endOrContinue(){
    System.out.println("\nПовторить? 1-да, остальное - выйти");
    System.out.print("\n->");
    String answer = getInput();
    return answer.equalsIgnoreCase("1");
}

void simpleCalculator(){

    String result="";
    while (!result.equalsIgnoreCase("stop")){
        clearConsole();
        System.out.print("Введите 2 числа : ");
        String numbers= getInput();
        if(numbers.equalsIgnoreCase("stop") || numbers.equalsIgnoreCase("стоп")){
            result="stop";
            continue;
        }

        System.out.print("Введите знак действия с числами (+ - * /) : ");
        String sign= getInput();
        if(sign.equalsIgnoreCase("stop") || sign.equalsIgnoreCase("стоп")){
            result="stop";
            continue;
        }

        String[] separatedInput= numbers.split(" ");
        if(separatedInput.length<2) {
            System.out.println("Ошибка при вводе данных! (Проблема с числами)\nНажмите ENTER чтобы повторить");
            getInput();
            continue;
        }
        if(!(sign.equals("+") || sign.equals("-")|| sign.equals("*") || sign.equals("/"))){
            System.out.println("Ошибка при вводе данных! (Проблема с выбором действия)\nНажмите ENTER чтобы повторить");
            getInput();
            continue;
        }

        double a= Double.parseDouble(separatedInput[0]);
        double b= Double.parseDouble(separatedInput[1]);

        if(b==0 && sign.equals("/")) sign="!";


        switch (sign){
            case "+":{
                result= Double.toString(a+b);
                break;
            }
            case "-":{
                result= Double.toString(a-b);
                break;
            }
            case "*":{
                result= Double.toString(a*b);
                break;
            }
            case "/":{
                result= Double.toString(a/b);
                break;
            }
            case "!":{
                result="Ошибка деления на ноль!";
                break;
            }
        }
        System.out.println("Результат: "+ a + " " + sign+ " " + b +" = " + result);
        System.out.println("Нажмите ENTER чтобы повторить, или напишите stop/стоп");
        String cont = getInput();
        if(cont.equalsIgnoreCase("stop") || cont.equalsIgnoreCase("стоп")) result="stop";
    }
}

void bullsAndCows(){
    boolean work=true;
    while(work) {
        clearConsole();
        System.out.println("Игра быки и коровы.\nПравила: Нужно угадать 4 цифры. \nЕсли цифра на своём месте - это БЫК (Б), если она существует, но не на своем месте- это КОРОВА (К).");
        int[] opponent = new int[4];
        for (int i = 0; i < opponent.length; i++) {
            opponent[i] = (int) (Math.random() * 10);
        }
        System.out.println("\n");
        boolean result = false;
        while (!result) {

            System.out.print("Введите 4 цифры : ");
            String input = getInput();

            char[] chars = input.toCharArray();
            int[] move = new int[opponent.length];
            for (int i = 0; i < opponent.length; i++) {
                move[i] = Integer.parseInt(String.valueOf(chars[i]));
            }

            String[] stringResult = new String[opponent.length];
            for (int i = 0; i < opponent.length; i++) {
                if (opponent[i] == move[i]) {
                    stringResult[i] = "Б";
                } else {
                    boolean found = false;
                    for (int j = 0; j < move.length; j++) {
                        if (move[i] == opponent[j]) {
                            stringResult[i] = "К";
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        stringResult[i] = "-";
                    }
                }
            }
            String[] win = {"Б", "Б", "Б", "Б"};
            for (String res : stringResult) {
                System.out.print(res);
            }
            System.out.print("\n");
            if (Arrays.equals(stringResult, win)) {
                result = true;
            }
        }
        work=endOrContinue();
    }
}

void findEvenNumbers(){
    boolean work=true;
    while(work) {
        clearConsole();
        System.out.println("Введите целые числа через пробел: ");
        String numbers = getInput();
        String[] splitedNumbers = numbers.split(" ");
        int counter = 0;
        for (String splitedNumber : splitedNumbers) {
            int number = Integer.parseInt(splitedNumber);
            if (number % 2 == 0) {
                counter++;
            }
        }
        int[] arrayOfEvenNumbers = new int[counter];
        int sumOfEvenNumbers = 0;
        int iterator = 0;
        for (String splitedNumber : splitedNumbers) {
            int number = Integer.parseInt(splitedNumber);
            if (number % 2 == 0) {
                arrayOfEvenNumbers[iterator] = number;
                sumOfEvenNumbers += number;
                iterator++;
            }
        }
        System.out.println("Всего чётных чисел: " + counter);
        System.out.print("Чётные числа: ");
        for (int evenNumber : arrayOfEvenNumbers) {
            System.out.print(evenNumber + " ");
        }
        System.out.println("\nСумма чётных чисел: " + sumOfEvenNumbers);
        double averageValue = (double) sumOfEvenNumbers / counter;
        System.out.println("Среднее значение чётных чисел: " + averageValue);

        work=endOrContinue();
    }
}

void formatDoubleArray(){
    boolean work=true;
    while(work) {
        clearConsole();
        System.out.println("Введите числа (можно с плавающей точкой) через пробел: ");
        String numbers = getInput();

        String[] splitedNumbers = numbers.split(" ");
        double[] finalArray = new double[splitedNumbers.length];
        for (int i = 0; i < splitedNumbers.length; i++) {
            double doubleNumber = Double.parseDouble(splitedNumbers[i]);
            if (doubleNumber > 10) {
                splitedNumbers[i] = String.valueOf((int) doubleNumber);
            } else if (doubleNumber < 0) {
                splitedNumbers[i] = String.valueOf(0);
            } else {
                if (doubleNumber % 1 == 0) {
                    splitedNumbers[i] = String.valueOf((int) doubleNumber);
                } else {
                    splitedNumbers[i] = String.valueOf(doubleNumber);
                }
            }
        }
        System.out.print("Результат: ");
        for (String splitedNumber : splitedNumbers) {
            System.out.print(splitedNumber + " ");
        }

        work=endOrContinue();
    }
}

void analysisOfTwoDimensionalArray(){
    boolean work=true;
    while(work){
        clearConsole();
        System.out.print("Введите длину колонки: ");
        int rows= Integer.parseInt(getInput());
        System.out.print("Введите длину ряда: ");
        int cols = Integer.parseInt(getInput());

        if(rows<=0 || cols<=0) continue;
        int[][] array= new int[cols][rows];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                array[i][j]=(int)(Math.random()*41)-20;
            }
        }
        List<Integer> positiveNumbers= new ArrayList<Integer>();
        List<Integer> negativeNumbers= new ArrayList<Integer>();
        int countOfNulls=0;
        int wholeSum=0;
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                System.out.printf("%6d",array[i][j]);
                wholeSum+=array[i][j];
                if(array[i][j]>0){
                    positiveNumbers.add(array[i][j]);
                } else if(array[i][j]<0) {
                    negativeNumbers.add(array[i][j]);
                }else{
                    countOfNulls++;
                }
            }
            System.out.println();
        }
        double averageValue= (double)wholeSum/(positiveNumbers.size()+negativeNumbers.size()+countOfNulls);

        System.out.println("Статистика по массиву:");
        System.out.print("Положительные числа: ");
        int sumOfPositiveNumbers=0;
        for(int number:positiveNumbers){
            System.out.print("["+number+"] ");
            sumOfPositiveNumbers+=number;
        }
        System.out.print("\t(Всего:"+positiveNumbers.size()+")\n");
        System.out.print("Сумма положительных чисел: "+sumOfPositiveNumbers);
        String averageOfPositiveNumbers= !positiveNumbers.isEmpty()
                ?"\tСреднее значение положительных чисел: "+(double)sumOfPositiveNumbers/positiveNumbers.size()+"\n\n"
                :"\tСреднее значение положительных чисел: Отсутствует\n\n";
        System.out.print(averageOfPositiveNumbers);

        System.out.print("Отрицательные числа: ");
        int sumOfNegativeNumbers=0;
        for(int number:negativeNumbers){
            System.out.print("["+number+"] ");
            sumOfNegativeNumbers+=number;
        }
        System.out.print("\t(Всего:"+negativeNumbers.size()+")\n");
        System.out.print("Сумма отрицательных чисел: "+sumOfNegativeNumbers);
        String averageOfNegativeNumbers= !negativeNumbers.isEmpty()
                ? "\tСреднее значение отрицательных чисел: "+(double)sumOfNegativeNumbers/negativeNumbers.size()+"\n\n"
                : "\tСреднее значение отрицательных чисел: Отсутствует\n\n";
        System.out.print(averageOfNegativeNumbers);

        System.out.print("Всего нулей: "+countOfNulls+"\n\n");

        System.out.println("Сумма всех элементов матрицы: "+wholeSum);
        System.out.println("Среднее значение всех элементов матрицы: "+averageValue);
        String positiveOrNegativeMatrix=averageValue>0? "Positive matrix": "Negative matrix";
        System.out.println("Positive/Negative matrix: "+positiveOrNegativeMatrix);

        work=endOrContinue();
    }
}

void processingDivide(){
    boolean work=true;
    while(work) {
        clearConsole();
        System.out.print("Введите число которое нужно разделить: ");
        int a = Integer.parseInt(getInput());
        System.out.print("Введите число на которое нужно разделить: ");
        int b = Integer.parseInt(getInput());
        Divider divider = new Divider(a, b);
        divider.divide();
        divider.printResult();
        work=endOrContinue();
    }
}

void processingBankAccount(){
    clearConsole();
    System.out.print("Введите имя владельца аккаунта: ");
    String ownerName = getInput();
    System.out.print("Введите стартовый баланс: ");
    double startBalance = Double.parseDouble(getInput());
    BankAccount bankAccount= new BankAccount(ownerName,startBalance);
    int choice=-1;
    String[] bankOptions= new String[]{
            "1.Положить деньги на счет",
            "2.Снять деньги со счета",
            "3.Вывести полную информацию о счете",
            "0.Выйти"
    };
    while(choice!=0){
        clearConsole();
        for(String bankOption:bankOptions){
            System.out.println(bankOption);
        }
        System.out.print("->");
        choice=Integer.parseInt(getInput());
        switch (choice){
            case 1:{
                clearConsole();
                System.out.print("Введите сумму которую хотите положить на счет: ");
                double amount= Double.parseDouble(getInput());
                bankAccount.deposit(amount);
                System.out.println(amount + " успешно зачислено на ваш счет");
                System.out.println("Нажмите ENTER чтобы продолжить");
                getInput();
                break;
            }
            case 2:{
                clearConsole();
                System.out.print("Введите сумму которую хотите снять со счета: ");
                double amount= Double.parseDouble(getInput());
                bankAccount.withdraw(amount);
                System.out.println(amount + " успешно снято с вашего счета");
                System.out.println("Нажмите ENTER чтобы продолжить");
                getInput();
                break;
            }
            case 3:{
                clearConsole();
                bankAccount.printInfo();
                System.out.println("Нажмите ENTER чтобы продолжить");
                getInput();
                break;
            }
            case 0: break;
        }

    }
}

void processUserValidating(){
    clearConsole();
    boolean work=true;
    while(work) {
        clearConsole();
        System.out.print("Введите логин: ");
        String login = getInput();
        System.out.print("Введите email: ");
        String email = getInput();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(getInput());
        try{
            User user=new User(login,email,age);
            System.out.println("Пользователь успешно создан!");
            user.printUserInfo();
        }catch (InvalidLoginException | InvalidEmailException | InvalidAgeException e){
            System.out.println("Проблема в создании пользователя: "+ e.getMessage());
        }
        work=endOrContinue();
    }
}

//void tryingWorkWithFile() throws IOException {
//    String PATH = "src/Files";
//    File directory= new File(PATH);
//    if(directory.exists()){
//        System.out.println("Папка существует");
//    }else{
//        System.out.println("Папка отсутствует");
//    }
//    File[] fileArray= directory.listFiles();
//    if(fileArray==null){
//        System.out.println("Файлы в папке отсутствуют");
//    }else{
//        System.out.println("Файлы в папке:");
//        for(File file:fileArray){
//            System.out.printf("%s \t- %s \t| %s \t| %s \t| %s \t| %s \t| %s\n",
//                    file.getName(),file.isDirectory()?"Папка":"Не папка",
//                    file.canExecute()?"Выполняемый":"Не выполняемый",
//                    file.canRead()?"Читаемый":"Не читаемый",
//                    file.canWrite()?"Можно записать":"Нельзя записать",
//                    file.isHidden()?"Скрыт":"Видимый",
//                    file.getAbsolutePath());
//        }
//    }
//
//    File newDirectory= new File(PATH,"newFolder");
//    if(!newDirectory.exists()) {
//        newDirectory.mkdir();
//        System.out.println("Файл создан успешно");
//    }else{
//        System.out.println("Такой файл уже существует");
//    }
//
//    File newFile= new File(PATH,"newFile.txt");
//    if(!newFile.exists()){
//        try {
//            newFile.createNewFile();
//            System.out.println("Файл успешно создан");
//        }catch (IOException e){
//            System.out.println("Ошибка создания файла "+e.toString());
//        }
//    }
//    PrintWriter printWriter=new PrintWriter(newFile);
//    printWriter.println("Первая строчка файла");
//    printWriter.println("Вторая строчка файла");
//    printWriter.println("Третья строчка файла");
//    printWriter.close();
//
//    BufferedReader bufferedReader=null;
//    if(newFile.exists()){
//        bufferedReader=new BufferedReader(new FileReader(newFile));
//        String line;
//        while((line=bufferedReader.readLine())!=null){
//            System.out.println(line);
//        }
//    }
//    try {
//        bufferedReader.close();
//    }catch (IOException e){
//        System.out.println(e.toString());
//    }
//
//    getInput();
//}

void runPasswordManager(){
    PasswordManager passwordManager=new PasswordManager();
    boolean work=true;
    String[] menu={
      "1.Создать пароль",
      "2.Отобразить пароли",
      "3.Очистить пароли",
      "0.Выход"
    };
    while(work){
        clearConsole();
        for(String menuElement:menu){
            System.out.println(menuElement);
        }
        System.out.print("->");
        int choice=Integer.parseInt(getInput());
        switch (choice){
            case 1:{
                clearConsole();
                System.out.print("Введите логин: ");
                passwordManager.setLogin(getInput());
                System.out.print("Введите место использования (Например: Mail.ru): ");
                passwordManager.setPlaceWhereWillBeUsed(getInput());
                System.out.print("Введите тип места (Например: Почта): ");
                passwordManager.setTypeOfPlace(getInput());
                clearConsole();
                System.out.println("1.Ввести пароль вручную");
                System.out.println("2.Сгенерировать случайный пароль");
                System.out.print("->");
                int passwordChoice=Integer.parseInt(getInput());
                switch (passwordChoice){
                    case 1:{
                        clearConsole();
                        System.out.print("Введите пароль для сохранения: ");
                        passwordManager.setPassword(getInput());
                        passwordManager.savePassword();
                        System.out.println("Пароль успешно сохранен! Для продолжения нажмите ENTER");
                        getInput();
                        break;
                    }
                    case 2:{
                        clearConsole();
                        passwordManager.generateRandomPassword();
                        System.out.println("Пароль успешно сгенерирован!");
                        passwordManager.savePassword();
                        System.out.println("Пароль успешно сохранен! Для продолжения нажмите ENTER");
                        getInput();
                        break;
                    }
                }
                break;
            }
            case 2:{
                clearConsole();
                System.out.print("Введите тип для фильтрации (ENTER или all отобразят все пароли): ");
                String typeOfPasswords=getInput();
                passwordManager.getPasswords(typeOfPasswords);
                System.out.println("Для продолжения нажмите ENTER");
                getInput();
                break;
            }
            case 3:{
                clearConsole();
                System.out.println("1.Очистить файл с паролями (без удаления)");
                System.out.println("2.Удалить файл с паролями");
                System.out.println("0.Выход");
                System.out.print("->");
                int deleteChoice=Integer.parseInt(getInput());
                switch (deleteChoice){
                    case 1:{
                        passwordManager.clearFileWithPasswords();
                        System.out.println("Файл успешно очищен! Для продолжения нажмите ENTER");
                        getInput();
                        break;
                    }
                    case 2:{
                        passwordManager.deleteFileWithPasswords();
                        System.out.println("Файл успешно удален! Для продолжения нажмите ENTER");
                        getInput();
                        break;
                    }
                    case 0: break;
                }
                break;
            }
            case 0: work=false;
        }
    }
}
