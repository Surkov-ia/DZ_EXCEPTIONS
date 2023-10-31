import java.util.HashMap;
// Происходит запуск приложения
public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {
        DataPars dataPars = new DataPars(); // Создается объект класса DataPars
        String newFileName = null; // Иннициализация переменной
        WriteFile writeFile = new WriteFile(); // Создается объект класса WriteFile

        HashMap<String, Object> data = dataPars.parsInputData(); // Иннициализация словаря
        while (data.size() != 6) {
            try {
                throw new Exception1();
            } catch (Exception1 e) {
                data = dataPars.parsInputData();
            }

        } // Цикл для ввода данных, пока пользователь не введет корректные данные

        newFileName = "src/main/java/" + data.get("lastName") + ".txt"; // Указывается файл для записи данных пользователя
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }
        System.out.println(ANSI_RED+"Запись сохранена"+ANSI_RED);

        String filePath = newFileName;
        writeFile.writeData(String.valueOf(sb), filePath); // Вызывается метод класса WriteFile для записи в файл
    }
}
