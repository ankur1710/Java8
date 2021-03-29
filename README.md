# Java8
Java 8

funtional programming -
1. embraces creating immutable objects
2. more consise and readbale code.
3. using funtions and methods as first class citizens.

Imperative programming -> 
- focus on how to perform the operation
- embraces the object mutability 
- it lists a sstep by step instructions on how to achive an objective
- we wrtie the code on what needs to be done in each step
- uses classic oops

declarative programming -> 
- focuses on the result 
- embraces objects immutability 
- analogous to SQL , we care about the data not the algorithrm or the logic to work on the data. 
- uses functions that are already part of the library to achive an objecttive, 
- funtional programming is used here. 

/**
 * imperative - how style of programming
 */
int sumI=0;
for(int i=0;i<=100;i++){
    sumI+=i;
}
System.out.println("sum using imperative approach "+sumI);
——————————————————————————————> here we are explicitly iterating the way the sum should we calculated. 
this has a major drawback which is , it has a mutable varibale - Sum , which can give issues in a multi-threaded environment and can give unexpected results. 
also the code readability is compromised. if I want to run it in the multi threaded environment I need to manage and start the threads explictly. 

/**
 * declarative - what style of prgramming
 */
int sumD = IntStream.rangeClosed(0,100).sum();
System.out.println("sum using Declarative Approach "+sumD);
——————————————————————————————> here we just said , what I want and code provides to us and it perfroms internal iteration
it is also run in a multithreaded environment. here if I want to run this in a multiThreaded environment all I need is -> 
int sumD = IntStream.rangeClosed(0,100)
        .parallel() // it splits the values over multiple threads
        .sum();


——————————————————————————————————————————————————————————————————————————————————

Lambda Expression -> 
- funtion without a name, its an anonymous functions , it has method parameter , body and return type. 
- can we assigned to any other varriable and can be passed like a any other varriable in Java
- it is not tied to any class like a regular method
( ) -> { }
input  body with the inputs. 

- Lambdas - implements the funtional interfaces. [SAM = Single Abstract methods]
prior to Java8 , funtional interfaces are - Runnable and Comparator 


/**
 * prior java8
 */
Runnable runnable1= new Runnable() {
    @Override
    public void run() {
        System.out.println("inside Runnable1");
    }
};
new Thread(runnable1).start();

/**
 * using lambdas
 */
Runnable runnable2 = () -> {System.out.println("inside Runnable2");};
new Thread(runnable2).start();

———————
- a lot of boiler plate code which is removed in Java8 
- if we just have 1line then we dont need the curly braces,  Runnable runnable2 = () -> System.out.println("inside Runnable3”);

/**
 * prior Java8
 */
Comparator<Integer> comparator1 = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
};
System.out.println("compare "+ comparator1.compare(3,2));

/**
 * Lambda Way
 */
Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
System.out.println("compare "+comparator2.compare(2,3));

Local Varriables in the Lambdas 
———————————————
- you are not allowed to use the same local Varriable name as the lambda parameters or inside the lambda body
- not allowed to reassign a value to a local varriable
- no restrictions for instance varriables in the lambda expressions 

public static void main(String[] args) {
    int i=0;
    Consumer<Integer> c = (i) -> System.out.println(i);
}
here we will get compilation error as we are trying to use name var name in the lambdas

public static void main(String[] args) {
    int i=0;
    Consumer<Integer> c = (i1) -> {
        int i=2;
        System.out.println(i)};
}
also we cant reassign the local Varriable in the lambda body


int value = 4;
Consumer<Integer> c2 = (i) -> {
    value++; ——————————————> we cant modify the value of the local varriable, they are treated as final or Effectively Final
    System.out.println(value+i);
};
c2.accept(4);
this helps in the building concurrency application


if we make Value as Instance Varriable the error disappears 
public class LambdaVariableRestrictions {
    static int value = 4;
    public static void main(String[] args) {

        Consumer<Integer> c2 = (i) -> {
            value++;
            System.out.println(value+i);
        };
        c2.accept(4);
}}


——————————————————————————————————————————————————————————————————————————————————

Funtional Interfaces - since 1.0 , Simple Abstract Method Interfaces
@FuntionalInterface - optional annotation for the interfaces which was funtional and required when we want to make sure they are not breaking the contract in 1.8

