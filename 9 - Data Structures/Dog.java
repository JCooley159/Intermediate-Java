package dataStructures;


public class Dog implements Comparable<Dog>
{
    private String name;
    private int age;
    private String breed;
    private int weight;

    public Dog()
    {
        name = "";
        age = 0;
        breed = "";
        weight = 0;
    }

    public Dog(String name, int age, String breed, int weight)
    {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getBreed()
    {
        return breed;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
    public String toString()
    {
        String dogStr = "";
        dogStr += name;
        dogStr += " is a ";
        dogStr += breed;
        dogStr += ". ";
        dogStr += name + " weighs " + weight + " pounds. ";
        dogStr += name + " is " + age + " years old.";
        
        
        return dogStr;
    }

    @Override
    public int compareTo(Dog secDog)
    {
        return age - secDog.getAge();
    }    
}
