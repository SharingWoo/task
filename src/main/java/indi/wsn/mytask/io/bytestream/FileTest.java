package indi.wsn.mytask.io.bytestream;

import java.io.*;

/**
 * FileName: FileTest.java
 * 类的详细说明
 *
 * @author SharingWoo
 * @version 1.00
 * @Date 2017/4/12
 */
public class FileTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream("C:\\Users\\SharingWoo\\Desktop\\file\\123.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new Person("wsn", 24, "wsn7758358"));
        objectOutputStream.writeObject(new Person("hhh", 21, "hhh7758358"));
        objectOutputStream.close();
        InputStream inputStream = new FileInputStream("C:\\Users\\SharingWoo\\Desktop\\file\\123.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Person person1 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(person1.thisNmae);

    }

    static class Person implements Serializable {
        private String name;
        private int age;
        private transient String address;
        private static String thisNmae = "123321";

        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