package java.util.function;
4primary - 
- Consumer - BiConsumer 
- Predicate - BiPredicate
- Function - BiFuntion , UnaryOperator
- Suplier 


Consumer  , accept(T t)
Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase()); // here we have defined it 
consumer.accept("java8"); // here we implemented it 

consumer Chaining ->
Consumer<Student> nameConsumer = (s) -> System.out.println("name ="+s.getName() );
Consumer<Student> activitiesConsumer = (s) -> System.out.println("activities ="+s.getActivities());
List<Student> studentList = StudentDataBase.getAllStudents();
studentList.forEach(nameConsumer.andThen(activitiesConsumer));

BiConsumer  accept(T t,U u)
BiConsumer<String,String> biConsumer= (a,b) -> System.out.println("a: "+a+", b:"+b);
biConsumer.accept("java7","java8");

BiConsumer<Integer,Integer> multiply= (a,b) -> System.out.println(a*b);

BiConsumer<Integer,Integer> division= (a,b) -> System.out.println(a/b);
multiply.andThen(division).accept(10,5);

————————————————————————————————————————————————————————————————————————————————
Predicate  test(T t)
Predicate<Integer> checkEven = (i) -> i%2==0;
System.out.println(checkEven.test(4));

Precicate Chaining 
Predicate<Integer> checkEven = (i) -> i%2==0;
Predicate<Integer> checkDivBy5 = (i) -> i%5==0;
 System.out.println("Predicate and operation : "+ checkEven.and(checkDivBy5).test(10));

BiPredicate. test(T t,U u)
——————
BiPredicate<Integer,Double> biP = (gl,gpa) -> gl>=3&&gpa>=3.9;
BiConsumer<String, List<String>> nameAndActivities =(name,activities) -> System.out.println("name "+name+", Activities "+activities);

Consumer<Student> studentConsumer = student -> {
    if(biP.test(student.getGradeLevel(),student.getGpa())){
        nameAndActivities.accept(student.getName(),student.getActivities());
    }};

public void printNamesAndActivities(List<Student> studentList){
    studentList.forEach(studentConsumer);
}

—————————————————————————————————————————————————————————————————————————————————
Function 
we can implement a funtionality as we code a method in java and assign that functionality to a variable. and passing like any varribale
R apply(T t) and defaultMethod -> compose and andThen

Function<String,String> function = (s) -> s.toUpperCase();
System.out.println(function.apply("ankur"));

static Function<String,String> function = (s) -> s.toUpperCase();
static Function<String,String> addString = (s) -> s.concat("default");

System.out.println("result of function "+function.apply("java8"));
System.out.println("result of andThen "+function.andThen(addString).apply("java8"));
System.out.println("result of Compose "+function.compose(addString).apply("java8")); —————————> opposite of Concat

result of function JAVA8
result of andThen JAVA8default
result of Compose JAVA8DEFAULT


Get All the Students with thier GPA and grade>3 , 
static Function<List<Student>, Map<String, Double>> studentMapFunction =
        (list) -> {
            Map<String, Double> studentMap = new HashMap<>();
            list.forEach(student -> {
                if (PredicateStudentEx.p1.test(student)) { ————————————————————> here we can reuse the predicate from another class. 
                    studentMap.put(student.getName(), student.getGpa());
                }
            });
            return studentMap;
        };
List<Student> studentList = StudentDataBase.getAllStudents();
Map<String, Double> studentMap = studentMapFunction.apply(studentList);

this is the advantage of using Funtional Programming , we can use the methods like varriables. 

BiFunction
—————
R apply(T t, U u)
and only andThen() , no concat and Compose 

same thing using bifuntion 
static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionPredicate =
        (list, predicate) -> {
            Map<String, Double> studentMap = new HashMap<>();
            list.forEach(
                    student -> {
                        if (predicate.test(student)) {
                            studentMap.put(student.getName(), student.getGpa());
                        }
                    });
            return studentMap;
        };

System.out.println(biFunctionPredicate.apply(
        StudentDataBase.getAllStudents(),
        PredicateStudentEx.p1
));

