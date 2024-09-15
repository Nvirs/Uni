package Filemanagement;

/*
* A record egy új típusú osztály a Java 14-től kezdve, amelyet arra terveztek,
* hogy adathordozó osztályokat hozzon létre minimális kóddal.
* A record automatikusan generálja az összes szükséges metódust,
* mint például a konstruktorokat, a gettereket, az equals(), a hashCode() és a toString() metódusokat.
* */
public record MyListType(String fullname, Integer data1, Integer data2) {
}

/*
public class MyListType {
    private final String fullname;
    private final Integer data1;
    private final Integer data2;

    public MyListType(String fullname, Integer data1, Integer data2) {
        this.fullname = fullname;
        this.data1 = data1;
        this.data2 = data2;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getData1() {
        return data1;
    }

    public Integer getData2() {
        return data2;
    }
}*/
