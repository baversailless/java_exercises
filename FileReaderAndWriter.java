// необходимо создать программу, которая принимает два аргумента (путь к файлу и режим открытия файла чтение)
// программа должна проверять, что файл существует, если режим - чтение, если файл не существует и режим - запись, то создать файл
// программа должна проверять,что второй аргумент (режим открытия файла) соответствует одному из тех значений, который ожидает программа
// если какая-то проверка не проходит, то программа должна вывести сообщение и завершиться
// программа должна уметь создавать файл в папке или подпапке. Например, если указать в качестве аргумента “myfile.txt” или “mydir/subdir/myfile.txt”
// если файл, открытый для чтения, пустой, то программа должна вывести сообщение “Файл пустой”
// программа должна сохранять и  выводить содержимое файла “как есть” (не разбивать по символам)
// если режим - запись, то программа выводит приглашение к вводу текста.
// после окончания ввода должна она сохранить текст в файл.
// момент окончания ввода может определяться любым символом или последовательностью символов (например, “stop”)


import java.io.*;
import java.util.Scanner;

public class FileReaderAndWriter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path of the file: ");
        String path = scanner.next();
        System.out.println("Choose what do you want to do: to read or to write");
        System.out.println("Type -r - for reading, -w - for writing");
        String flag = scanner.next();

        File file = new File(path);

        if (flag.equals("-r")){
            read(file);
        } else if (flag.equals("-w")){
            write(file);
        } else {
            System.out.println("Invalid flag has entered");
        }
    }

    public static void read(File file) throws IOException {
        if (file.exists()) {
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            if (!scanner.hasNextLine()) {
                System.out.println("This file is empty! ");
            } else {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                reader.close();
                scanner.close();
            }
        }
        else{
            System.out.println("There is no such file");
        }
    }

    public static void write(File file) throws IOException {
        if(file.exists()){
            System.out.println("Please enter what do you want to add to the file");
            FileWriter writer = new FileWriter(file, true);
            Scanner scanner = new Scanner(System.in);
            String newLine;
            do {
                newLine = scanner.nextLine();
                writer.write(newLine + '\n');
            } while (!newLine.equals("stop"));
            writer.close();
            scanner.close();


        } else {
            file.createNewFile();
            System.out.println("The new file has created: ");
            System.out.println("Name: " + file.getName());
        }
    }
}