UnaryOperator Funtional Interface-> 
public interface UnaryOperator<T> extends Function<T, T> {
we use it when the input and output of the function is of the same type. 

similarly BinaryOperator<T> is used when Bifuntion’s inputs and Output are all of Same type
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
it has minBy and maxBy static methods. 

static BinaryOperator<Integer> binaryOperator = (i,j) -> j*i;
static Comparator<Integer> comparator = (i,j) -> i.compareTo(j);
static BinaryOperator<Integer> binaryOperatorMaxBy = BinaryOperator.maxBy(comparator);
static BinaryOperator<Integer> binaryOperatorMinBy = BinaryOperator.minBy(comparator);

System.out.println(binaryOperator.apply(3,4));
System.out.println(binaryOperatorMaxBy.apply(13,4));
System.out.println(binaryOperatorMinBy.apply(13,4));

————————————————————————————————————————————————————————————————————————————————
Supplier 
T get()
its opposite to Consumer Interface , it doesnt taek any input and supplies output

static Supplier<Student> studentSupplier = () -> new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"));
System.out.println(studentSupplier.get());

————————————————————————————————————————————————————————————————————————————————

METHOD Reference -> 

- sole purpose is to simplify the implementation of Functional Interfaces.
- it simplify the Lamba Expressions where it is refering to the method directly.

ClassName::Instance-methodName
ClassName::static-MethodName
Instance::methodName

example - 
Function<String,String> function = (s) -> s.toUpperCase();
Function<String,String> function1 = String::toUpperCase;

here we can use Method Reference as Method is not getting used directly 
Predicate<Integer> checkEven = (i) -> i%2==0;

static Function<String,String> function = (s) -> s.toUpperCase();
static Function<String,String> toUpperCaseMp = String::toUpperCase;

static Consumer<Student> studentConsumer = (s) -> System.out.println(s);
static Consumer<Student> studentConsumerMp = System.out::println;
static Consumer<Student> printActivities = Student::printListOfActivities;

ConstructorReference
————————————
Classname::new ——————> this invokes the constructors 
example Supplier<Student> studentSupplier = Student::new ———————Student class should have an empty constructor

static Supplier<Student> studentSupplier = Student::new; ———————— this invokes empty constuctor 
static Function<String,Student> stringStudentFunction = Student::new; —— this invokes the constructor with 1 string Param
System.out.println(studentSupplier.get());
System.out.println(stringStudentFunction.apply("ankur"));

————————————————————————————————————————————————————————————————————————————————-
STREAMS API 
——————-
Perfrom Operation on the Collections , Collections helps you manage data in the java application 
paralllel operations can be perfromed to spawn multiple threads. 
can be used with Arrays and I/O 

- Streams is a sequence of elements which can be created out of a collections such as List , Arrays or any kind of I/O

Map<String,List<String>> studentActivitiesMap =
        StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.toMap(Student::getName,Student::getActivities));
System.out.println(studentActivitiesMap);

now comapre this with the below similar code and we see how the number of lines have reduced and code readability improved.

static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionPredicate =
        (list, predicate) -> {
            Map<String, Double> studentMap = new HashMap<>();
            list.forEach(
                    student -> {
                        if (predicate.test(student)) {
                            studentMap.put(student.getName(), student.getGpa());
                        }
                    });
            return studentMap;
        };

——————————————
students with grade level Greater than and equal to 3 

    Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

        Map<String,List<String>> studentActivitiesMapFilter =
                StudentDataBase.getAllStudents()
                        .stream()
//                        .filter(gradePredicate)
                        .filter(gpaPredicate.and(gradePredicate))
                        .collect(Collectors.toMap(Student::getName,Student::getActivities));

How Streams Api Works ? 
————————————
Stream Pipeline -> sequencial operation on the Streams 
Intermediate Oeprations -> takes Streams and returns Stream like Filter and Map 
Terminal Operations -> Terminate the Stream , this actually starts the stream Pipeline , 
they are lazy , no intermediate operations are invoked until the terminal oeprations is invoked.

Comparing Streams and Collection 
Collection	Stream
we can add or modify element at any  point in time list.add(“”)	it is a fixed data set hence thread safe
here we can access the elements from any index . like List.get(4)	we can only access them in a sequence 
they are eagerly created 	they are lazy created
they can be n number of times 	they can be travered only one, if we try we will get IllegalStateException
ExternalIteration to iterate 	InternalIteration to Iterate ForEach

