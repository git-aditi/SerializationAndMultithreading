package serialization.deserialization;

import java.io.*;

public class SerializationDeserializationExample {
    public static void main(String[] args) {
        Person person = new Person("Name1", "1234567890","name1@gmail.com");

        SerializeDeserializeObject sdo = new SerializeDeserializeObject(person);

//        sdo.serializeObject();

        sdo.deserializeObject();

    }

}
class Person implements Serializable {
    private static final long serialVersionUID=2L;

    private String name;
    private String phoneNumber;
    private String emial;

//    transient private String emial;

    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emial = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emial='" + emial + '\'' +
                '}';
    }
}

class SerializeDeserializeObject {

    private Person p1;
    private final String PATH = "/Users/niravbavishi/Documents/MIIT/FileDemo/Object.txt";

    public SerializeDeserializeObject(Person p1) {
        this.p1 = p1;
    }

    public void serializeObject() {
        //Creating stream
        try (FileOutputStream fout = new FileOutputStream(PATH);ObjectOutputStream out = new ObjectOutputStream(fout);){
            // Writing the object
            out.writeObject(this.p1);
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deserializeObject(){
        //Creating stream to read the object
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(PATH));){
            Person person=(Person)in.readObject();
            //printing the data of the serialized object
            System.out.println(person);


        }catch(Exception e){System.out.println(e);}
    }

}