we use Peek Method for debugging 
——————————————————————————————————————————————————————————————————————————————————
-  Map 
Convert(transform ) one type to another

//collect all the Student Names in the List and then print the List
List<String> names = StudentDataBase.getAllStudents()
        .stream()
        .map(Student::getName)
        .collect(Collectors.toList());
System.out.println(names);


- FlatMap
transform from one form of the same type to another form of the same type
it is used when is each element in the stream represent multiple elements. 
Stream<List> , Stream<Array> , each element hold multiple elements. 

/**Print all the student activities in a List.*/
StudentDataBase.getAllStudents()
        .stream()
        .map(Student::getActivities)
        .flatMap(List::stream) ———————————> here we are converting Stream<List<String>> to Stream<String> by list -> list.stream()
        .collect(toList());

- Distinct
returns unique set of elements

- count 
Returns long with the total no. of elements in the stream 

- sorted  
Stream<T> sorted(Comparator<? super T> comparator);
Sort the elements in the Stream. 

StudentDataBase.getAllStudents()
        .stream()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .sorted() —————————————————> this will sort the stream alphabetically 
        .distinct()—————————————————> this will remove the duplicate values. 
        .collect(toList());

System.out.println("Total number of Activities in the School "+StudentDataBase.getAllStudents()
        .stream()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .distinct()
        .count());

/**all the students should be printed in sorted order by thier name*/
Comparator<Student> studentComparator = (student1,student2) -> student1.getName().compareTo(student2.getName());
return StudentDataBase.getAllStudents()
         .stream()
         .sorted(studentComparator)
         .collect(Collectors.toList());

we can also write using method reference : 
return StudentDataBase.getAllStudents()
         .stream()
         .sorted(Comparator.comparing(Student::getName))
         .collect(Collectors.toList());

by thier GPA , in desc 
StudentDataBase.getAllStudents()
         .stream()
         .sorted(Comparator.comparing(Student::getGpa).reversed())
         .collect(Collectors.toList());

- filter
Stream<T> filter(Predicate<? super T> predicate);
//get All the Female Students
StudentDataBase.getAllStudents()
.stream()
.filter(s -> s.getGender().equalsIgnoreCase("female"))
.collect(toList())

- Reduce
reduce the stream contents to a single Value , like max() , count()  etc. 
T reduce(T identity, BinaryOperator<T> accumulator);
when we dont provide the identity we get optional retrun type  - Optional<T> reduce(BinaryOperator<T> accumulator);

List<Integer> listInt = Arrays.asList(1,2,3,4,5);
System.out.println(listInt.stream().reduce(10,Math::multiplyExact).intValue()); ——————> 10 is the starting point

// student with highest Gpa
StudentDataBase.getAllStudents()
        .stream()
        .reduce((s1, s2) -> { ———————————————————————> it is more readable using  reduce((s1, s2) -> s1.getGpa()> s2.getGpa()?s1:s2);
            if (s1.getGpa() > s2.getGpa())
                return s1;
            else
                return s2;
        });

- MapReducePattern 
//total number of notebooks in whole class.
StudentDataBase.getAllStudents()
       .stream()
	.filter(s ->s.getGradeLevel()>=3) ————————-——————> added filter for students with Grade 3 and above 
       .map(Student::getNotebooks) ————————————————> extract All the notebook value
       .reduce(0,Math::addExact); —————————————————> add all the values. also we can use .reduce(0,Integer::sum);

MaxMinReduce
————————
integerList.stream()
        .reduce(Integer::max).get();

 integerList.stream()
        .reduce(Math::min).get();


Limit And Skip
———————
these helps to create a sub-stream 
Limit(5) ——-—> it will only perfrom the operation only on the first 5 
skip(3) ————> it will skip the first3 elements and then start perfroming the operation 

List<Integer> integerList = Arrays.asList(6,7,8,100,9,10);
integerList.stream()
        .limit(4)
        .reduce(Math::addExact);
———————————————————————121

integerList.stream()
        .skip(4)
        .reduce(Math::addExact);
———————————————————-———-19

these are used where we have a huge data set and we dont want to process all of them

AnyMatch AllMatch And NoneMatch()
———————————————————
all of them takes a predicate and returns a boolean
anyMatch() —————> any element in the Stream matches the predicate returns true 
allMatch()——————> all elements in the Stream matches the predicate returns true 
noneMatch()—————> no element in the Stream matches the predicate returns true 

allMatch() = true
StudentDataBase.getAllStudents().stream()
         .allMatch(student -> student.getGpa()>=3.0);

StudentDataBase.getAllStudents().stream()
        .anyMatch(student -> student.getGpa()>=4.0);

StudentDataBase.getAllStudents().stream()
        .noneMatch(student -> student.getGpa()>=4.5);


FindAny() and FindFirst()
————————————
They are similar to Match() of the Streams but they dont accept any input and returns the object Element instead of Boolean 
Optional<T> findFirst(); -  returns the first element in the stream, it will return the first element in the streams running parallely in case of parallel streams
Optional<T> findAny();  -  returns the first encountered element in the stream.

StudentDataBase.getAllStudents()
         .stream()
         .filter(student -> student.getGpa()>=3.9)
         .findAny();

StudentDataBase.getAllStudents()
        .stream()
        .filter(student -> student.getGpa()>=3.9)
        .findFirst();

ShortCircuiting
———————-
the concept is we dont need to go though the whole streams to evaluate the results the stream methods supports shortCircuiting - 
limit() , findAny() findFirst() , anymatch() allMatch() noneMatch()

Factory Methods of Stream Api
——————————————-
1. Of() —————static<T> Stream<T> of(T t)
Creates a Stream of certian Values passed to this method 

Stream<String> stringStream = Stream.of(“adam”, ”dan”, ”julie”);

2. iterate() 
static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
returns an infinite sequential ordered Stream produced by iterative application of a function f to an initial element seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
Stream.iterate(1, x -> x*2);  stream of 1, 1*2, 2*2, 4*2 ………..

3. Generate() 
static<T> Stream<T> generate(Supplier<T> s)
Returns an infinite sequential unordered stream where each element is generated by the provided Supplier. This is suitable for generating constant streams, streams of random elements, etc

Stream.of("adam", "dan", "julie").forEach(System.out::println);
Stream.iterate(1,x -> x*2).limit(10).forEach(System.out::println);
Stream.generate(() -> new Random().nextInt()).limit(10).forEach(System.out::println);

4. empty
static<T> Stream<T> empty()
Returns an empty sequential Stream

————————————————————————————————————————————————————————————————————————————————
Numeric Streams , represents the primitive values in a stream
- IntStream 
- longStream 
- DoubleStream 

//sum of n numbers
List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
System.out.println(integerList.stream()
        .reduce(0,Math::addExact)); ———————————> here there an extra overhead (unboxing) happening of converting the Integer to int primitve type 

we can solve this using IntStream 
System.out.println(IntStream.rangeClosed(1,6)
        .reduce(0,Math::addExact));

IntStream.rangeClosed(1,6) ——————— includes the last element 6  
IntStream.range(1,6) —————————— it doesnt includes the last element. 6 

we can easily convert the IntStream to Double And LongStream as below - 
System.out.println(IntStream.range(1,6).asDoubleStream().sum());
System.out.println(IntStream.range(1,6).asLongStream().max().getAsLong());

autoBoxing() and unBoxing in Streams
——————————————————
System.out.println(IntStream.rangeClosed(1,6)
        .boxed() // ———————————————->  convert to Integer(wrapper)
        .collect(Collectors.toList()));
Created a List<Integer> from IntStream 

System.out.println(integerList.stream()
        .mapToInt(i -> Integer.valueOf(i)) —————> mapToInt returns intStream back and Integer.Valueof(int i) does the unboxing
  	 .sum());

mapToObj() -> convert each element of the numberic Stream to some Object 

System.out.println(IntStream.rangeClosed(1,5)
        .mapToObj(i -> new Integer(i)) ————————> we can also create any CutomeClass object which takes integer as input 
        .collect(Collectors.toList())
);


mapToLong() -> convert each element of the numberic Stream  to Long 
System.out.println(IntStream.rangeClosed(1,5)
        .mapToLong(i -> i) —————————————> this will convert int to Long 
        .max().getAsLong()
);

mapToDouble() -> convert each element of the numberic Stream to Double
System.out.println(IntStream.rangeClosed(1,5)
        .mapToDouble(i -> i)
        .average().getAsDouble()
);

—————————————————————————————————————————————————————————————————————————————————
Terminal Operation 
—————————
its the end of the streams pipeline which collects the data for you from Streams Api
it starts the whole Streams pipeline
eg -> forEach(), min() , max() , findAny() , reduce() , collect() etc

Collect()
————
collect the result after the stream is exhausted. 

Collector.Joining() 
—————————
/**concatenate all the names as part of the student Database*/
return StudentDataBase.getAllStudents()
         .stream()
         .map(Student::getName)
         .collect(Collectors.joining());—————————————-> default version AdamJennyEmilyDaveSophiaJames
 .collect(Collectors.joining("-")); ——————————————> using Delimeter  Adam-Jenny-Emily-Dave-Sophia-James
.collect(Collectors.joining("-","(",")")); ———————————> with Prefix and Sufix  (Adam-Jenny-Emily-Dave-Sophia-James)
 

Collector.Counting()
———————————
StudentDataBase.getAllStudents()
         .stream()
         .filter(student -> student.getGpa()>=3.9)
         .collect(Collectors.counting());———————————> total number of elements in the stream which match the filter 

Collector.mapping() 
——————————
here collector applies a tranformation function first and then collects the data in a collection- any type of collection 
Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
                           Collector<? super U, A, R> downstream)
it takes a function and then the collection to collect the data in it post transformation 

eg -> get all the name in the List 
StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.mapping(Student::getName,Collectors.toList())) ————> this lets us avoid the addiitional Mapping method in previous examples. 

Collector.maxBy minBy
———————————
both takes a comparator 
Collector<T, ?, Optional<T>>maxBy(Comparator<? super T> comparator) 

System.out.println("Student with Least GPA "+
        StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.minBy(Comparator.comparing(Student::getGpa))).get());
System.out.println("Student with Highest GPA "+
        StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa))).get());

Collector.sum() , Avg() 
————————————
summingInt() , averagingInt() 
System.out.println("Summation of all the notebooks "+
        StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.summingInt(Student::getNotebooks))
);

System.out.println("Average of the GPAs "+
        StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingDouble(Student::getGpa))
);

this helps us to use math operations in the collectors. 


Collector.groupingBy() 
——————————-
group the elements based on the property , similar to groupBy in Sql 
Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                      Collector<? super T, A, D> downstream)
it returns a Map and takes a groupBy function and the collection to collect the values. 

//groupBy gpa outstanding gpa>3.8 , average < 3.8
System.out.println(
        StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> {
                    Map<String, String> meritMap = new HashMap<>();
                    if (student.getGpa() > 3.8) meritMap.put("outstanding", student.getName());
                    else meritMap.put("average", student.getName());
                    return meritMap;
                })));

we can also do it in a simpler way 
StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.groupingBy(student -> student.getGpa()>3.8?"Outstanding":"Average")));


//Create a 2level Grouping , based on their grades and then further group with thier grades. 

Map<Integer,Map<String,List<Student>>>
StudentDataBase.getAllStudents()
.stream()
.collect(Collectors.groupingBy(Student::getGradeLevel,
                                Collectors.groupingBy(student -> student.getGpa()>3.8?"Outstanding":"Average")))); —> here we can use any collector implementations 

3rd Lvl grouping
//number of notebooks per grade , Map<Int,Int>
System.out.println(
        StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.summingInt(Student::getNotebooks))));


//we need top GPA in each grade and then Least GPA in each grade 

StudentDataBase.getAllStudents()
        .stream()
        .collect(
                Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))
                )));
but this will return an Optional so we can wrap it under Collectors.CollectingAndThen to get the optional value 
Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
so we will provide the Collector Map<Integer,Optional<Student>> and the function which will take the optional and return the get value
StudentDataBase.getAllStudents()
        .stream()
        .collect(
                Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getGpa)), 
                                Optional::get
                        )
                )));

similarly we get least GPA using ->   Collectors.minBy(Comparator.comparing(Student::getGpa)), 

Collector.paritioningBy() , kind of groupBy
————————————————————
Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)
it takes a predicate and returns a map of key Boolean 
Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate, Collector )

Predicate<Student> gpaPredicate = s -> s.getGpa()>=3.8;
System.out.println( "Partitioning by GPA >=3.8 "+
        StudentDataBase.getAllStudents()
        .stream()
        .collect(Collectors.partitioningBy(
                gpaPredicate
        ))
);
Map<Boolean, List<Student>>
true | list<Students> with GPA >= 3.8
false | list<Students> without GPA >= 3.8

System.out.println( "Partitioning by GPA >=3.8 to SET "+
        StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(
                        gpaPredicate,Collectors.toSet()
                ))
);
here we will get the result into Set
Map<Boolean, Set<Student>>
true | Set<Students> with GPA >= 3.8
false | Set<Students> without GPA >= 3.8

——————————————————————————————————————————————————————————————————————————————————
Parallel Stream 
———————
it uses Fork/Join framework to leverage the number of Threads created = number of processor avilable in the machine  
System.out.println(Runtime.getRuntime().availableProcessors()); = 12

sequential -> processor1 = performing operations 
Prallel -> processor1 = proforming opertion1
		  processor2 = proforming opertion2
		  processor3 = proforming opertion3 		


public static List<String> sequentialStudentActivities(){
    Long startTime = System.currentTimeMillis();
    List<String> studentActivities =  StudentDataBase.getAllStudents()
            .stream()
            .map(Student::getActivities)
            .flatMap(List::stream)
            .sorted()
            .distinct()
            .collect(toList());
    Long endTime = System.currentTimeMillis();
    System.out.println("time to execute Sequential Stream  "+(endTime-startTime));
    return studentActivities;

}

public static List<String> parallelStudentActivities(){
    Long startTime = System.currentTimeMillis();
    List<String> studentActivities =  StudentDataBase.getAllStudents()
            .stream()
            .parallel()
            .map(Student::getActivities)
            .flatMap(List::stream)
            .sorted()
            .distinct()
            .collect(toList());
    Long endTime = System.currentTimeMillis();
    System.out.println("time to execute Parallel Stream  "+(endTime-startTime));
    return studentActivities;
}

public static void main(String[] args) {
    sequentialStudentActivities();
    parallelStudentActivities();
}

result -> 
time to execute Sequential Stream  45
time to execute Parallel Stream  7


when Not to use Parallel Stream 
———————————————
example is unboxing Overhead 
 integerList.stream().reduce(0,(x,y) -> x+y); 
integerList.parallelStream().reduce(0,(x,y) -> x+y); ——————> there is an extra overhead to convering Ingeter to int 

also in the case of mutable varriable , then we shouldnt use parallel streams. 
becuase different threads will see different values of the varriable and do the computation 
——————————————————————————————————————————————————————————————————————————————————
Default and Statis Methods in the Interfaces 
—————————————————————
before java8 we can only declare  methods in the interfaces. since its binding contract for the implementing classes to implement the declared methods. 
this was a serious drawback and cuased the evolution of the interface take a hit as the old classes would start throwing complilation error if we try to add new functionalities in the interfaces. So java creators added the method implementation in the interfaces using static and default keyWords.

Default -> as part of Java8 
in the List Inerface we have the following Default method
default void sort(Comparator<? super E> c) {
    Object[] a = this.toArray();
    Arrays.sort(a, (Comparator) c);
    ListIterator<E> i = this.listIterator();
    for (Object e : a) {
        i.next();
        i.set((E) e);
    }

previous to Java8 we use Collection.sort() to sort the List
also these can be overrriden in the implementing classes.
so used to evolve the interfaces. 

Similarly we can provide additional features to the interfaces using static method. 
the only difference between the default and static method -> static methods cant be overriden in the implementing classes.

List<String> stringList = Arrays.asList("Adam","Jenny","Alex","Dan","Mike","Eric");

//prior java8
Collections.sort(stringList);
System.out.println(stringList);

//Java8
 stringList.sort(Comparator.naturalOrder());
System.out.println(stringList);








 















